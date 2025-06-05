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
import ottoMod.powers.DeathBed;

import static ottoMod.OttoMod.makeId;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class OnDeathBed
/*    */   extends CustomCard
/*    */ {
/*    */   public static final String ID = makeId("OnDeathBed");
/* 24 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("OnDeathBed");
/* 25 */   public static final String NAME = cardStrings.NAME;
/* 26 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/* 27 */   public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/otto/OnDeathBed.png";
/*    */   
/*    */   public OnDeathBed() {
/* 31 */     super("OnDeathBed", NAME, "img/otto/OnDeathBed.png", 1, DESCRIPTION, CardType.POWER, CardColorEnum.ottogreen, CardRarity.RARE, CardTarget.SELF);
/* 32 */     this.magicNumber = this.baseMagicNumber = 6;
/*    */   }
/*    */   
/*    */   private static final int COST = 1;
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 39 */     addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new DeathBed((AbstractCreature)p, this.magicNumber), this.magicNumber));
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 43 */     return (AbstractCard)new OnDeathBed();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 47 */     if (!this.upgraded) {
/* 48 */       upgradeName();
/* 49 */       upgradeMagicNumber(2);
/* 50 */       this.rawDescription = UPGRADE_DESCRIPTION;
/* 51 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\OnDeathBed.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */