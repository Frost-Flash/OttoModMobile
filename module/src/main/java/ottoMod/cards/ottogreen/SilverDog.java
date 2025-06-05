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
/*    */ public class SilverDog
/*    */   extends CustomCard
/*    */ {
/*    */   public static final String ID = makeId("SilverDog");
/* 27 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("SilverDog");
/* 28 */   public static final String NAME = cardStrings.NAME;
/* 29 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/* 30 */   public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/otto/SilverDog.png";
/*    */   
/*    */   public SilverDog() {
/* 34 */     super("SilverDog", NAME, "img/otto/SilverDog.png", 2, DESCRIPTION, CardType.POWER, CardColorEnum.ottogreen, CardRarity.UNCOMMON, CardTarget.SELF);
/* 35 */     this.magicNumber = this.baseMagicNumber = 1;
/* 36 */     this.isEthereal = true;
/*    */   }
/*    */   private static final int COST = 2;
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 40 */     addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new ottoMod.powers.SilverDog((AbstractCreature)p, this.magicNumber)));
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 44 */     return (AbstractCard)new SilverDog();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 48 */     if (!this.upgraded) {
/* 49 */       upgradeName();
/* 50 */       upgradeMagicNumber(1);
/* 51 */       this.rawDescription = UPGRADE_DESCRIPTION;
/* 52 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\SilverDog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */