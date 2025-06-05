/*    */ package ottoMod.cards.ottogreen;
/*    */ 
/*    */

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.ModifyBlockAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Zouwei
/*    */   extends CustomCard
/*    */ {
/*    */   public static final String ID = makeId("Zouwei");
/* 32 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Zouwei");
/* 33 */   public static final String NAME = cardStrings.NAME;
/* 34 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/* 35 */   public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/otto/Zouwei.png";
/*    */   private static final int COST = 0;
/* 38 */   private static final CardType TYPE = CardType.SKILL;
/* 39 */   private static final CardColor COLOR = CardColorEnum.ottogreen;
/* 40 */   private static final CardRarity RARITY = CardRarity.COMMON;
/* 41 */   private static final CardTarget TARGET = CardTarget.SELF;
/*    */   public Zouwei() {
/* 43 */     super("Zouwei", NAME, "img/otto/Zouwei.png", 0, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
/* 44 */     this.block = this.baseBlock = 4;
/* 45 */     this.exhaust = true;
/*    */   }
/*    */   
/*    */   public void use(final AbstractPlayer p, AbstractMonster m) {
/* 50 */     addToBot((AbstractGameAction)new GainBlockAction((AbstractCreature)p, (AbstractCreature)p, this.block));
/* 51 */     addToBot((AbstractGameAction)new ModifyBlockAction(this.uuid, -1));
/* 52 */     if (this.block > 1) {
/* 53 */       addToBot(new AbstractGameAction()
/*    */           {
/*    */             public void update() {
/* 56 */               AbstractCard newCard = Zouwei.this.makeStatEquivalentCopy();
/* 57 */               p.hand.addToTop(newCard);
/* 58 */               this.isDone = true;
/*    */             }
/*    */           });
/*    */     }
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 65 */     return (AbstractCard)new Zouwei();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 71 */     if (!this.upgraded) {
/* 72 */       upgradeName();
/* 73 */       upgradeBlock(1);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\Zouwei.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */