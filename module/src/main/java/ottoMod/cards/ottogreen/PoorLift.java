/*    */ package ottoMod.cards.ottogreen;
/*    */ 
/*    */

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
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
/*    */ public class PoorLift
/*    */   extends CustomCard
/*    */ {
/*    */   public static final String ID = makeId("PoorLift");
/* 29 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("PoorLift");
/* 30 */   public static final String NAME = cardStrings.NAME;
/* 31 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/* 32 */   public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/otto/PoorLift.png";
/*    */   
/*    */   public PoorLift() {
/* 36 */     super("PoorLift", NAME, "img/otto/PoorLift.png", 0, DESCRIPTION, CardType.ATTACK, CardColorEnum.ottogreen, CardRarity.UNCOMMON, CardTarget.ENEMY);
/* 37 */     this.magicNumber = this.baseMagicNumber = 3;
/* 38 */     this.baseDamage = 4;
/* 39 */     this.exhaust = true;
/*    */   }
/*    */   private static final int COST = 0;
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 43 */     addToBot((AbstractGameAction)new GainEnergyAction(1));
/* 44 */     addToBot((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
/* 45 */     if (AbstractDungeon.player.gold < this.magicNumber * 10 + 70) {
/* 46 */       addToBot((AbstractGameAction)new DrawCardAction((AbstractCreature)p, this.magicNumber));
/*    */     }
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 51 */     return (AbstractCard)new PoorLift();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 55 */     if (!this.upgraded) {
/* 56 */       upgradeName();
/* 57 */       upgradeDamage(1);
/* 58 */       upgradeMagicNumber(1);
/* 59 */       this.rawDescription = UPGRADE_DESCRIPTION;
/* 60 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\PoorLift.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */