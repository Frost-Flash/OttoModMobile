/*    */ package ottoMod.cards.ottogreen;
/*    */ 
/*    */

import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.unique.PoisonLoseHpAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.AbstractGameEffect;
import com.megacrit.cardcrawl.vfx.BorderLongFlashEffect;
import com.megacrit.cardcrawl.vfx.combat.ShockWaveEffect;
import ottoMod.enums.CardColorEnum;

import java.util.Iterator;

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
/*    */ 
/*    */ 
/*    */ public class Wow
/*    */   extends CustomCard
/*    */ {
/*    */   public static final String ID = makeId("Wow");
/* 37 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Wow");
/* 38 */   public static final String NAME = cardStrings.NAME;
/* 39 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/otto/Wow.png";
/*    */   
/*    */   public Wow() {
/* 43 */     super("Wow", NAME, "img/otto/Wow.png", 1, DESCRIPTION, CardType.SKILL, CardColorEnum.ottogreen, CardRarity.UNCOMMON, CardTarget.ALL_ENEMY);
/*    */   }
/*    */   private static final int COST = 1;
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 49 */     addToBot((AbstractGameAction)new VFXAction((AbstractGameEffect)new BorderLongFlashEffect(Color.GREEN), 0.5F));
/* 50 */     addToBot((AbstractGameAction)new VFXAction((AbstractCreature)p, (AbstractGameEffect)new ShockWaveEffect(p.hb.cX, p.hb.cY, Settings.GREEN_RELIC_COLOR, ShockWaveEffect.ShockWaveType.CHAOTIC), 0.3F));
/* 51 */     if (!AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
/* 52 */       flash();
/* 53 */       Iterator<AbstractMonster> var3 = (AbstractDungeon.getMonsters()).monsters.iterator();
/* 54 */       while (var3.hasNext()) {
/* 55 */         AbstractMonster monster = var3.next();
/* 56 */         if (!monster.isDead && !monster.isDying) {
/* 57 */           addToBot((AbstractGameAction)new PoisonLoseHpAction((AbstractCreature)monster, (AbstractCreature)p, p.hasPower("OttoMod:Fury") ? ((p.getPower("OttoMod:Fury")).amount * 2) : 0, AbstractGameAction.AttackEffect.FIRE));
/*    */         }
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 65 */     return (AbstractCard)new Wow();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 69 */     if (!this.upgraded) {
/* 70 */       upgradeName();
/* 71 */       upgradeBaseCost(0);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\Wow.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */