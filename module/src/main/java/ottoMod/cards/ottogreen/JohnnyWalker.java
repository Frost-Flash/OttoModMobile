/*    */ package ottoMod.cards.ottogreen;
/*    */ 
/*    */

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import com.megacrit.cardcrawl.powers.WeakPower;
import com.megacrit.cardcrawl.vfx.AbstractGameEffect;
import com.megacrit.cardcrawl.vfx.CollectorCurseEffect;
import ottoMod.enums.CardColorEnum;

import static ottoMod.OttoMod.makeId;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JohnnyWalker
/*    */   extends CustomCard
/*    */ {
/*    */   public static final String ID = makeId("JohnnyWalker");
/* 33 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("JohnnyWalker");
/* 34 */   public static final String NAME = cardStrings.NAME;
/* 35 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/* 36 */   public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/otto/JohnnyWalker.png";
/*    */   
/*    */   public JohnnyWalker() {
/* 40 */     super("JohnnyWalker", NAME, "img/otto/JohnnyWalker.png", 0, DESCRIPTION, CardType.SKILL, CardColorEnum.ottogreen, CardRarity.COMMON, CardTarget.ENEMY);
/* 41 */     this.magicNumber = this.baseMagicNumber = 2;
/* 42 */     this.block = this.baseBlock = 4;
/*    */   }
/*    */   private static final int COST = 0;
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 47 */     addToBot((AbstractGameAction)new GainBlockAction((AbstractCreature)p, (AbstractCreature)p, this.block));
/* 48 */     if (p.hasPower("OttoMod:Delicious")) {
/* 49 */       addToBot((AbstractGameAction)new VFXAction((AbstractGameEffect)new CollectorCurseEffect(m.hb.cX, m.hb.cY), 1.0F));
/* 50 */       addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)m, (AbstractCreature)p, (AbstractPower)new VulnerablePower((AbstractCreature)m, this.magicNumber, false), this.magicNumber));
/* 51 */       addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)m, (AbstractCreature)p, (AbstractPower)new WeakPower((AbstractCreature)m, this.magicNumber, false), this.magicNumber));
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 57 */     return (AbstractCard)new JohnnyWalker();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 61 */     if (!this.upgraded) {
/* 62 */       upgradeName();
/* 63 */       upgradeBlock(3);
/* 64 */       this.rawDescription = UPGRADE_DESCRIPTION;
/* 65 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\JohnnyWalker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */