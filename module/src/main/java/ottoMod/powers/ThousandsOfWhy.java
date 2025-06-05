/*    */ package ottoMod.powers;
/*    */ 
/*    */

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.NextTurnBlockPower;
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
/*    */ public class ThousandsOfWhy
/*    */   extends AbstractPower
/*    */ {
/*    */   public static final String POWER_ID = OttoMod.makeId("ThousandsOfWhy");
/* 28 */   private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings("OttoMod:ThousandsOfWhy");
/* 29 */   private static final String NAME = powerStrings.NAME;
/* 30 */   private static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
/*    */   public ThousandsOfWhy(AbstractCreature owner, int amount) {
/* 32 */     this.name = NAME;
/* 33 */     this.ID = "OttoMod:ThousandsOfWhy";
/* 34 */     this.owner = owner;
/* 35 */     this.amount = amount;
/* 36 */     this.type = PowerType.BUFF;
/* 37 */     loadRegion("afterImage");
/* 38 */     updateDescription();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void updateDescription() {
/* 44 */     this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
/*    */   }
/*    */   
/*    */   public void onInitialApplication() {
/*    */   }
/*    */   
/*    */   public void onUseCard(AbstractCard card, UseCardAction action) {
/* 52 */     addToBot((AbstractGameAction)new ApplyPowerAction(this.owner, this.owner, (AbstractPower)new NextTurnBlockPower(this.owner, this.amount), this.amount));
/* 53 */     flash();
/*    */   }
/*    */   
/*    */   public void stackPower(int stackAmount) {
/* 57 */     super.stackPower(stackAmount);
/* 58 */     if (this.amount > 999) {
/* 59 */       this.amount = 999;
/*    */     }
/* 61 */     if (this.amount <= 0) {
/* 62 */       AbstractDungeon.actionManager.addToTop((AbstractGameAction)new RemoveSpecificPowerAction(this.owner, this.owner, "OttoMod:ThousandsOfWhy"));
/*    */     }
/*    */     
/* 65 */     updateDescription();
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\powers\ThousandsOfWhy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */