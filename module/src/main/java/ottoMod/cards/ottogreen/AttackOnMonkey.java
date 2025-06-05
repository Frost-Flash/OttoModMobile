/*    */ package ottoMod.cards.ottogreen;
/*    */ 
/*    */

import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import ottoMod.effects.PushWheelEffect;
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
/*    */ public class AttackOnMonkey
/*    */   extends CustomCard
/*    */ {
/*    */   public static final String ID = makeId("AttackOnMonkey");
/* 26 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("AttackOnMonkey");
/* 27 */   public static final String NAME = cardStrings.NAME;
/* 28 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/* 29 */   public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/otto/AttackOnMonkey.png";
/*    */   
/*    */   public AttackOnMonkey() {
/* 33 */     super("AttackOnMonkey", NAME, "img/otto/AttackOnMonkey.png", 5, DESCRIPTION, CardType.SKILL, CardColorEnum.ottogreen, CardRarity.RARE, CardTarget.SELF);
/* 34 */     this.exhaust = true;
/* 35 */     this.magicNumber = this.baseMagicNumber = 12;
/*    */   }
/*    */   private static final int COST = 5;
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 40 */     (new PushWheelEffect()).trigger(this.magicNumber);
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 45 */     if (!this.upgraded) {
/* 46 */       upgradeName();
/* 47 */       upgradeMagicNumber(3);
/* 48 */       this.rawDescription = this.upgraded ? UPGRADE_DESCRIPTION : DESCRIPTION;
/* 49 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 54 */     return (AbstractCard)new AttackOnMonkey();
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\AttackOnMonkey.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */