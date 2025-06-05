/*    */ package ottoMod.cards.ottogreen;
/*    */ 
/*    */

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import ottoMod.enums.CardColorEnum;

import static ottoMod.OttoMod.makeId;
/*    */ 
/*    */ public class MaliciousAttack
/*    */   extends CustomCard
/*    */ {
/*    */   public static final String ID = makeId("MaliciousAttack");
/* 20 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("MaliciousAttack");
/* 21 */   public static final String NAME = cardStrings.NAME;
/* 22 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/* 23 */   public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/otto/MaliciousAttack.png";
/*    */   private static final int COST = 2;
/*    */   
/*    */   public MaliciousAttack() {
/* 28 */     super("MaliciousAttack", NAME, "img/otto/MaliciousAttack.png", 2, DESCRIPTION, CardType.ATTACK, CardColorEnum.ottogreen, CardRarity.UNCOMMON, CardTarget.ENEMY);
/* 29 */     this.damage = this.baseDamage;
/* 30 */     this.block = this.baseBlock;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 35 */     int cancerAmount = 0;
/* 36 */     this.damage = cancerAmount;
/* 37 */     this.block = cancerAmount;
/* 38 */     if (m.hasPower("OttoMod:Cancer")) {
/* 39 */       cancerAmount = (m.getPower("OttoMod:Cancer")).amount;
/* 40 */       this.damage = cancerAmount; this.block = cancerAmount;
/*    */     } 
/* 42 */     addToBot((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.POISON));
/* 43 */     addToBot((AbstractGameAction)new GainBlockAction((AbstractCreature)p, (AbstractCreature)p, this.block));
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 48 */     if (!this.upgraded) {
/* 49 */       upgradeName();
/* 50 */       upgradeBaseCost(1);
/* 51 */       this.rawDescription = UPGRADE_DESCRIPTION;
/* 52 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 57 */     return (AbstractCard)new MaliciousAttack();
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\MaliciousAttack.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */