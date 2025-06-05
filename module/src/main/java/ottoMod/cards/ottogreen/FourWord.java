/*    */ package ottoMod.cards.ottogreen;
/*    */ 
/*    */

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.HealAction;
import com.megacrit.cardcrawl.actions.unique.ArmamentsAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import ottoMod.enums.CardColorEnum;
import ottoMod.powers.Fury;

import static ottoMod.OttoMod.makeId;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FourWord
/*    */   extends CustomCard
/*    */ {
/*    */   public static final String ID = makeId("FourWord");
/* 24 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("FourWord");
/* 25 */   public static final String NAME = cardStrings.NAME;
/* 26 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/* 27 */   public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/otto/FourWord.png";
/*    */   
/*    */   public FourWord() {
/* 31 */     super("FourWord", NAME, "img/otto/FourWord.png", 1, DESCRIPTION, CardType.SKILL, CardColorEnum.ottogreen, CardRarity.COMMON, CardTarget.SELF);
/* 32 */     this.magicNumber = this.baseMagicNumber = 3;
/* 33 */     this.tags.add(CardTags.HEALING);
/*    */   }
/*    */   private static final int COST = 1;
/*    */   public void upgrade() {
/* 37 */     if (!this.upgraded) {
/* 38 */       upgradeName();
/* 39 */       upgradeMagicNumber(1);
/* 40 */       this.rawDescription = this.upgraded ? cardStrings.UPGRADE_DESCRIPTION : cardStrings.DESCRIPTION;
/*    */ 
/*    */       
/* 43 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 49 */     addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new Fury((AbstractCreature)p, this.magicNumber), this.magicNumber));
/*    */     
/* 51 */     addToBot((AbstractGameAction)new HealAction((AbstractCreature)p, (AbstractCreature)p, 1));
/* 52 */     if (p.hasPower("OttoMod:Delicious")) {
/* 53 */       addToBot(new AbstractGameAction()
/*    */           {
/*    */             public void update() {
/* 56 */               addToBot((AbstractGameAction)new ArmamentsAction((FourWord.this.magicNumber != 3)));
/*    */               
/* 58 */               this.isDone = true;
/*    */             }
/*    */           });
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 66 */     return (AbstractCard)new FourWord();
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\FourWord.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */