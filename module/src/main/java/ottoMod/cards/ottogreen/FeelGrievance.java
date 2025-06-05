/*    */ package ottoMod.cards.ottogreen;
/*    */ 
/*    */

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.NextTurnBlockPower;
import ottoMod.enums.CardColorEnum;

import static ottoMod.OttoMod.makeId;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FeelGrievance
/*    */   extends CustomCard
/*    */ {
/*    */   public static final String ID = makeId("FeelGrievance");
/* 24 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("FeelGrievance");
/* 25 */   public static final String NAME = cardStrings.NAME;
/* 26 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/* 27 */   public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
/*    */   
/*    */   public static final String IMG_PATH = "img/otto/FeelGrievance.png";
/*    */   
/*    */   public FeelGrievance() {
/* 32 */     super("FeelGrievance", NAME, "img/otto/FeelGrievance.png", 0, DESCRIPTION, CardType.SKILL, CardColorEnum.ottogreen, CardRarity.COMMON, CardTarget.SELF);
/* 33 */     this.baseBlock = 9;
/*    */   }
/*    */   private static final int COST = 0; private static final int BLOCK_AMT = 9;
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 38 */     addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new NextTurnBlockPower((AbstractCreature)p, this.block), this.block));
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 42 */     return (AbstractCard)new FeelGrievance();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 46 */     if (!this.upgraded) {
/* 47 */       upgradeName();
/* 48 */       upgradeBlock(4);
/* 49 */       this.rawDescription = UPGRADE_DESCRIPTION;
/* 50 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\FeelGrievance.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */