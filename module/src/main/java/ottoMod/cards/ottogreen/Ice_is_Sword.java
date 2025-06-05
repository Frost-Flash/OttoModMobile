/*    */ package ottoMod.cards.ottogreen;
/*    */ 
/*    */

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import ottoMod.enums.CardColorEnum;
import ottoMod.enums.CustomTags;

import static ottoMod.OttoMod.makeId;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Ice_is_Sword
/*    */   extends CustomCard
/*    */ {
/*    */   public static final String ID = makeId("Ice_is_Sword");
/* 29 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Ice_is_Sword");
/* 30 */   public static final String NAME = cardStrings.NAME;
/* 31 */   private static final String DESCRIPTION = cardStrings.DESCRIPTION;
/*    */   
/*    */   public static final String IMG_PATH = "img/otto/Ice_is_Sword.png";
/*    */   
/*    */   public Ice_is_Sword() {
/* 36 */     super("Ice_is_Sword", NAME, "img/otto/Ice_is_Sword.png", 4, DESCRIPTION, CardType.SKILL, CardColorEnum.ottogreen, CardRarity.UNCOMMON, CardTarget.SELF);
/* 37 */     this.baseBlock = 11;
/*    */   }
/*    */   private static final int COST = 4; private static final int BLOCK_AMT = 11;
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 42 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new GainBlockAction((AbstractCreature)p, (AbstractCreature)p, this.block));
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 46 */     if (!this.upgraded) {
/* 47 */       upgradeName();
/* 48 */       upgradeBlock(4);
/* 49 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */   
/*    */   public void triggerOnCardPlayed(AbstractCard c) {
/* 54 */     if (c.hasTag(CustomTags.DASHING) && this.cost > 0) {
/* 55 */       updateCost(-1);
/* 56 */       addToBot(new AbstractGameAction()
/*    */           {
/*    */             public void update()
/*    */             {
/* 61 */               this.isDone = true;
/*    */             }
/*    */           });
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 69 */     return (AbstractCard)new Ice_is_Sword();
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\Ice_is_Sword.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */