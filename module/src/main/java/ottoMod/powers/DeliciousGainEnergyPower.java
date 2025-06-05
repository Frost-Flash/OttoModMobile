/*    */ package ottoMod.powers;
/*    */ 
/*    */

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.EnergizedPower;
import ottoMod.OttoMod;
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
/*    */ public class DeliciousGainEnergyPower
/*    */   extends AbstractPower
/*    */ {
/*    */   public static final String POWER_ID = OttoMod.makeId("DeliciousGainEnergyPower");
/* 28 */   private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings("OttoMod:DeliciousGainEnergyPower");
/* 29 */   private static final String NAME = powerStrings.NAME;
/* 30 */   private static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
/*    */   public DeliciousGainEnergyPower(AbstractCreature owner, int amount) {
/* 32 */     this.name = NAME;
/* 33 */     this.ID = "OttoMod:DeliciousGainEnergyPower";
/* 34 */     this.owner = owner;
/* 35 */     this.type = PowerType.BUFF;
/* 36 */     this.amount = amount;
/* 37 */     loadRegion("berserk");
/* 38 */     updateDescription();
/*    */   }
/*    */   public void updateDescription() {
/* 41 */     StringBuilder sb = new StringBuilder();
/* 42 */     sb.append(DESCRIPTIONS[0]);
/* 43 */     for (int i = 0; i < this.amount; i++) {
/* 44 */       sb.append("[G] ");
/*    */     }
/* 46 */     sb.append(DESCRIPTIONS[1]);
/* 47 */     this.description = sb.toString();
/*    */   }
/*    */   
/*    */   public void atStartOfTurnPostDraw() {
/* 51 */     if (AbstractDungeon.player.hasPower("OttoMod:Delicious")) {
/* 52 */       addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)AbstractDungeon.player, (AbstractCreature)AbstractDungeon.player, (AbstractPower)new EnergizedPower((AbstractCreature)AbstractDungeon.player, this.amount), this.amount));
/* 53 */       flash();
/*    */     } 
/*    */   }
/*    */   
/*    */   public void onInitialApplication() {
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\powers\DeliciousGainEnergyPower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */