/*    */ package ottoMod.cards.ottogreen;
/*    */ 
/*    */

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.DrawReductionPower;
import ottoMod.enums.CardColorEnum;
import ottoMod.powers.Fury;

import static ottoMod.OttoMod.makeId;
/*    */ 
/*    */ public class OpenBig extends CustomCard {
/* 21 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("OpenBig"); public static final String ID = makeId("OpenBig");
/* 22 */   public static final String NAME = cardStrings.NAME;
/* 23 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION; public static final String IMG_PATH = "img/otto/OpenBig.png";
/*    */   private static final int COST = 1;
/*    */   
/*    */   public OpenBig() {
/* 27 */     super("OpenBig", NAME, "img/otto/OpenBig.png", 1, DESCRIPTION, CardType.SKILL, CardColorEnum.ottogreen, CardRarity.UNCOMMON, CardTarget.SELF);
/* 28 */     this.magicNumber = this.baseMagicNumber = 2;
/*    */   }
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 33 */     addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new Fury((AbstractCreature)p, this.magicNumber), this.magicNumber));
/* 34 */     addToBot((AbstractGameAction)new DrawCardAction(4));
/* 35 */     addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new DrawReductionPower((AbstractCreature)p, 1)));
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 39 */     return (AbstractCard)new OpenBig();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 43 */     if (!this.upgraded) {
/* 44 */       upgradeName();
/* 45 */       upgradeMagicNumber(1);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\OpenBig.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */