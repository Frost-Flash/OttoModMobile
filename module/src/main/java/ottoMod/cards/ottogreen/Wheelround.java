/*    */ package ottoMod.cards.ottogreen;
/*    */ 
/*    */

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DiscardAction;
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
/*    */ public class Wheelround
/*    */   extends CustomCard
/*    */ {
/*    */   public static final String ID = makeId("Wheelround");
/* 26 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Wheelround");
/* 27 */   public static final String NAME = cardStrings.NAME;
/*    */   
/*    */   private static final String DESCRIPTION = "造成 !D! 点伤害。 营养 ：丢弃所有手牌，每张 推轮 1次。";
/*    */   
/*    */   public static final String IMG_PATH = "img/otto/Wheelround.png";
/*    */   
/*    */   public Wheelround() {
/* 34 */     super("Wheelround", NAME, "img/otto/Wheelround.png", 1, "造成 !D! 点伤害。 营养 ：丢弃所有手牌，每张 推轮 1次。", CardType.ATTACK, CardColorEnum.ottogreen, CardRarity.COMMON, CardTarget.ENEMY);
/* 35 */     this.damage = this.baseDamage = 7;
/*    */   }
/*    */   private static final int COST = 1; private static final int DAMAGE = 7;
/*    */   private static final int UPGRADE_DAMAGE = 4;
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 41 */     addToBot((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_HEAVY));
/*    */     
/* 43 */     final int discardCount = p.hand.size() - 1;
/* 44 */     if (p.hasPower("OttoMod:Delicious")) {
/* 45 */       addToBot((AbstractGameAction)new DiscardAction((AbstractCreature)p, (AbstractCreature)p, discardCount, true));
/* 46 */       addToBot(new AbstractGameAction()
/*    */           {
/*    */             public void update() {
/* 49 */               if (discardCount > 0) {
/* 50 */                 (new PushWheelEffect()).trigger(discardCount);
/*    */               }
/* 52 */               this.isDone = true;
/*    */             }
/*    */           });
/*    */     } 
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 59 */     if (!this.upgraded) {
/* 60 */       upgradeName();
/* 61 */       upgradeDamage(4);
/*    */     } 
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 66 */     return (AbstractCard)new Wheelround();
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\Wheelround.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */