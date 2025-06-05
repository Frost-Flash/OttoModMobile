/*    */ package ottoMod.powers;
/*    */ 
/*    */

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import ottoMod.OttoMod;

/*    */
/*    */ public class ProfessionForm extends AbstractPower {
/* 11 */   private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings("OttoMod:ProfessionForm"); public static final String POWER_ID = OttoMod.makeId("ProfessionForm");
/* 12 */   private static final String NAME = powerStrings.NAME;
/* 13 */   private static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
/*    */   public ProfessionForm(AbstractCreature owner, int amount) {
/* 15 */     this.name = NAME;
/* 16 */     this.ID = "OttoMod:ProfessionForm";
/* 17 */     this.owner = owner;
/* 18 */     this.amount = amount;
/* 19 */     this.type = PowerType.BUFF;
/* 20 */     loadRegion("demonForm");
/* 21 */     updateDescription();
/*    */   }
/*    */   
/*    */   public void atStartOfTurn() {
/* 25 */     flash();
/* 26 */     addToBot((AbstractGameAction)new ApplyPowerAction(this.owner, this.owner, new WheelBoostPower(this.owner, this.amount), this.amount));
/*    */   }
/*    */ 
/*    */   
/*    */   public void stackPower(int stackAmount) {
/* 31 */     super.stackPower(stackAmount);
/* 32 */     updateDescription();
/*    */   }
/*    */   
/*    */   public void updateDescription() {
/* 36 */     this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\powers\ProfessionForm.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */