/*    */ package ottoMod.cards.ottogreen;
/*    */ 
/*    */

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
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
import ottoMod.enums.CustomTags;

import static ottoMod.OttoMod.makeId;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Wheelchair_dashing
/*    */   extends CustomCard
/*    */ {
/*    */   public static final String ID = makeId("Wheelchair_dashing");
/* 23 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Wheelchair_dashing");
/* 24 */   public static final String NAME = cardStrings.NAME;
/*    */   
/*    */   private static final int BASE_PUSH = 4;
/*    */   
/*    */   private static final String DESCRIPTION = "造成 !D! 点伤害，触发 4 次 推轮 。";
/*    */   public static final String IMG_PATH = "img/otto/Wheelchair_dashing.png";
/*    */   
/*    */   public Wheelchair_dashing() {
/* 32 */     super("Wheelchair_dashing", NAME, "img/otto/Wheelchair_dashing.png", 2, "造成 !D! 点伤害，触发 4 次 推轮 。", CardType.ATTACK, CardColorEnum.ottogreen, CardRarity.BASIC, CardTarget.ENEMY);
/* 33 */     this.tags.add(CustomTags.DASHING);
/* 34 */     this.baseDamage = 7;
/* 35 */     this.magicNumber = this.baseMagicNumber = 4;
/*    */   }
/*    */   private static final int COST = 2; private static final int ATTACK_DMG = 7; private static final int UPGRADE_PLUS_DMG = 3;
/*    */   public void upgrade() {
/* 39 */     if (!this.upgraded) {
/*    */       
/* 41 */       upgradeName();
/* 42 */       upgradeDamage(3);
/* 43 */       upgradeMagicNumber(1);
/* 44 */       this.rawDescription = "造成 !D! 点伤害，触发 " + this.magicNumber + " 次 推轮 。";
/* 45 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 51 */     return (AbstractCard)new Wheelchair_dashing();
/*    */   }
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 55 */     addToBot((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.BLUNT_HEAVY));
/*    */ 
/*    */ 
/*    */     
/* 60 */     (new PushWheelEffect()).trigger(this.magicNumber);
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\Wheelchair_dashing.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */