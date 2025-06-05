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
import ottoMod.enums.CardColorEnum;

import static ottoMod.OttoMod.makeId;
/*    */ 
/*    */ public class StableGun extends CustomCard {
/*    */   public static final String ID = makeId("StableGun");
/* 19 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("StableGun");
/* 20 */   public static final String NAME = cardStrings.NAME;
/* 21 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/otto/StableGun.png";
/*    */   
/*    */   public StableGun() {
/* 25 */     super("StableGun", NAME, "img/otto/StableGun.png", 1, DESCRIPTION, CardType.ATTACK, CardColorEnum.ottogreen, CardRarity.UNCOMMON, CardTarget.ENEMY);
/* 26 */     this.damage = this.baseDamage = 4;
/* 27 */     this.magicNumber = this.baseMagicNumber = 12;
/*    */   }
/*    */   private static final int COST = 1;
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 32 */     addToBot((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, !p.hasPower("OttoMod:Delicious") ? this.damage : (this.damage + this.magicNumber), DamageInfo.DamageType.NORMAL), p.hasPower("OttoMod:Delicious") ? AbstractGameAction.AttackEffect.SLASH_HEAVY : AbstractGameAction.AttackEffect.BLUNT_LIGHT));
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 36 */     return (AbstractCard)new StableGun();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 40 */     if (!this.upgraded) {
/* 41 */       upgradeName();
/* 42 */       upgradeDamage(1);
/* 43 */       upgradeMagicNumber(3);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\StableGun.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */