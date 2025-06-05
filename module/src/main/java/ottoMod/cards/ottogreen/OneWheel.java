/*    */ package ottoMod.cards.ottogreen;
/*    */ 
/*    */

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import ottoMod.enums.CardColorEnum;

import static ottoMod.OttoMod.makeId;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class OneWheel
/*    */   extends CustomCard
/*    */ {
/*    */   public static final String ID = makeId("OneWheel");
/* 23 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("OneWheel");
/* 24 */   public static final String NAME = cardStrings.NAME;
/* 25 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/* 26 */   public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/otto/OneWheel.png";
/*    */   
/*    */   public OneWheel() {
/* 30 */     super("OneWheel", NAME, "img/otto/OneWheel.png", 1, DESCRIPTION, CardType.ATTACK, CardColorEnum.ottogreen, CardRarity.UNCOMMON, CardTarget.ENEMY);
/* 31 */     this.baseDamage = 10;
/* 32 */     this.isEthereal = true;
/*    */   }
/*    */   private static final int COST = 1;
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 36 */     addToBot((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.FIRE));
/* 37 */     OneWheel oneWheel = new OneWheel();
/* 38 */     if (!this.upgraded) {
/* 39 */       addToBot((AbstractGameAction)new MakeTempCardInHandAction((AbstractCard)new OneWheel(), 1));
/*    */     } else {
/*    */       
/* 42 */       oneWheel.upgrade();
/* 43 */       addToBot((AbstractGameAction)new MakeTempCardInHandAction((AbstractCard)oneWheel, 1));
/*    */     } 
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 48 */     return (AbstractCard)new OneWheel();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 54 */     if (!this.upgraded) {
/* 55 */       upgradeName();
/* 56 */       upgradeDamage(2);
/* 57 */       this.rawDescription = UPGRADE_DESCRIPTION;
/* 58 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\OneWheel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */