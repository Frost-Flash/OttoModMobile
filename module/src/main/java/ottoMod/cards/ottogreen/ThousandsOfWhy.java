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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ThousandsOfWhy
/*    */   extends CustomCard
/*    */ {
/*    */   public static final String ID = makeId("ThousandsOfWhy");
/* 40 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("ThousandsOfWhy");
/* 41 */   public static final String NAME = cardStrings.NAME;
/* 42 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/* 43 */   public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/otto/ThousandsOfWhy.png";
/*    */   
/*    */   public ThousandsOfWhy() {
/* 47 */     super("ThousandsOfWhy", NAME, "img/otto/ThousandsOfWhy.png", 1, DESCRIPTION, CardType.POWER, CardColorEnum.ottogreen, CardRarity.UNCOMMON, CardTarget.SELF);
/* 48 */     this.magicNumber = this.baseMagicNumber = 1;
/*    */   }
/*    */   private static final int COST = 1;
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 52 */     addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new ottoMod.powers.ThousandsOfWhy((AbstractCreature)p, this.magicNumber), this.magicNumber));
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 56 */     return (AbstractCard)new ThousandsOfWhy();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 60 */     if (!this.upgraded) {
/* 61 */       upgradeName();
/* 62 */       upgradeMagicNumber(1);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\ThousandsOfWhy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */