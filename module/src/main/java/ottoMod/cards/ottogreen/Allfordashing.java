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
import ottoMod.effects.PushWheelEffect;
import ottoMod.enums.CardColorEnum;
import ottoMod.enums.CustomTags;
import ottoMod.powers.Fury;

import static ottoMod.OttoMod.makeId;
/*    */

/*    */
/*    */ 
/*    */ public class Allfordashing
/*    */   extends CustomCard
/*    */ {
/*    */   public static final String ID = makeId("Allfordashing");
/* 27 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Allfordashing");
/* 28 */   public static final String NAME = cardStrings.NAME;
/* 29 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/otto/Allfordashing.png";
/*    */   private static final int COST = -1;
/*    */   
/*    */   public Allfordashing() {
/* 34 */     super("Allfordashing", NAME, "img/otto/Allfordashing.png", -1, DESCRIPTION, CardType.SKILL, CardColorEnum.ottogreen, CardRarity.UNCOMMON, CardTarget.SELF);
/* 35 */     this.tags.add(CustomTags.DASHING);
/* 36 */     this.baseMagicNumber = this.magicNumber = 0;
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 41 */     if (!this.upgraded) {
/* 42 */       upgradeName();
/* 43 */       this.rawDescription = this.upgraded ? cardStrings.UPGRADE_DESCRIPTION : cardStrings.DESCRIPTION;
/*    */ 
/*    */       
/* 46 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 52 */     int energyAmount = this.energyOnUse;
/* 53 */     if (p.hasRelic("Chemical X")) {
/* 54 */       energyAmount += 2;
/* 55 */       p.getRelic("Chemical X").flash();
/*    */     } 
/*    */     
/* 58 */     if (energyAmount > 0 || (energyAmount == 0 && this.upgraded)) {
/* 59 */       int finalAmount = this.upgraded ? (energyAmount + 1) : energyAmount;
/* 60 */       for (int i = 0; i < finalAmount; i++) {
/* 61 */         (new PushWheelEffect()).trigger(1);
/* 62 */         addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new Fury((AbstractCreature)p, 1), 1));
/*    */       } 
/*    */     } 
/*    */     
/* 67 */     if (!this.freeToPlayOnce) AbstractDungeon.player.energy.use(energyAmount);
/*    */   
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 72 */     return (AbstractCard)new Allfordashing();
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\Allfordashing.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */