/*    */ package ottoMod.cards.ottogreen;
/*    */ 
/*    */

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.defect.NewRipAndTearAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.DrawCardNextTurnPower;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class KingsWrath
/*    */   extends CustomCard
/*    */ {
/*    */   public static final String ID = makeId("KingsWrath");
/* 39 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("KingsWrath");
/* 40 */   public static final String NAME = cardStrings.NAME;
/* 41 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/otto/KingsWrath.png";
/*    */   
/*    */   public KingsWrath() {
/* 45 */     super("KingsWrath", NAME, "img/otto/KingsWrath.png", -1, DESCRIPTION, CardType.ATTACK, CardColorEnum.ottogreen, CardRarity.COMMON, CardTarget.ALL_ENEMY);
/* 46 */     this.baseDamage = 9;
/*    */   }
/*    */   private static final int COST = -1;
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 53 */     int energyAmount = this.energyOnUse;
/*    */     
/* 55 */     if (p.hasRelic("Chemical X")) {
/* 56 */       energyAmount += 2;
/* 57 */       p.getRelic("Chemical X").flash();
/*    */     } 
/* 59 */     if (energyAmount > 0) {
/* 60 */       for (int i = 0; i < energyAmount; i++) {
/* 61 */         addToTop((AbstractGameAction)new NewRipAndTearAction((AbstractCard)this));
/*    */       }
/*    */     }
/* 64 */     if (p.hasPower("OttoMod:Delicious") && energyAmount > 0) {
/* 65 */       addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new DrawCardNextTurnPower((AbstractCreature)p, energyAmount), energyAmount));
/*    */     }
/* 67 */     if (!this.freeToPlayOnce) AbstractDungeon.player.energy.use(energyAmount);
/*    */   
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 72 */     return (AbstractCard)new KingsWrath();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 76 */     if (!this.upgraded) {
/* 77 */       upgradeName();
/* 78 */       upgradeDamage(3);
/* 79 */       this.rawDescription = cardStrings.UPGRADE_DESCRIPTION;
/* 80 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\KingsWrath.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */