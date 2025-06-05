/*    */ package ottoMod.powers;
/*    */ 
/*    */

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import ottoMod.OttoMod;
import ottoMod.cards.ottogreen.Dashing;

/*    */

/*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class InfiniteDashingPower
/*    */   extends AbstractPower
/*    */ {
/*    */   public static final String POWER_ID = OttoMod.makeId("InfiniteDashingPower");
/* 25 */   private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings("OttoMod:InfiniteDashingPower");
/* 26 */   private static final String NAME = powerStrings.NAME;
/* 27 */   private static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
/*    */   public InfiniteDashingPower(AbstractCreature owner, int dashingAmt) {
/* 29 */     this.name = NAME;
/* 30 */     this.ID = "OttoMod:InfiniteDashingPower";
/* 31 */     this.owner = owner;
/* 32 */     this.amount = dashingAmt;
/* 33 */     this.type = PowerType.BUFF;
/* 34 */     loadRegion("infiniteBlades");
/* 35 */     updateDescription();
/*    */   }
/*    */ 
/*    */   
/*    */   public void updateDescription() {
/* 40 */     this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
/*    */   }
/*    */   
/*    */   public void atStartOfTurn() {
/* 44 */     if (!AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
/* 45 */       flash();
/* 46 */       addToBot((AbstractGameAction)new MakeTempCardInHandAction((AbstractCard)new Dashing(), this.amount, false));
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void stackPower(int stackAmount) {
/* 52 */     this.fontScale = 8.0F;
/* 53 */     this.amount += stackAmount;
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\powers\InfiniteDashingPower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */