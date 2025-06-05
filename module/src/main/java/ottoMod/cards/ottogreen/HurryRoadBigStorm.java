/*    */ package ottoMod.cards.ottogreen;
/*    */ 
/*    */

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.unique.DiscardPileToTopOfDeckAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import com.megacrit.cardcrawl.vfx.AbstractGameEffect;
import com.megacrit.cardcrawl.vfx.combat.WhirlwindEffect;
import ottoMod.enums.CardColorEnum;

import java.util.Iterator;

import static ottoMod.OttoMod.makeId;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HurryRoadBigStorm
/*    */   extends CustomCard
/*    */ {
/*    */   public static final String ID = makeId("HurryRoadBigStorm");
/* 32 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("HurryRoadBigStorm");
/* 33 */   public static final String NAME = cardStrings.NAME;
/* 34 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/* 35 */   public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/otto/HurryRoadBigStorm.png";
/*    */   private static final int COST = 1;
/* 38 */   private static final CardType TYPE = CardType.SKILL;
/*    */   public HurryRoadBigStorm() {
/* 40 */     super("HurryRoadBigStorm", NAME, "img/otto/HurryRoadBigStorm.png", 1, DESCRIPTION, TYPE, CardColorEnum.ottogreen, CardRarity.COMMON, CardTarget.ALL_ENEMY);
/* 41 */     this.draw = this.baseDraw = 2;
/* 42 */     this.magicNumber = this.baseMagicNumber = 1;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 48 */     addToBot((AbstractGameAction)new DrawCardAction(this.draw));
/* 50 */     addToBot((AbstractGameAction)new VFXAction((AbstractGameEffect)new WhirlwindEffect(), 0.0F));
/* 51 */     if (!AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
/* 52 */       flash();
/* 53 */       Iterator<AbstractMonster> var3 = (AbstractDungeon.getMonsters()).monsters.iterator();
/* 54 */       while (var3.hasNext()) {
/* 55 */         AbstractMonster monster = var3.next();
/* 56 */         if (!monster.isDead && !monster.isDying) {
/* 57 */           addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)monster, (AbstractCreature)p, (AbstractPower)new VulnerablePower((AbstractCreature)monster, this.magicNumber, false), this.magicNumber));
/*    */         }
/*    */       } 
/*    */     } 
/*    */     
/* 62 */     if (p.hasPower("OttoMod:Delicious")) {
/* 63 */       addToBot((AbstractGameAction)new DiscardPileToTopOfDeckAction((AbstractCreature)p));
/*    */     }
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 68 */     return (AbstractCard)new HurryRoadBigStorm();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 72 */     if (!this.upgraded) {
/* 73 */       upgradeName();
/* 74 */       upgradeMagicNumber(1);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\HurryRoadBigStorm.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */