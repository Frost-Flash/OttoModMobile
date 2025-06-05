/*    */ package ottoMod.powers;
/*    */ 
/*    */

import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import ottoMod.OttoMod;
import ottoMod.effects.PushWheelEffect;
/*    */
/*    */ public class TurnStartPushPower
/*    */   extends AbstractPower
/*    */ {
/*    */   public static final String POWER_ID = OttoMod.makeId("TurnStartPushPower");
/* 13 */   private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings("OttoMod:TurnStartPushPower");
/* 14 */   private static final String NAME = powerStrings.NAME;
/* 15 */   private static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
/*    */   public TurnStartPushPower(AbstractCreature owner, int amount) {
/* 17 */     this.name = NAME;
/* 18 */     this.ID = "OttoMod:TurnStartPushPower";
/* 19 */     this.owner = owner;
/* 20 */     this.amount = amount;
/* 21 */     this.type = PowerType.BUFF;
/* 22 */     loadRegion("loop");
/* 23 */     updateDescription();
/*    */   }
/*    */   
/*    */   public void stackPower(int stackAmount) {
/* 27 */     super.stackPower(stackAmount);
/* 28 */     updateDescription();
/*    */   }
/*    */   
/*    */   public void updateDescription() {
/* 32 */     this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
/*    */   }
/*    */ 
/*    */   
/*    */   public void atStartOfTurnPostDraw() {
/* 37 */     flash();
/* 38 */     (new PushWheelEffect()).trigger(this.amount);
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\powers\TurnStartPushPower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */