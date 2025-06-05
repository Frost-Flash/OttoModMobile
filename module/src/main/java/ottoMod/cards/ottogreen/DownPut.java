/*    */ package ottoMod.cards.ottogreen;
/*    */ 
/*    */

import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import ottoMod.enums.CardColorEnum;

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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DownPut
/*    */   extends CustomCard
/*    */ {
/*    */   public static final String ID = makeId("DownPut");
/* 31 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("DownPut");
/* 32 */   public static final String NAME = cardStrings.NAME;
/* 33 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/* 34 */   public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/otto/DownPut.png";
/*    */   
/*    */   public DownPut() {
/* 38 */     super("DownPut", NAME, "img/otto/DownPut.png", 1, DESCRIPTION, CardType.SKILL, CardColorEnum.ottogreen, CardRarity.RARE, CardTarget.SELF);
/* 39 */     this.magicNumber = this.baseMagicNumber = 3;
/* 40 */     this.exhaust = true;
/*    */   }
/*    */   
/*    */   private static final int COST = 1;
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 47 */     int j = p.discardPile.size();
/* 48 */     if (j < this.magicNumber) {
/* 49 */       for (int k = 0; k < j; k++) {
/* 50 */         AbstractCard c = p.discardPile.getRandomCard(true);
/* 51 */         c.setCostForTurn(c.cost - 1);
/* 52 */         if (p.hand.size() <= 10) {
/* 53 */           p.hand.addToHand(c.makeStatEquivalentCopy());
/* 54 */           p.discardPile.removeCard(c);
/*    */         } 
/*    */       } 
/*    */     } else {
/* 58 */       for (int i = 0; i < this.magicNumber; i++) {
/* 59 */         AbstractCard c = p.discardPile.getRandomCard(true);
/* 60 */         c.setCostForTurn(c.cost - 1);
/* 61 */         if (p.hand.size() <= 10) {
/* 62 */           p.hand.addToHand(c.makeStatEquivalentCopy());
/* 63 */           p.discardPile.removeCard(c);
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 70 */     return (AbstractCard)new DownPut();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 74 */     if (!this.upgraded) {
/* 75 */       upgradeName();
/* 76 */       upgradeMagicNumber(1);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\DownPut.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */