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
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import ottoMod.enums.CardColorEnum;
import ottoMod.powers.TurnStartPushPower;

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
/*    */ public class CallColorByte
/*    */   extends CustomCard
/*    */ {
/*    */   public static final String ID = makeId("CallColorByte");
/* 31 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("CallColorByte");
/* 32 */   public static final String NAME = cardStrings.NAME;
/* 33 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/* 34 */   public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/otto/ColorByte.png";
/*    */   private static final int COST = 2;
/* 37 */   private static final CardType TYPE = CardType.POWER;
/*    */   public CallColorByte() {
/* 39 */     super("CallColorByte", NAME, "img/otto/ColorByte.png", 2, DESCRIPTION, TYPE, CardColorEnum.ottogreen, CardRarity.UNCOMMON, CardTarget.SELF);
/* 40 */     this.magicNumber = this.baseMagicNumber = 3;
/*    */   }
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 44 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new TurnStartPushPower((AbstractCreature)p, this.magicNumber), this.magicNumber));
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 49 */     return (AbstractCard)new CallColorByte();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 53 */     if (!this.upgraded) {
/* 54 */       upgradeName();
/* 55 */       upgradeBaseCost(1);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\CallColorByte.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */