/*    */ package ottoMod.cards.ottogreen;
/*    */ 
/*    */

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.watcher.SkipEnemiesTurnAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.AbstractGameEffect;
import com.megacrit.cardcrawl.vfx.RainbowCardEffect;
import com.megacrit.cardcrawl.vfx.ThoughtBubble;
import ottoMod.enums.CardColorEnum;

import static ottoMod.OttoMod.makeId;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ForcedSmile
/*    */   extends CustomCard
/*    */ {
/*    */   public static final String ID = makeId("ForcedSmile");
/* 30 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("ForcedSmile");
/* 31 */   public static final String NAME = cardStrings.NAME;
/* 32 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/* 33 */   public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/otto/ForcedSmile.png";
/*    */   
/*    */   public ForcedSmile() {
/* 37 */     super("ForcedSmile", NAME, "img/otto/ForcedSmile.png", 3, DESCRIPTION, CardType.SKILL, CardColorEnum.ottogreen, CardRarity.RARE, CardTarget.SELF);
/* 38 */     this.exhaust = true;
/* 39 */     this.isEthereal = true;
/*    */   }
/*    */   private static final int COST = 3;
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 43 */     if (!p.hasAnyPotions()) {
/* 44 */       addToBot((AbstractGameAction)new VFXAction((AbstractGameEffect)new RainbowCardEffect()));
/* 45 */       addToBot((AbstractGameAction)new SkipEnemiesTurnAction());
/*    */     } else {
/* 48 */       AbstractDungeon.effectList.add(new ThoughtBubble(AbstractDungeon.player.dialogX, AbstractDungeon.player.dialogY, 3.0F, "药水栏不是空的！", true));
/*    */     } 
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 53 */     return (AbstractCard)new ForcedSmile();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 57 */     if (!this.upgraded) {
/* 58 */       upgradeName();
/* 59 */       this.isEthereal = false;
/* 60 */       this.rawDescription = UPGRADE_DESCRIPTION;
/* 61 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\ForcedSmile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */