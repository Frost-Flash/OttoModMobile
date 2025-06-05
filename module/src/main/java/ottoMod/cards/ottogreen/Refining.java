/*    */ package ottoMod.cards.ottogreen;
/*    */ 
/*    */

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.ExhaustAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import ottoMod.enums.CardColorEnum;
import ottoMod.powers.Fury;

import static ottoMod.OttoMod.makeId;
/*    */ 
/*    */ 
/*    */ public class Refining
/*    */   extends CustomCard
/*    */ {
/*    */   public static final String ID = makeId("Refining");
/* 24 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Refining");
/* 25 */   public static final String NAME = cardStrings.NAME;
/* 26 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/* 27 */   public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/otto/Refining.png";
/*    */   private static final int COST = 2;
/* 30 */   private static final CardType TYPE = CardType.ATTACK;
/* 31 */   private static final CardColor COLOR = CardColorEnum.ottogreen;
/* 32 */   private static final CardRarity RARITY = CardRarity.COMMON;
/* 33 */   private static final CardTarget TARGET = CardTarget.ENEMY;
/*    */   public Refining() {
/* 35 */     super("Refining", NAME, "img/otto/Refining.png", 2, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
/* 36 */     this.baseDamage = 16;
/*    */   }
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 40 */     addToBot((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.FIRE));
/* 41 */     addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new Fury((AbstractCreature)p, 2), 2));
/* 42 */     if (p.hasPower("OttoMod:Delicious")) {
/* 43 */       addToBot((AbstractGameAction)new ExhaustAction(2, false, true, true));
/*    */     }
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 48 */     return (AbstractCard)new Refining();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 52 */     if (!this.upgraded) {
/* 53 */       upgradeName();
/* 54 */       upgradeDamage(6);
/* 55 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\Refining.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */