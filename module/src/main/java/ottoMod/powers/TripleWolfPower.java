/*    */ package ottoMod.powers;
/*    */ 
/*    */

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction;
import com.megacrit.cardcrawl.android.mods.AssetLoader;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.status.Burn;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import ottoMod.OttoMod;

/*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TripleWolfPower
/*    */   extends AbstractPower
/*    */ {
/*    */   public static final String POWER_ID = OttoMod.makeId("TripleWolfPower");
/* 24 */   private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings("OttoMod:TripleWolfPower");
/* 25 */   private static final String NAME = powerStrings.NAME;
/* 26 */   private static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
/*    */   public TripleWolfPower(AbstractCreature owner, int shu) {
/* 28 */     this.name = NAME;
/* 29 */     this.ID = "OttoMod:TripleWolfPower";
/* 30 */     this.owner = owner;
/* 31 */     this.amount = shu;
/* 32 */     this.type = PowerType.BUFF;
/* 33 */     String path128 = "img/UI_Otto/Example128.png";
/* 34 */     String path48 = "img/UI_Otto/Example48.png";
/* 35 */     this.region128 = new TextureAtlas.AtlasRegion(AssetLoader.getTexture(OttoMod.MOD_ID,path128), 0, 0, 84, 84);
/* 36 */     this.region48 = new TextureAtlas.AtlasRegion(AssetLoader.getTexture(OttoMod.MOD_ID,path48), 0, 0, 32, 32);
/* 37 */     updateDescription();
/*    */   }
/*    */   
/*    */   public void updateDescription() {
/* 41 */     this.description = DESCRIPTIONS[0] + (this.amount * 3) + DESCRIPTIONS[1] + (this.amount * 2) + DESCRIPTIONS[2];
/*    */   }
/*    */   
/*    */   public void stackPower(int stackAmount) {
/* 45 */     super.stackPower(stackAmount);
/* 46 */     updateDescription();
/*    */   }
/*    */   
/*    */   public void atEndOfTurn(boolean isPlayer) {
/* 50 */     if (isPlayer) {
/* 51 */       addToBot((AbstractGameAction)new ApplyPowerAction(this.owner, this.owner, new Fury(this.owner, this.amount * 3), this.amount * 3));
/* 52 */       Burn burn = new Burn();
/* 53 */       burn.upgrade();
/* 54 */       addToBot((AbstractGameAction)new MakeTempCardInDrawPileAction((AbstractCard)burn, this.amount, true, true));
/* 55 */       addToBot((AbstractGameAction)new MakeTempCardInDiscardAction((AbstractCard)burn, this.amount));
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\powers\TripleWolfPower.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */