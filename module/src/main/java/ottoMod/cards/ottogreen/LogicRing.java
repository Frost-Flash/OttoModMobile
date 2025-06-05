/*    */ package ottoMod.cards.ottogreen;
/*    */ 
/*    */

import com.megacrit.cardcrawl.actions.AbstractGameAction;
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
import ottoMod.enums.CardColorEnum;
import ottoMod.powers.Cancer;

import static ottoMod.OttoMod.makeId;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LogicRing
/*    */   extends CustomCard
/*    */ {
/*    */   public static final String ID = makeId("LogicRing");
/* 30 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("LogicRing");
/* 31 */   public static final String NAME = cardStrings.NAME;
/* 32 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/* 33 */   public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
/*    */   
/*    */   public static final String IMG_PATH = "img/otto/LogicRing.png";
/*    */   
/*    */   public LogicRing() {
/* 38 */     super("LogicRing", NAME, "img/otto/LogicRing.png", 0, DESCRIPTION, CardType.SKILL, CardColorEnum.ottogreen, CardRarity.COMMON, CardTarget.ENEMY);
/* 39 */     this.magicNumber = this.baseMagicNumber = 3;
/* 40 */     this.block = this.baseBlock = 3;
/*    */   }
/*    */   private static final int COST = 0; private static final int BLOCK_AMT = 3;
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 46 */     addToBot((AbstractGameAction)new GainBlockAction((AbstractCreature)p, (AbstractCreature)p, this.block));
/* 47 */     if (m.hasPower("OttoMod:Cancer")) {
/* 48 */       addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)m, (AbstractCreature)p, (AbstractPower)new Cancer((AbstractCreature)m, this.magicNumber), this.magicNumber));
/*    */     }
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 53 */     return (AbstractCard)new LogicRing();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 57 */     if (!this.upgraded) {
/* 58 */       upgradeName();
/* 59 */       upgradeBlock(2);
/* 60 */       upgradeMagicNumber(1);
/* 61 */       this.rawDescription = UPGRADE_DESCRIPTION;
/* 62 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\LogicRing.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */