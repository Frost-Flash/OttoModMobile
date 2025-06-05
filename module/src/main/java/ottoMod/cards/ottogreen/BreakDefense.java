/*    */ package ottoMod.cards.ottogreen;
/*    */ 
/*    */

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.tempCards.Shiv;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import ottoMod.enums.CardColorEnum;

import static ottoMod.OttoMod.makeId;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BreakDefense
/*    */   extends CustomCard
/*    */ {
/*    */   public static final String ID = makeId("BreakDefense");
/* 29 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("BreakDefense");
/* 30 */   public static final String NAME = cardStrings.NAME;
/* 31 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/* 32 */   public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/otto/BreakDefense.png";
/*    */   
/*    */   public BreakDefense() {
/* 36 */     super("BreakDefense", NAME, "img/otto/BreakDefense.png", 1, DESCRIPTION, CardType.SKILL, CardColorEnum.ottogreen, CardRarity.UNCOMMON, CardTarget.ENEMY);
/* 37 */     this.magicNumber = this.baseMagicNumber = 1;
/* 38 */     this.cardsToPreview = (AbstractCard)new Shiv();
/*    */   }
/*    */   private static final int COST = 1;
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 43 */     addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)m, (AbstractCreature)p, (AbstractPower)new VulnerablePower((AbstractCreature)m, this.magicNumber, false), this.magicNumber));
/* 44 */     if (m.hasPower("Weakened")) {
/* 45 */       addToBot((AbstractGameAction)new RemoveSpecificPowerAction((AbstractCreature)m, (AbstractCreature)p, "Weakened"));
/* 46 */       addToBot((AbstractGameAction)new MakeTempCardInHandAction((AbstractCard)new Shiv(), this.magicNumber + 2));
/*    */     } 
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 51 */     return (AbstractCard)new BreakDefense();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 55 */     if (!this.upgraded) {
/* 56 */       upgradeName();
/* 57 */       upgradeMagicNumber(1);
/* 58 */       this.rawDescription = UPGRADE_DESCRIPTION;
/* 59 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\BreakDefense.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */