/*    */ package ottoMod.cards.ottogreen;
/*    */ 
/*    */

import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.WeakPower;
import com.megacrit.cardcrawl.vfx.AbstractGameEffect;
import com.megacrit.cardcrawl.vfx.BorderLongFlashEffect;
import ottoMod.enums.CardColorEnum;
import ottoMod.powers.Cancer;

import java.util.Iterator;

import static ottoMod.OttoMod.makeId;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GodsSigh
/*    */   extends CustomCard
/*    */ {
/*    */   public static final String ID = makeId("GodsSigh");
/* 35 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("GodsSigh");
/* 36 */   public static final String NAME = cardStrings.NAME;
/* 37 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/* 38 */   public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/otto/GodsSigh.png";
/*    */   
/*    */   public GodsSigh() {
/* 42 */     super("GodsSigh", NAME, "img/otto/GodsSigh.png", 2, DESCRIPTION, CardType.SKILL, CardColorEnum.ottogreen, CardRarity.SPECIAL, CardTarget.ALL_ENEMY);
/* 43 */     this.magicNumber = this.baseMagicNumber = 4;
/* 44 */     this.cardsToPreview = (AbstractCard)new GodsGreat();
/* 45 */     this.exhaust = true;
/*    */   }
/*    */   private static final int COST = 2;
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 50 */     addToBot((AbstractGameAction)new VFXAction((AbstractGameEffect)new BorderLongFlashEffect(Color.LIGHT_GRAY)));
/* 51 */     GodsGreat godsGreat = new GodsGreat();
/* 52 */     godsGreat.upgrade();
/* 53 */     addToBot((AbstractGameAction)new MakeTempCardInDrawPileAction(!this.upgraded ? (AbstractCard)new GodsGreat() : (AbstractCard)godsGreat, 1, true, true));
/* 54 */     if (!AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
/* 55 */       flash();
/* 56 */       Iterator<AbstractMonster> var3 = (AbstractDungeon.getMonsters()).monsters.iterator();
/* 57 */       while (var3.hasNext()) {
/* 58 */         AbstractMonster monster = var3.next();
/* 59 */         if (!monster.isDead && !monster.isDying) {
/* 60 */           addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)monster, (AbstractCreature)p, (AbstractPower)new Cancer((AbstractCreature)monster, this.magicNumber), this.magicNumber));
/* 61 */           addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)monster, (AbstractCreature)p, (AbstractPower)new WeakPower((AbstractCreature)monster, this.magicNumber, false), this.magicNumber));
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 69 */     return (AbstractCard)new GodsSigh();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 73 */     if (!this.upgraded) {
/* 74 */       upgradeName();
/* 75 */       upgradeMagicNumber(1);
/* 76 */       this.rawDescription = UPGRADE_DESCRIPTION;
/* 77 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\GodsSigh.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */