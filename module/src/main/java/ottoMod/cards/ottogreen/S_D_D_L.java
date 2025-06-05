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

import java.util.ArrayList;

import static ottoMod.OttoMod.makeId;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class S_D_D_L
/*    */   extends CustomCard
/*    */ {
/*    */   public static final String ID = makeId("S_D_D_L");
/* 30 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("S_D_D_L");
/* 31 */   public static final String NAME = cardStrings.NAME;
/* 32 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/* 33 */   public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/otto/SDDL.png";
/*    */   private static final int COST = 1;
/* 36 */   private static final CardType TYPE = CardType.SKILL;
/* 37 */   private static final CardColor COLOR = CardColorEnum.ottogreen;
/* 38 */   private static final CardRarity RARITY = CardRarity.UNCOMMON;
/* 39 */   private static final CardTarget TARGET = CardTarget.SELF;
/*    */   public S_D_D_L() {
/* 41 */     super("S_D_D_L", NAME, "img/otto/SDDL.png", 1, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
/* 42 */     this.magicNumber = this.baseMagicNumber = 1;
/* 43 */     this.isEthereal = true;
/*    */   }
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 48 */     addToBot((AbstractGameAction)new ExhaustAction(this.magicNumber, false, false, false));
/* 50 */     addToBot(new AbstractGameAction()
/*    */         {
/*    */           public void update()
/*    */           {
/*    */             while (true) {
/* 55 */               AbstractCard ck = AbstractDungeon.returnTrulyRandomCardInCombat().makeCopy();
/*    */               
/* 57 */               if (ck.rarity == CardRarity.UNCOMMON && !ck.cardID.equals("NutHead")) {
/* 58 */                 ck.setCostForTurn(-99);
/* 59 */                 addToBot((AbstractGameAction)new MakeTempCardInHandAction(ck, false));
/* 60 */                 this.isDone = true; return;
/*    */               } 
/*    */             }  } });
/* 63 */     NutHead nutHead = new NutHead();
/* 64 */     nutHead.upgrade();
/* 65 */     addToBot((AbstractGameAction)new AddCardToDeckAction(!this.upgraded ? (AbstractCard)new NutHead() : (AbstractCard)nutHead));
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 69 */     return (AbstractCard)new S_D_D_L();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 73 */     if (!this.upgraded) {
/* 74 */       upgradeName();
/* 75 */       upgradeBaseCost(0);
/* 76 */       this.rawDescription = UPGRADE_DESCRIPTION;
/* 77 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */   
/*    */   public boolean canSpawn(ArrayList<AbstractCard> currentRewardCards) {
/* 82 */     return false;
/*    */   }
/*    */   
/*    */   public boolean canSpawnShop(ArrayList<AbstractCard> currentRewardCards) {
/* 86 */     return false;
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\S_D_D_L.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */