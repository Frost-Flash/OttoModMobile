/*    */ package ottoMod.powers;
/*    */ 
/*    */

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.android.mods.AssetLoader;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
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
/*    */ public class Fury
/*    */   extends AbstractPower
/*    */ {
/*    */   public static final String POWER_ID = OttoMod.makeId("Fury");
/* 31 */   private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings("OttoMod:Fury");
/* 32 */   private static final String NAME = powerStrings.NAME;
/* 33 */   private static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
/*    */   public Fury(AbstractCreature owner, int amount) {
/* 35 */     this.name = NAME;
/* 36 */     this.ID = "OttoMod:Fury";
/* 37 */     this.owner = owner;
/* 38 */     this.amount = amount;
/* 39 */     this.type = PowerType.BUFF;
/* 40 */     String path128 = "img/UI_Otto/Example84.png";
/* 41 */     String path48 = "img/UI_Otto/Example32.png";
/* 42 */     this.region128 = new TextureAtlas.AtlasRegion(AssetLoader.getTexture(OttoMod.MOD_ID,path128), 0, 0, 84, 84);
/* 43 */     this.region48 = new TextureAtlas.AtlasRegion(AssetLoader.getTexture(OttoMod.MOD_ID,path48), 0, 0, 32, 32);
/* 44 */     updateDescription();
/*    */   }
/*    */   
/*    */   public void updateDescription() {
/* 48 */     this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public float atDamageGive(float damage, DamageInfo.DamageType type) {
/* 54 */     if (type == DamageInfo.DamageType.NORMAL) {
/* 55 */       return damage + this.amount;
/*    */     }
/* 57 */     return damage;
/*    */   }
/*    */ 
/*    */   
/*    */   public void onUseCard(AbstractCard card, UseCardAction action) {
/* 62 */     if (card.type == AbstractCard.CardType.ATTACK)
/*    */     {
/* 64 */       addToBot(new AbstractGameAction()
/*    */           {
/*    */             public void update() {
/* 67 */               addToTop((AbstractGameAction)new ReducePowerAction(Fury.this.owner, Fury.this.owner, "OttoMod:Fury", 1));
/* 68 */               this.isDone = true;
/*    */             }
/*    */           });
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void stackPower(int stackAmount) {
/* 76 */     super.stackPower(stackAmount);
/* 77 */     if (this.amount > 999) {
/* 78 */       this.amount = 999;
/*    */     }
/* 80 */     if (this.amount <= 0) {
/* 81 */       AbstractDungeon.actionManager.addToTop((AbstractGameAction)new RemoveSpecificPowerAction(this.owner, this.owner, "OttoMod:Fury"));
/*    */     }
/*    */     
/* 84 */     updateDescription();
/*    */   }
/*    */ 
/*    */   
/*    */   public void atStartOfTurnPostDraw() {
/* 89 */     if (!this.owner.hasPower("OttoMod:TripleWolfPower")) {
/* 90 */       if (AbstractDungeon.player.hasRelic("TungstenRod")) {
/* 91 */         AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new DamageAction(this.owner, new DamageInfo(this.owner, this.amount, DamageInfo.DamageType.THORNS), AbstractGameAction.AttackEffect.FIRE));
/*    */       } else {
/*    */         
/* 94 */         for (int i = 0; i < this.amount; i++) {
/* 95 */           AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new DamageAction(this.owner, new DamageInfo(this.owner, 1, DamageInfo.DamageType.THORNS), AbstractGameAction.AttackEffect.FIRE));
/*    */         }
/*    */       } 
/*    */     } else {
/* 99 */       flash();
/*    */     } 
/*    */   }
/*    */   
/*    */   public void onRemove() {}
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\powers\Fury.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */