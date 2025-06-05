/*    */ package ottoMod.cards.ottogreen;
/*    */ 
/*    */

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.unique.PoisonLoseHpAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.MetallicizePower;
import ottoMod.enums.CardColorEnum;

import static ottoMod.OttoMod.makeId;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BigFruit
/*    */   extends CustomCard
/*    */ {
/*    */   public static final String ID = makeId("BigFruit");
/* 26 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("BigFruit");
/* 27 */   public static final String NAME = cardStrings.NAME;
/* 28 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/otto/BigFruit.png";
/*    */   
/*    */   public BigFruit() {
/* 32 */     super("BigFruit", NAME, "img/otto/BigFruit.png", 1, DESCRIPTION, CardType.POWER, CardColorEnum.ottogreen, CardRarity.COMMON, CardTarget.SELF);
/* 33 */     this.magicNumber = this.baseMagicNumber = 5;
/* 34 */     this.isEthereal = true;
/*    */   }
/*    */   private static final int COST = 1;
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 38 */     addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new MetallicizePower((AbstractCreature)p, 5), 5));
/* 39 */     addToBot((AbstractGameAction)new PoisonLoseHpAction((AbstractCreature)p, (AbstractCreature)p, 6, AbstractGameAction.AttackEffect.POISON));
/* 40 */     addToBot((AbstractGameAction)new DrawCardAction((AbstractCreature)p, 1));
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 44 */     return (AbstractCard)new BigFruit();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 48 */     if (!this.upgraded) {
/* 49 */       upgradeName();
/* 50 */       upgradeBaseCost(0);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\BigFruit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */