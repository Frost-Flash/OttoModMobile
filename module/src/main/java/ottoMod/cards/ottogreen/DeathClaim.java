/*    */ package ottoMod.cards.ottogreen;
/*    */ 
/*    */

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.HealAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.EnergizedPower;
import com.megacrit.cardcrawl.powers.EquilibriumPower;
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
/*    */ public class DeathClaim
/*    */   extends CustomCard
/*    */ {
/*    */   public static final String ID = makeId("DeathClaim");
/* 30 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("DeathClaim");
/* 31 */   public static final String NAME = cardStrings.NAME;
/* 32 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/* 33 */   public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/otto/DeathClaim.png";
/*    */   
/*    */   public DeathClaim() {
/* 37 */     super("DeathClaim", NAME, "img/otto/DeathClaim.png", 1, DESCRIPTION, CardType.SKILL, CardColorEnum.ottogreen, CardRarity.COMMON, CardTarget.SELF);
/* 38 */     this.exhaust = true;
/* 39 */     this.block = this.baseBlock = 3;
/*    */   }
/*    */   
/*    */   private static final int COST = 1;
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 46 */     addToBot((AbstractGameAction)new HealAction((AbstractCreature)p, (AbstractCreature)p, this.block));
/* 47 */     addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new EquilibriumPower((AbstractCreature)p, 1), 1));
/* 48 */     if (p.hasPower("OttoMod:Delicious")) {
/* 49 */       addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new EnergizedPower((AbstractCreature)p, 2), 2));
/*    */     }
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 54 */     return (AbstractCard)new DeathClaim();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 58 */     if (!this.upgraded) {
/* 59 */       upgradeName();
/* 60 */       this.exhaust = false;
/* 61 */       upgradeBlock(1);
/* 62 */       this.rawDescription = UPGRADE_DESCRIPTION;
/* 63 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\DeathClaim.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */