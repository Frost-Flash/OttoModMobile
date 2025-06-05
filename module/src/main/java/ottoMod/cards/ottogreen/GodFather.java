/*    */ package ottoMod.cards.ottogreen;
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
import ottoMod.powers.GunFather;

import static ottoMod.OttoMod.makeId;
/*    */ 
/*    */ public class GodFather extends CustomCard {
/* 15 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("GodFather"); public static final String ID = makeId("GodFather");
/* 16 */   public static final String NAME = cardStrings.NAME;
/* 17 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/* 18 */   public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/otto/GodFather.png";
/*    */   private static final int COST = 1;
/* 21 */   private static final CardType TYPE = CardType.POWER;
/*    */   public GodFather() {
/* 23 */     super("GodFather", NAME, "img/otto/GodFather.png", 1, DESCRIPTION, TYPE, CardColorEnum.ottogreen, CardRarity.UNCOMMON, CardTarget.SELF);
/* 24 */     this.magicNumber = this.baseMagicNumber = 2;
/*    */   }
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 28 */     addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new GunFather((AbstractCreature)p, this.magicNumber), this.magicNumber));
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 32 */     return (AbstractCard)new GodFather();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 36 */     if (!this.upgraded) {
/* 37 */       upgradeName();
/* 38 */       upgradeBaseCost(0);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\GodFather.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */