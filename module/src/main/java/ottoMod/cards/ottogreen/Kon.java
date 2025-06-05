/*    */ package ottoMod.cards.ottogreen;
/*    */ 
/*    */

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.unique.PoisonLoseHpAction;
import com.megacrit.cardcrawl.actions.watcher.ChangeStanceAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.AbstractGameEffect;
import com.megacrit.cardcrawl.vfx.combat.ShockWaveEffect;
import ottoMod.enums.CardColorEnum;

import static ottoMod.OttoMod.makeId;
/*    */ 
/*    */ public class Kon
/*    */   extends CustomCard
/*    */ {
/*    */   public static final String ID = makeId("Kon");
/* 23 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Kon");
/* 24 */   public static final String NAME = cardStrings.NAME;
/* 25 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/otto/Kon.png";
/*    */   
/*    */   public Kon() {
/* 29 */     super("Kon", NAME, "img/otto/Kon.png", 4, DESCRIPTION, CardType.SKILL, CardColorEnum.ottogreen, CardRarity.RARE, CardTarget.NONE);
/* 30 */     this.magicNumber = this.baseMagicNumber = 3;
/* 31 */     this.exhaust = true;
/*    */   }
/*    */   
/*    */   private static final int COST = 4;
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 38 */     if (Settings.FAST_MODE) {
/* 39 */       addToBot((AbstractGameAction)new VFXAction((AbstractCreature)p, (AbstractGameEffect)new ShockWaveEffect(p.hb.cX, p.hb.cY, Settings.PURPLE_COLOR, ShockWaveEffect.ShockWaveType.CHAOTIC), 0.3F));
/*    */     } else {
/* 41 */       addToBot((AbstractGameAction)new VFXAction((AbstractCreature)p, (AbstractGameEffect)new ShockWaveEffect(p.hb.cX, p.hb.cY, Settings.PURPLE_COLOR, ShockWaveEffect.ShockWaveType.CHAOTIC), 1.5F));
/*    */     } 
/* 43 */     addToBot((AbstractGameAction)new ChangeStanceAction("Divinity"));
/* 44 */     addToBot((AbstractGameAction)new PoisonLoseHpAction((AbstractCreature)p, (AbstractCreature)p, this.magicNumber, AbstractGameAction.AttackEffect.POISON));
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 48 */     return (AbstractCard)new Kon();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 52 */     if (!this.upgraded) {
/* 53 */       upgradeName();
/* 54 */       upgradeBaseCost(3);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\Kon.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */