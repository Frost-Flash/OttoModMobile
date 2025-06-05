/*    */ package ottoMod.cards.ottogreen;
/*    */ 
/*    */

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.AbstractGameEffect;
import com.megacrit.cardcrawl.vfx.combat.SearingBlowEffect;
import ottoMod.enums.CardColorEnum;
import ottoMod.enums.CustomTags;

import static ottoMod.OttoMod.makeId;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SearingDashing
/*    */   extends CustomCard
/*    */ {
/*    */   public static final String ID = makeId("SearingDashing");
/* 28 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("SearingDashing");
/* 29 */   public static final String NAME = cardStrings.NAME; public static final String IMG_PATH = "img/otto/SearingDashing.png";
/* 30 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION; private static final int COST = 2;
/*    */   
/*    */   public SearingDashing() {
/* 33 */     this(0);
/*    */   } public SearingDashing(int upgrades) {
/* 35 */     super("SearingDashing", NAME, "img/otto/SearingDashing.png", 2, DESCRIPTION, CardType.ATTACK, CardColorEnum.ottogreen, CardRarity.UNCOMMON, CardTarget.ENEMY);
/* 36 */     this.damage = this.baseDamage = 10;
/* 37 */     this.block = this.baseBlock = 10;
/* 38 */     this.timesUpgraded = upgrades;
/* 39 */     this.tags.add(CustomTags.DASHING);
/*    */   }
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 44 */     if (m != null) {
/* 45 */       addToBot((AbstractGameAction)new VFXAction((AbstractGameEffect)new SearingBlowEffect(m.hb.cX, m.hb.cY, this.timesUpgraded), 0.2F));
/*    */     }
/* 47 */     addToBot((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.FIRE));
/* 48 */     addToBot((AbstractGameAction)new GainBlockAction((AbstractCreature)p, (AbstractCreature)p, this.block));
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 52 */     upgradeDamage((this.timesUpgraded >= 3) ? (this.timesUpgraded + 1) : 3);
/* 53 */     upgradeBlock((this.timesUpgraded >= 3) ? (this.timesUpgraded + 1) : 3);
/* 54 */     this.timesUpgraded++;
/* 55 */     this.upgraded = true;
/* 56 */     this.name = cardStrings.NAME + "+" + this.timesUpgraded;
/* 57 */     initializeTitle();
/*    */   }
/*    */   
/*    */   public boolean canUpgrade() {
/* 61 */     return true;
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 65 */     return (AbstractCard)new SearingDashing();
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\SearingDashing.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */