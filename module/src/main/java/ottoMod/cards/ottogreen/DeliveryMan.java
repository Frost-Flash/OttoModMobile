/*    */ package ottoMod.cards.ottogreen;
/*    */ 
/*    */

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
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
/*    */ public class DeliveryMan
/*    */   extends CustomCard
/*    */ {
/*    */   public static final String ID = makeId("DeliveryMan");
/* 27 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("DeliveryMan");
/* 28 */   public static final String NAME = cardStrings.NAME;
/* 29 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/* 30 */   public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/otto/DeliveryMan.png";
/*    */   
/*    */   public DeliveryMan() {
/* 34 */     super("DeliveryMan", NAME, "img/otto/DeliveryMan.png", 2, DESCRIPTION, CardType.POWER, CardColorEnum.ottogreen, CardRarity.RARE, CardTarget.SELF);
/* 35 */     this.isInnate = true;
/* 36 */     this.isEthereal = true;
/* 37 */     Dumpling dumpling = new Dumpling();
/* 38 */     dumpling.upgrade();
/* 39 */     this.cardsToPreview = (AbstractCard)dumpling;
/* 40 */     this.tags.add(CardTags.HEALING);
/*    */   }
/*    */   private static final int COST = 2;
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 44 */     Dumpling dumpling = new Dumpling();
/* 45 */     dumpling.upgrade();
/* 46 */     addToBot((AbstractGameAction)new MakeTempCardInHandAction((AbstractCard)dumpling, 1));
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 50 */     return (AbstractCard)new DeliveryMan();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 54 */     if (!this.upgraded) {
/* 55 */       upgradeName();
/* 56 */       upgradeBaseCost(1);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\DeliveryMan.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */