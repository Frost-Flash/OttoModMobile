/*    */ package ottoMod.cards.ottogreen;
/*    */ 
/*    */

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.FrailPower;
import ottoMod.enums.CardColorEnum;
import ottoMod.powers.Fury;

import static ottoMod.OttoMod.makeId;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NotAngry
/*    */   extends CustomCard
/*    */ {
/*    */   public static final String ID = makeId("NotAngry");
/* 32 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("NotAngry");
/* 33 */   public static final String NAME = cardStrings.NAME;
/* 34 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/* 35 */   public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/otto/NotAngry.png";
/*    */   private static final int COST = 1;
/* 38 */   private static final CardType TYPE = CardType.SKILL;
/*    */   public NotAngry() {
/* 40 */     super("NotAngry", NAME, "img/otto/NotAngry.png", 1, DESCRIPTION, TYPE, CardColorEnum.ottogreen, CardRarity.UNCOMMON, CardTarget.SELF);
/* 41 */     this.magicNumber = this.baseMagicNumber = 2;
/* 42 */     this.exhaust = true;
/*    */   }
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 47 */     addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new Fury((AbstractCreature)p, 6), 6));
/* 48 */     addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new FrailPower((AbstractCreature)p, this.magicNumber, false), this.magicNumber));
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 52 */     return (AbstractCard)new NotAngry();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 56 */     if (!this.upgraded) {
/* 57 */       upgradeName();
/* 58 */       upgradeMagicNumber(-1);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\NotAngry.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */