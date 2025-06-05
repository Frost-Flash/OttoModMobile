/*    */ package ottoMod.cards.ottogreen;
/*    */ 
/*    */

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
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
/*    */ public class MothersDay
/*    */   extends CustomCard
/*    */ {
/*    */   public static final String ID = makeId("MothersDay");
/* 22 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("MothersDay");
/* 23 */   public static final String NAME = cardStrings.NAME;
/* 24 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/* 25 */   public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/otto/MothersDay.png";
/*    */   
/*    */   public MothersDay() {
/* 29 */     super("MothersDay", NAME, "img/otto/MothersDay.png", 1, DESCRIPTION, CardType.ATTACK, CardColorEnum.ottogreen, CardRarity.UNCOMMON, CardTarget.ENEMY);
/* 30 */     this.damage = this.baseDamage = 5;
/* 31 */     this.cardsToPreview = (AbstractCard)new GunMom();
/*    */   }
/*    */   private static final int COST = 1;
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 35 */     addToBot((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_VERTICAL));
/* 36 */     addToBot((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_HORIZONTAL));
/* 37 */     addToBot((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
/* 38 */     addToBot((AbstractGameAction)new MakeTempCardInHandAction((AbstractCard)new GunMom(), 3));
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 42 */     return (AbstractCard)new MothersDay();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 46 */     if (!this.upgraded) {
/* 47 */       upgradeName();
/* 48 */       upgradeDamage(2);
/* 49 */       this.rawDescription = UPGRADE_DESCRIPTION;
/* 50 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\MothersDay.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */