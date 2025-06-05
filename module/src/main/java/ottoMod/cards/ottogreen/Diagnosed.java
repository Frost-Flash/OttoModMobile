/*    */ package ottoMod.cards.ottogreen;
/*    */ 
/*    */

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
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
/*    */ public class Diagnosed
/*    */   extends CustomCard
/*    */ {
/*    */   public static final String ID = makeId("Diagnosed");
/* 30 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Diagnosed");
/* 31 */   public static final String NAME = cardStrings.NAME;
/* 32 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/* 33 */   public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/otto/Diagnosed.png";
/*    */   
/*    */   public Diagnosed() {
/* 37 */     super("Diagnosed", NAME, "img/otto/Diagnosed.png", 1, DESCRIPTION, CardType.SKILL, CardColorEnum.ottogreen, CardRarity.COMMON, CardTarget.ALL_ENEMY);
/* 38 */     this.magicNumber = this.baseMagicNumber = 3;
/*    */   }
/*    */   private static final int COST = 1;
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 42 */     if (!AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
/* 43 */       flash();
/* 44 */       Iterator<AbstractMonster> var3 = (AbstractDungeon.getMonsters()).monsters.iterator();
/*    */       
/* 46 */       while (var3.hasNext()) {
/* 47 */         AbstractMonster monster = var3.next();
/* 48 */         if (!monster.isDead && !monster.isDying) {
/* 49 */           addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)monster, (AbstractCreature)p, (AbstractPower)new Cancer((AbstractCreature)monster, this.magicNumber), this.magicNumber));
/* 50 */           addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)monster, (AbstractCreature)p, (AbstractPower)new WeakPower((AbstractCreature)monster, this.magicNumber - 2, false), this.magicNumber - 2));
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 57 */     return (AbstractCard)new Diagnosed();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 61 */     if (!this.upgraded) {
/* 62 */       upgradeName();
/* 63 */       upgradeMagicNumber(1);
/* 64 */       this.rawDescription = this.upgraded ? cardStrings.UPGRADE_DESCRIPTION : cardStrings.DESCRIPTION;
/*    */ 
/*    */       
/* 67 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\Diagnosed.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */