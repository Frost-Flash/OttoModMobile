/*    */ package ottoMod.powers;
/*    */ 
/*    */

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.tempCards.Shiv;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import ottoMod.OttoMod;
import ottoMod.enums.CustomTags;
/*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WorldNo1
/*    */   extends AbstractPower
/*    */ {
/*    */   public static final String POWER_ID = OttoMod.makeId("WorldNo1");
/* 23 */   private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings("OttoMod:WorldNo1");
/* 24 */   private static final String NAME = powerStrings.NAME;
/* 25 */   private static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
/*    */   public WorldNo1(AbstractCreature owner, int amount) {
/* 27 */     this.name = NAME;
/* 28 */     this.ID = "OttoMod:WorldNo1";
/* 29 */     this.owner = owner;
/* 30 */     this.amount = amount;
/* 31 */     this.type = PowerType.BUFF;
/* 32 */     loadRegion("envenom");
/* 33 */     updateDescription();
/*    */   }
/*    */   
/*    */   public void updateDescription() {
/* 37 */     this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
/*    */   }
/*    */   
/*    */   public void onUseCard(AbstractCard card, UseCardAction action) {
/* 41 */     if (card.hasTag(CustomTags.DASHING)) {
/* 42 */       Shiv shiv = new Shiv();
/* 43 */       shiv.upgrade();
/* 44 */       addToBot((AbstractGameAction)new MakeTempCardInHandAction(AbstractDungeon.player.hasPower("OttoMod:Delicious") ? (AbstractCard)shiv : (AbstractCard)new Shiv(), this.amount));
/*    */     } 
/*    */   }
/*    */   
/*    */   public void stackPower(int stackAmount) {
/* 49 */     super.stackPower(stackAmount);
/* 50 */     if (this.amount > 999) {
/* 51 */       this.amount = 999;
/*    */     }
/* 53 */     if (this.amount <= 0) {
/* 54 */       AbstractDungeon.actionManager.addToTop((AbstractGameAction)new RemoveSpecificPowerAction(this.owner, this.owner, "OttoMod:WorldNo1"));
/*    */     }
/*    */     
/* 57 */     updateDescription();
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\powers\WorldNo1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */