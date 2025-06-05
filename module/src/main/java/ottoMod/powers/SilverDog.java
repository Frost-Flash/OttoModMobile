/*    */ package ottoMod.powers;
/*    */ 
/*    */

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.android.mods.AssetLoader;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.WeakPower;
import ottoMod.OttoMod;

/*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SilverDog
/*    */   extends AbstractPower
/*    */ {
/*    */   public static final String POWER_ID = OttoMod.makeId("SilverDog");
/* 24 */   private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings("OttoMod:SilverDog");
/* 25 */   private static final String NAME = powerStrings.NAME;
/* 26 */   private static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;
/*    */   public SilverDog(AbstractCreature owner, int amount) {
/* 28 */     this.name = NAME;
/* 29 */     this.ID = "OttoMod:SilverDog";
/* 30 */     this.owner = owner;
/* 31 */     this.amount = amount;
/* 32 */     this.type = PowerType.BUFF;
/* 33 */     String path128 = "img/UI_Otto/SilverDog128.png";
/* 34 */     String path48 = "img/UI_Otto/SilverDog48.png";
/* 35 */     this.region128 = new TextureAtlas.AtlasRegion(AssetLoader.getTexture(OttoMod.MOD_ID,path128), 0, 0, 84, 84);
/* 36 */     this.region48 = new TextureAtlas.AtlasRegion(AssetLoader.getTexture(OttoMod.MOD_ID,path48), 0, 0, 32, 32);
/* 37 */     updateDescription();
/*    */   }
/*    */   
/*    */   public void updateDescription() {
/* 41 */     this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
/*    */   }
/*    */   
/*    */   public void onApplyPower(AbstractPower power, AbstractCreature target, AbstractCreature source) {
/* 45 */     if (power.ID.equals("OttoMod:Cancer")) {
/* 46 */       addToBot((AbstractGameAction)new ApplyPowerAction(target, this.owner, (AbstractPower)new WeakPower(target, this.amount, false), this.amount));
/*    */     }
/*    */   }
/*    */   
/*    */   public void stackPower(int stackAmount) {
/* 51 */     super.stackPower(stackAmount);
/* 52 */     if (this.amount > 999) {
/* 53 */       this.amount = 999;
/*    */     }
/* 55 */     updateDescription();
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\powers\SilverDog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */