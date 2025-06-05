/*    */ package ottoMod.cards.ottogreen;
/*    */ 
/*    */

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import ottoMod.effects.PushWheelEffect;
import ottoMod.enums.CardColorEnum;
import ottoMod.enums.CustomTags;

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
/*    */ public class Dashing
/*    */   extends CustomCard
/*    */ {
/*    */   public static final String ID = makeId("Dashing");
/* 32 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Dashing");
/* 33 */   public static final String NAME = cardStrings.NAME;
/* 34 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/* 35 */   public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/otto/Dashing.png";
/*    */   
/*    */   public Dashing() {
/* 39 */     super("Dashing", NAME, "img/otto/Dashing.png", 0, DESCRIPTION, CardType.SKILL, CardColorEnum.ottogreen, CardRarity.SPECIAL, CardTarget.NONE);
/* 40 */     this.magicNumber = this.baseMagicNumber = 1;
/* 41 */     this.tags.add(CustomTags.DASHING);
/* 42 */     this.exhaust = true;
/*    */   }
/*    */   private static final int COST = 0;
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 47 */     (new PushWheelEffect()).trigger(this.magicNumber);
/* 48 */     if (p.hasPower("OttoMod:Delicious")) {
/* 49 */       addToBot((AbstractGameAction)new DrawCardAction((AbstractCreature)p, 1));
/*    */     }
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 54 */     return (AbstractCard)new Dashing();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 58 */     if (!this.upgraded) {
/* 59 */       upgradeName();
/* 60 */       upgradeMagicNumber(1);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\Dashing.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */