/*    */ package ottoMod.cards.ottogreen;
/*    */ 
/*    */

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.tempCards.Shiv;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
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
/*    */ public class WorldNo1
/*    */   extends CustomCard
/*    */ {
/*    */   public static final String ID = makeId("WorldNo1");
/* 27 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("WorldNo1");
/* 28 */   public static final String NAME = cardStrings.NAME;
/* 29 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/* 30 */   public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/otto/WorldNo1.png";
/*    */   
/*    */   public WorldNo1() {
/* 34 */     super("WorldNo1", NAME, "img/otto/WorldNo1.png", 1, DESCRIPTION, CardType.POWER, CardColorEnum.ottogreen, CardRarity.RARE, CardTarget.SELF);
/* 35 */     this.magicNumber = this.baseMagicNumber = 1;
/* 36 */     this.cardsToPreview = (AbstractCard)new Shiv();
/*    */   }
/*    */   private static final int COST = 1;
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 40 */     addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new ottoMod.powers.WorldNo1((AbstractCreature)p, this.magicNumber), this.magicNumber));
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 44 */     return (AbstractCard)new WorldNo1();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 48 */     if (!this.upgraded) {
/* 49 */       upgradeName();
/* 50 */       upgradeMagicNumber(1);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\WorldNo1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */