/*    */ package ottoMod.cards.ottogreen;
/*    */ 
/*    */

import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.AbstractGameEffect;
import com.megacrit.cardcrawl.vfx.BorderLongFlashEffect;
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
/*    */ 
/*    */ 
/*    */ public class GodsRevival
/*    */   extends CustomCard
/*    */ {
/*    */   public static final String ID = makeId("GodsRevival");
/* 32 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("GodsRevival");
/* 33 */   public static final String NAME = cardStrings.NAME;
/* 34 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/* 35 */   public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/otto/GodsRevival.png";
/*    */   
/*    */   public GodsRevival() {
/* 39 */     super("GodsRevival", NAME, "img/otto/GodsRevival.png", 1, DESCRIPTION, CardType.SKILL, CardColorEnum.ottogreen, CardRarity.SPECIAL, CardTarget.NONE);
/* 40 */     this.magicNumber = this.baseMagicNumber = 4;
/* 41 */     this.cardsToPreview = (AbstractCard)new GodsSigh();
/* 42 */     this.exhaust = true;
/*    */   }
/*    */   private static final int COST = 1;
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 46 */     addToBot((AbstractGameAction)new VFXAction((AbstractGameEffect)new BorderLongFlashEffect(Color.BLACK)));
/* 47 */     GodsSigh godsSigh = new GodsSigh();
/* 48 */     godsSigh.upgrade();
/* 49 */     (new PushWheelEffect()).trigger(this.magicNumber);
/* 50 */     addToBot((AbstractGameAction)new MakeTempCardInDrawPileAction(!this.upgraded ? (AbstractCard)new GodsSigh() : (AbstractCard)godsSigh, 1, true, true));
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 54 */     return (AbstractCard)new GodsRevival();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 58 */     if (!this.upgraded) {
/* 59 */       upgradeName();
/* 60 */       upgradeMagicNumber(1);
/* 61 */       this.rawDescription = UPGRADE_DESCRIPTION;
/* 62 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\GodsRevival.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */