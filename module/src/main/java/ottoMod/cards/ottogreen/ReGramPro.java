/*    */ package ottoMod.cards.ottogreen;
/*    */ 
/*    */

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import ottoMod.enums.CardColorEnum;
import ottoMod.powers.WheelBoostPower;

import static ottoMod.OttoMod.makeId;
/*    */ 
/*    */ public class ReGramPro extends CustomCard {
/*    */   public static final String ID = makeId("ReGramPro");
/* 24 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("ReGramPro");
/* 25 */   public static final String NAME = cardStrings.NAME;
/* 26 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/otto/ReGramPro.png";
/*    */   
/*    */   public ReGramPro() {
/* 30 */     super("ReGramPro", NAME, "img/otto/ReGramPro.png", 1, DESCRIPTION, CardType.SKILL, CardColorEnum.ottogreen, CardRarity.UNCOMMON, CardTarget.SELF);
/* 31 */     this.magicNumber = this.baseMagicNumber = 1;
/*    */   }
/*    */   
/*    */   private static final int COST = 1;
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 38 */     if (p.hasPower("OttoMod:WheelBoostPower") && this.magicNumber == (p.getPower("OttoMod:WheelBoostPower")).amount)
/* 39 */     { if (p.hasPower("Artifact")) {
/* 40 */         addToTop((AbstractGameAction)new ReducePowerAction((AbstractCreature)p, (AbstractCreature)p, "Artifact", 1));
/*    */       } else {
/* 42 */         addToBot((AbstractGameAction)new RemoveSpecificPowerAction((AbstractCreature)p, (AbstractCreature)p, "OttoMod:WheelBoostPower"));
/*    */       }  }
/* 44 */     else { addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new WheelBoostPower((AbstractCreature)p, -this.magicNumber), -this.magicNumber)); }
/*    */     
/* 46 */     addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new StrengthPower((AbstractCreature)p, this.magicNumber), this.magicNumber));
/* 47 */     addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new DexterityPower((AbstractCreature)p, this.magicNumber), this.magicNumber));
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 51 */     return (AbstractCard)new ReGramPro();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 55 */     if (!this.upgraded) {
/* 56 */       upgradeName();
/* 57 */       upgradeMagicNumber(1);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\ReGramPro.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */