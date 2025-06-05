/*    */ package ottoMod.cards.ottogreen;
/*    */ 
/*    */

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.unique.PoisonLoseHpAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import ottoMod.effects.PushWheelEffect;
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
/*    */ public class HelloEverybody
/*    */   extends CustomCard
/*    */ {
/*    */   public static final String ID = makeId("HelloEverybody");
/* 39 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("HelloEverybody");
/* 40 */   public static final String NAME = cardStrings.NAME;
/* 41 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/* 42 */   public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
/*    */   private static final int COST = 0;
/*    */   public static final String IMG_PATH = "img/otto/HelloEverybody.png";
/* 45 */   private static final CardType TYPE = CardType.ATTACK;
/*    */   public HelloEverybody() {
/* 47 */     super("HelloEverybody", NAME, "img/otto/HelloEverybody.png", 0, DESCRIPTION, TYPE, CardColorEnum.ottogreen, CardRarity.RARE, CardTarget.ENEMY);
/* 48 */     this.magicNumber = this.baseMagicNumber = 1;
/* 49 */     this.damage = this.baseDamage = 4;
/* 50 */     this.block = this.baseBlock = 2;
/* 51 */     this.exhaust = true;
/* 52 */     this.isInnate = true;
/*    */   }
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 58 */     addToBot((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_LIGHT));
/* 59 */     addToBot((AbstractGameAction)new GainBlockAction((AbstractCreature)p, (AbstractCreature)p, this.block));
/* 60 */     addToBot((AbstractGameAction)new DrawCardAction((AbstractCreature)p, this.magicNumber + 1));
/* 61 */     (new PushWheelEffect()).trigger(this.magicNumber);
/* 62 */     addToBot((AbstractGameAction)new PoisonLoseHpAction((AbstractCreature)p, (AbstractCreature)p, 1, AbstractGameAction.AttackEffect.FIRE));
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 66 */     return (AbstractCard)new HelloEverybody();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 70 */     if (!this.upgraded) {
/* 71 */       upgradeName();
/* 72 */       upgradeMagicNumber(1);
/* 73 */       upgradeBlock(2);
/* 74 */       upgradeDamage(2);
/* 75 */       this.rawDescription = UPGRADE_DESCRIPTION;
/* 76 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\HelloEverybody.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */