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
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import ottoMod.enums.CardColorEnum;

import static ottoMod.OttoMod.makeId;
/*    */

/*    */
/*    */ public class Strike_Otto extends CustomCard {
/* 20 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Strike_Otto");
/*    */   private static final String NAME = "打击";
/*    */   private static final String DESCRIPTION = "造成 !D! 点伤害。";
/*    */   public static final String IMG_PATH = "img/otto/Strike1.png";
/*    */   private static final int COST = 1;
/*    */   private static final int ATTACK_DMG = 6;
/*    */   private static final int UPGRADE_PLUS_DMG = 3;
/*    */   public static final String ID = "Strike_Otto";
/* 28 */   private static final CardRarity RARITY = CardRarity.BASIC;
/* 29 */   private static final CardTarget TARGET = CardTarget.ENEMY;
/*    */   
/* 31 */   private static final CardColor COLOR = CardColorEnum.ottogreen;
/*    */   
/*    */   public Strike_Otto() {
/* 34 */     super("Strike_Otto", "打击", "img/otto/Strike1.png", 1, "造成 !D! 点伤害。", CardType.ATTACK, CardColorEnum.ottogreen, RARITY, TARGET);
/*    */     
/* 36 */     this.tags.add(CardTags.STARTER_STRIKE);
/* 37 */     this.baseDamage = 6;
/* 38 */     this.tags.add(CardTags.STRIKE);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
             CardCrawlGame.sound.play(ID);
/* 45 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.POISON));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 52 */     return (AbstractCard)new Strike_Otto();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isStrike() {
/* 58 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 64 */     if (!this.upgraded) {
/*    */       
/* 66 */       upgradeName();
/* 67 */       upgradeDamage(3);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\Strike_Otto.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */