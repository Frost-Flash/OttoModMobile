/*    */ package ottoMod.cards.ottogreen;
/*    */ 
/*    */

import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.HealAction;
import com.megacrit.cardcrawl.actions.watcher.PressEndTurnButtonAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.AbstractGameEffect;
import com.megacrit.cardcrawl.vfx.BorderLongFlashEffect;
import ottoMod.enums.CardColorEnum;

import static ottoMod.OttoMod.makeId;
/*    */ 
/*    */ public class SleepMan
/*    */   extends CustomCard {
/*    */   public static final String ID = makeId("SleepMan");
/* 22 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("SleepMan");
/* 23 */   public static final String NAME = cardStrings.NAME;
/* 24 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/otto/SleepMan.png";
/*    */   
/*    */   public SleepMan() {
/* 28 */     super("SleepMan", NAME, "img/otto/SleepMan.png", 2, DESCRIPTION, CardType.SKILL, CardColorEnum.ottogreen, CardRarity.UNCOMMON, CardTarget.SELF);
/* 29 */     this.magicNumber = this.baseMagicNumber = 9;
/* 30 */     this.exhaust = true;
/* 31 */     this.tags.add(CardTags.HEALING);
/*    */   }
/*    */   private static final int COST = 2;
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 35 */     addToBot((AbstractGameAction)new VFXAction((AbstractGameEffect)new BorderLongFlashEffect(Color.SKY)));
/* 36 */     addToBot((AbstractGameAction)new HealAction((AbstractCreature)p, (AbstractCreature)p, this.magicNumber));
/* 37 */     addToBot((AbstractGameAction)new PressEndTurnButtonAction());
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 41 */     return (AbstractCard)new SleepMan();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 45 */     if (!this.upgraded) {
/* 46 */       upgradeName();
/* 47 */       upgradeMagicNumber(2);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\SleepMan.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */