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

import static ottoMod.OttoMod.makeId;
/*    */ 
/*    */ public class Defend_Otto
/*    */   extends CustomCard
/*    */ {
/* 19 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Defend_Otto");
/* 20 */   public static final String NAME = cardStrings.NAME;
/* 21 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/*    */   
/*    */   private static final int COST = 1;
/*    */   private static final int BLOCK_AMT = 5;
/*    */   private static final int UPGRADE_PLUS_BLOCK = 3;
/*    */   public static final String ID = makeId("Defend_Otto");
/*    */   public static final String IMG_PATH = "img/otto/Defend.png";
/*    */   
/*    */   public Defend_Otto() {
/* 30 */     super("Defend_Otto", NAME, "img/otto/Defend.png", 1, DESCRIPTION, CardType.SKILL, CardColorEnum.ottogreen, CardRarity.BASIC, CardTarget.SELF);
/*    */     
/* 32 */     this.tags.add(CardTags.STARTER_DEFEND);
/* 33 */     this.baseBlock = 5;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 39 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new GainBlockAction((AbstractCreature)p, (AbstractCreature)p, this.block));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 45 */     return (AbstractCard)new Defend_Otto();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isDefend() {
/* 51 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 57 */     if (!this.upgraded) {
/*    */       
/* 59 */       upgradeName();
/* 60 */       upgradeBlock(3);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\Defend_Otto.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */