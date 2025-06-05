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
/*    */ public class HeadMarkG
/*    */   extends AbstractPower
/*    */ {
/*    */   public static final String POWER_ID = OttoMod.makeId("HeadMarkG");
/* 26 */   private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings("OttoMod:HeadMarkG");
/* 27 */   private static final String NAME = powerStrings.NAME;
/* 28 */   private static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
/*    */   public HeadMarkG(AbstractCreature owner, int amount) {
/* 30 */     this.name = NAME;
/* 31 */     this.ID = "OttoMod:HeadMarkG";
/* 32 */     this.owner = owner;
/* 33 */     this.amount = amount;
/* 34 */     this.type = PowerType.BUFF;
/* 35 */     loadRegion("evolve");
/* 36 */     updateDescription();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void updateDescription() {
/* 42 */     this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
/*    */   }
/*    */   
/*    */   public void onApplyPower(AbstractPower power, AbstractCreature target, AbstractCreature source) {
/* 46 */     if (power.ID.equals("OttoMod:Fury") && target.isPlayer) {
/* 47 */       (new PushWheelEffect()).trigger(this.amount);
/*    */     }
/*    */   }
/*    */   
/*    */   public void stackPower(int stackAmount) {
/* 52 */     super.stackPower(stackAmount);
/* 53 */     updateDescription();
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\powers\HeadMarkG.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */