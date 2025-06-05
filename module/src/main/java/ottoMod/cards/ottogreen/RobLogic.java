/*    */ package ottoMod.cards.ottogreen;
/*    */

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.watcher.EnergyDownPower;
import ottoMod.enums.CardColorEnum;

import static ottoMod.OttoMod.makeId;
/*    */ 
/*    */ public class RobLogic extends CustomCard {
/* 17 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("RobLogic"); public static final String ID = makeId("RobLogic");
/* 18 */   public static final String NAME = cardStrings.NAME;
/* 19 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/* 20 */   public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION; public static final String IMG_PATH = "img/otto/RobLogic.png";
/*    */   private static final int COST = 1;
/*    */   
/*    */   public RobLogic() {
/* 24 */     super("RobLogic", NAME, "img/otto/RobLogic.png", 1, DESCRIPTION, CardType.SKILL, CardColorEnum.ottogreen, CardRarity.UNCOMMON, CardTarget.SELF);
/* 25 */     this.magicNumber = this.baseMagicNumber = 5;
/* 26 */     this.exhaust = true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 32 */     addToBot((AbstractGameAction)new GainEnergyAction(this.magicNumber));
/* 33 */     addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new EnergyDownPower((AbstractCreature)p, 1)));
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 37 */     return (AbstractCard)new RobLogic();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 41 */     if (!this.upgraded) {
/* 42 */       upgradeName();
/* 43 */       upgradeBaseCost(0);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\RobLogic.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */