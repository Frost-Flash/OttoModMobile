/*    */ package ottoMod.cards.ottogreen;
/*    */ 
/*    */

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import ottoMod.effects.PushWheelEffect;
import ottoMod.enums.CardColorEnum;
import ottoMod.powers.Fury;

import static ottoMod.OttoMod.makeId;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class OttoKing
/*    */   extends CustomCard
/*    */ {
/*    */   public static final String ID = makeId("OttoKing");
/* 26 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("OttoKing");
/* 27 */   public static final String NAME = cardStrings.NAME;
/* 28 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/* 29 */   public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/otto/OttoKing.png";
/*    */   
/*    */   public OttoKing() {
/* 33 */     super("OttoKing", NAME, "img/otto/OttoKing.png", 1, DESCRIPTION, CardType.SKILL, CardColorEnum.ottogreen, CardRarity.COMMON, CardTarget.SELF);
/* 34 */     this.block = this.baseBlock = 8;
/* 35 */     this.magicNumber = this.baseMagicNumber = 1;
/*    */   }
/*    */   private static final int COST = 1;
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 39 */     addToBot((AbstractGameAction)new GainBlockAction((AbstractCreature)p, (AbstractCreature)p, this.block));
/* 40 */     (new PushWheelEffect()).trigger(this.magicNumber);
/* 41 */     addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new Fury((AbstractCreature)p, this.magicNumber), this.magicNumber));
/* 42 */     if (p.hasPower("OttoMod:Delicious")) {
/* 43 */       addToBot((AbstractGameAction)new DrawCardAction((AbstractCreature)p, this.magicNumber));
/*    */     }
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 48 */     return (AbstractCard)new OttoKing();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 52 */     if (!this.upgraded) {
/* 53 */       upgradeName();
/* 54 */       upgradeMagicNumber(1);
/* 55 */       upgradeBlock(1);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\OttoKing.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */