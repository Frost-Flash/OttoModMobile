/*    */ package ottoMod.cards.ottogreen;
/*    */ 
/*    */

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ExhaustAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.unique.AddCardToDeckAction;
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
/*    */ public class NutHead
/*    */   extends CustomCard
/*    */ {
/*    */   public static final String ID = makeId("NutHead");
/* 34 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("NutHead");
/* 35 */   public static final String NAME = cardStrings.NAME;
/* 36 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/* 37 */   public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/otto/NutHead.png";
/*    */   private static final int COST = 1;
/* 40 */   private static final CardType TYPE = CardType.SKILL;
/* 41 */   private static final CardColor COLOR = CardColorEnum.ottogreen;
/* 42 */   private static final CardRarity RARITY = CardRarity.UNCOMMON;
/* 43 */   private static final CardTarget TARGET = CardTarget.SELF;
/*    */   public NutHead() {
/* 45 */     super("NutHead", NAME, "img/otto/NutHead.png", 1, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
/* 46 */     this.magicNumber = this.baseMagicNumber = 1;
/* 47 */     this.cardsToPreview = (AbstractCard)new S_D_D_L();
/* 48 */     this.isEthereal = true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 55 */     addToBot((AbstractGameAction)new ExhaustAction(this.magicNumber, false, false, false));
/* 57 */     addToBot(new AbstractGameAction()
/*    */         {
/*    */           public void update()
/*    */           {
/*    */             while (true) {
/* 62 */               AbstractCard ck = AbstractDungeon.returnTrulyRandomColorlessCardInCombat().makeCopy();
/*    */               
/* 64 */               if (ck.rarity != CardRarity.SPECIAL && !ck.cardID.equals("Apotheosis")) {
/* 65 */                 ck.setCostForTurn(-99);
/* 66 */                 addToBot((AbstractGameAction)new MakeTempCardInHandAction(ck, false));
/* 67 */                 this.isDone = true; return;
/*    */               } 
/*    */             }  } });
/* 70 */     S_D_D_L s_D_D_L = new S_D_D_L();
/* 71 */     s_D_D_L.upgrade();
/* 72 */     addToBot((AbstractGameAction)new AddCardToDeckAction(!this.upgraded ? (AbstractCard)new S_D_D_L() : (AbstractCard)s_D_D_L));
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 77 */     if (!this.upgraded) {
/* 78 */       upgradeName();
/* 79 */       upgradeBaseCost(0);
/* 80 */       this.rawDescription = UPGRADE_DESCRIPTION;
/* 81 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 86 */     return (AbstractCard)new NutHead();
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\NutHead.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */