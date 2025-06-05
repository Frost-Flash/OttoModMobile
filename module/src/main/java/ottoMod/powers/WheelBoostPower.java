/*    */ package ottoMod.powers;
/*    */ 
/*    */

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import ottoMod.OttoMod;
/*    */
/*    */ 
/*    */ public class WheelBoostPower
/*    */   extends AbstractPower
/*    */ {
/*    */   public static final String POWER_ID = OttoMod.makeId("WheelBoostPower");
/* 16 */   private static final PowerStrings powerStrings = CardCrawlGame.languagePack
/* 17 */     .getPowerStrings("OttoMod:WheelBoostPower");
/* 18 */   private static final String NAME = powerStrings.NAME;
/* 19 */   private static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
/*    */   
/*    */   public WheelBoostPower(AbstractCreature owner, int amount) {
/* 22 */     this.name = NAME;
/* 23 */     this.ID = "OttoMod:WheelBoostPower";
/* 24 */     this.owner = owner;
/* 25 */     this.amount = amount;
/* 26 */     this.type = PowerType.BUFF;
/* 27 */     loadRegion("accuracy");
/* 28 */     hasBoost = (owner != null && owner.hasPower("OttoMod:WheelBoostPower"));
/* 29 */     this.canGoNegative = true;
/* 30 */     updateDescription();
/*    */   }
/*    */   private static boolean hasBoost = false;
/*    */   public void onInitialApplication() {
/* 34 */     hasBoost = true;
/*    */   }
/*    */   
/*    */   public void stackPower(int stackAmount) {
/* 38 */     this.fontScale = 8.0F;
/* 39 */     this.amount += stackAmount;
/* 40 */     if (this.amount == 0) {
/* 41 */       addToTop((AbstractGameAction)new RemoveSpecificPowerAction(this.owner, this.owner, this.ID));
/*    */     }
/* 43 */     if (this.amount >= 999) {
/* 44 */       this.amount = 999;
/*    */     }
/* 46 */     if (this.amount <= -999)
/* 47 */       this.amount = -999; 
/* 48 */     updateDescription();
/*    */   }
/*    */   public static boolean hasBoost() {
/* 51 */     return hasBoost;
/*    */   }
/*    */   public static int getTotalBoost() {
/* 54 */     AbstractPower p = AbstractDungeon.player.getPower("OttoMod:WheelBoostPower");
/* 55 */     return (p != null) ? p.amount : 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public void reducePower(int reduceAmount) {
/* 60 */     super.reducePower(reduceAmount);
/* 61 */     this.fontScale = 8.0F;
/* 62 */     this.amount -= reduceAmount;
/* 63 */     if (this.amount == 0) {
/* 64 */       addToTop((AbstractGameAction)new RemoveSpecificPowerAction(this.owner, this.owner, NAME));
/*    */     }
/*    */     
/* 67 */     if (this.amount >= 999) {
/* 68 */       this.amount = 999;
/*    */     }
/*    */     
/* 71 */     if (this.amount <= -999)
/* 72 */       this.amount = -999; 
/* 73 */     updateDescription();
/*    */   }
/*    */   
/*    */   public void playApplyPowerSfx() {
/*    */   }
/*    */   
/*    */   public void updateDescription() {
/* 81 */     if (this.amount > 0) {
/* 82 */       this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[2];
/* 83 */       this.type = PowerType.BUFF;
/* 84 */     } else if (this.amount != 0) {
/* 85 */       int tmp = -this.amount;
/* 86 */       this.description = DESCRIPTIONS[1] + tmp + DESCRIPTIONS[2];
/* 87 */       this.type = PowerType.DEBUFF;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\powers\WheelBoostPower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */