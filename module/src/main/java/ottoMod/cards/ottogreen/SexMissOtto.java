/*    */ package ottoMod.cards.ottogreen;
/*    */ 
/*    */

import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
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
/*    */ public class SexMissOtto
/*    */   extends CustomCard
/*    */ {
/*    */   public static final String ID = makeId("SexMissOtto");
/* 40 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("SexMissOtto");
/* 41 */   public static final String NAME = cardStrings.NAME;
/* 42 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/* 43 */   public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/otto/SexMissOtto.png";
/*    */   
/*    */   public SexMissOtto() {
/* 47 */     super("SexMissOtto", NAME, "img/otto/SexMissOtto.png", 0, DESCRIPTION, CardType.SKILL, CardColorEnum.ottogreen, CardRarity.RARE, CardTarget.SELF);
/* 48 */     this.magicNumber = this.baseMagicNumber = 2;
/* 49 */     this.tags.add(CardTags.HEALING);
/* 50 */     this.exhaust = true;
/*    */   }
/*    */   
/*    */   private static final int COST = 0;
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 57 */     if (p.hasPower("OttoMod:Delicious")) {
/* 58 */       AbstractDungeon.player.increaseMaxHp(this.magicNumber, true);
/*    */     }
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 64 */     return (AbstractCard)new SexMissOtto();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 68 */     if (!this.upgraded) {
/* 69 */       upgradeName();
/* 70 */       upgradeMagicNumber(1);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\SexMissOtto.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */