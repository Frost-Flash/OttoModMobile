/*    */ package ottoMod.cards.ottogreen;
/*    */ 
/*    */

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.status.Burn;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import ottoMod.enums.CardColorEnum;
import ottoMod.powers.TripleWolfPower;

import static ottoMod.OttoMod.makeId;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TripleWolf
/*    */   extends CustomCard
/*    */ {
/*    */   public static final String ID = makeId("TripleWolf");
/* 29 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("TripleWolf");
/* 30 */   public static final String NAME = cardStrings.NAME;
/* 31 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/* 32 */   public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/otto/TripleWolf.png";
/*    */   
/*    */   public TripleWolf() {
/* 36 */     super("TripleWolf", NAME, "img/otto/TripleWolf.png", 2, DESCRIPTION, CardType.POWER, CardColorEnum.ottogreen, CardRarity.RARE, CardTarget.SELF);
/* 37 */     this.isInnate = false;
/* 39 */     Burn burn = new Burn();
/* 40 */     burn.upgrade();
/* 41 */     this.cardsToPreview = (AbstractCard)burn;
/*    */   }
/*    */   private static final int COST = 2;
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 45 */     addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new TripleWolfPower((AbstractCreature)p, 1), 1));
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 49 */     return (AbstractCard)new TripleWolf();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 53 */     if (!this.upgraded) {
/* 54 */       upgradeName();
/* 55 */       this.isInnate = true;
/* 56 */       this.rawDescription = UPGRADE_DESCRIPTION;
/* 57 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\TripleWolf.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */