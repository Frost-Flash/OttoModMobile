/*    */ package ottoMod.cards.ottogreen;
/*    */ 
/*    */

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.vfx.AbstractGameEffect;
import com.megacrit.cardcrawl.vfx.combat.AdrenalineEffect;
import ottoMod.enums.CardColorEnum;
import ottoMod.powers.WheelBoostPower;

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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Octane
/*    */   extends CustomCard
/*    */ {
/*    */   public static final String ID = makeId("Octane");
/* 34 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Octane");
/* 35 */   public static final String NAME = cardStrings.NAME;
/* 36 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/* 37 */   public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/otto/Octane.png";
/*    */   
/*    */   public Octane() {
/* 41 */     super("Octane", NAME, "img/otto/Octane.png", 1, DESCRIPTION, CardType.POWER, CardColorEnum.ottogreen, CardRarity.UNCOMMON, CardTarget.SELF);
/* 42 */     this.magicNumber = this.baseMagicNumber = 1;
/*    */   }
/*    */   private static final int COST = 1;
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 46 */     addToBot((AbstractGameAction)new VFXAction((AbstractGameEffect)new AdrenalineEffect(), 0.5F));
/* 47 */     addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new WheelBoostPower((AbstractCreature)p, this.magicNumber), this.magicNumber));
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 52 */     if (!this.upgraded) {
/* 53 */       upgradeName();
/* 54 */       upgradeMagicNumber(1);
/* 55 */       this.rawDescription = this.upgraded ? UPGRADE_DESCRIPTION : DESCRIPTION;
/* 56 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 62 */     return (AbstractCard)new Octane();
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\Octane.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */