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
import ottoMod.enums.CustomTags;
import ottoMod.powers.InfiniteDashingPower;

import static ottoMod.OttoMod.makeId;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class InfiniteDashing
/*    */   extends CustomCard
/*    */ {
/*    */   public static final String ID = makeId("InfiniteDashing");
/* 28 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("InfiniteDashing");
/* 29 */   public static final String NAME = cardStrings.NAME;
/* 30 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/* 31 */   public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/otto/InfiniteDashing.png";
/*    */   
/*    */   public InfiniteDashing() {
/* 35 */     super("InfiniteDashing", NAME, "img/otto/InfiniteDashing.png", 1, DESCRIPTION, CardType.POWER, CardColorEnum.ottogreen, CardRarity.UNCOMMON, CardTarget.SELF);
/* 36 */     this.tags.add(CustomTags.DASHING);
/* 37 */     this.cardsToPreview = (AbstractCard)new Dashing();
/*    */   }
/*    */   private static final int COST = 1;
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 42 */     addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new InfiniteDashingPower((AbstractCreature)p, 1), 1));
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 46 */     return (AbstractCard)new InfiniteDashing();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 50 */     if (!this.upgraded) {
/* 51 */       upgradeName();
/* 52 */       this.isInnate = true;
/* 53 */       this.rawDescription = UPGRADE_DESCRIPTION;
/* 54 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\InfiniteDashing.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */