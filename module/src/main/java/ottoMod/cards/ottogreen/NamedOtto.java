/*    */ package ottoMod.cards.ottogreen;
/*    */ 
/*    */

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.utility.SFXAction;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NamedOtto
/*    */   extends CustomCard
/*    */ {
/*    */   public static final String ID = makeId("NamedOtto");
/* 28 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("NamedOtto");
/* 29 */   public static final String NAME = cardStrings.NAME;
/* 30 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/* 31 */   public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
/*    */   
/*    */   public static final String IMG_PATH = "img/otto/NamedOtto.png";
/*    */   
/*    */   public NamedOtto() {
/* 36 */     super("NamedOtto", NAME, "img/otto/NamedOtto.png", 0, DESCRIPTION, CardType.ATTACK, CardColorEnum.ottogreen, CardRarity.UNCOMMON, CardTarget.ENEMY);
/* 37 */     this.damage = this.baseDamage = 3;
/*    */   }
/*    */   private static final int COST = 0; private static final int DAMAGE_AMT = 3;
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 42 */     addToBot((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.LIGHTNING));
/* 43 */     addToTop((AbstractGameAction)new SFXAction("ORB_LIGHTNING_EVOKE", 0.1F));
/* 44 */     if (m.hasPower("Weakened")) {
/* 45 */       for (int i = 0; i < (m.getPower("Weakened")).amount; i++) {
/* 46 */         addToBot((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.LIGHTNING));
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 52 */     return (AbstractCard)new NamedOtto();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 56 */     if (!this.upgraded) {
/* 57 */       upgradeName();
/* 58 */       upgradeDamage(1);
/* 59 */       this.rawDescription = UPGRADE_DESCRIPTION;
/* 60 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\NamedOtto.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */