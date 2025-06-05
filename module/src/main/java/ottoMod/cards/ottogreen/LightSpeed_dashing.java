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
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.ArtifactPower;
import com.megacrit.cardcrawl.powers.DexterityPower;
import ottoMod.effects.PushWheelEffect;
import ottoMod.enums.CardColorEnum;
import ottoMod.enums.CustomTags;

import static ottoMod.OttoMod.makeId;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LightSpeed_dashing
/*    */   extends CustomCard
/*    */ {
/*    */   public static final String ID = makeId("LightSpeed_dashing");
/* 26 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("LightSpeed_dashing");
/* 27 */   public static final String NAME = cardStrings.NAME;
/* 28 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/* 29 */   public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/otto/LightSpeed.png";
/*    */   private static final int COST = 2;
/* 32 */   private static final CardType TYPE = CardType.SKILL;
/*    */   public LightSpeed_dashing() {
/* 34 */     super("LightSpeed_dashing", NAME, "img/otto/LightSpeed.png", 2, DESCRIPTION, TYPE, CardColorEnum.ottogreen, CardRarity.RARE, CardTarget.SELF);
/* 35 */     this.magicNumber = this.baseMagicNumber = 6;
/* 36 */     this.tags.add(CustomTags.DASHING);
/* 37 */     this.exhaust = true;
/*    */   }
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 42 */     (new PushWheelEffect()).trigger(this.magicNumber);
/* 43 */     addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new ArtifactPower((AbstractCreature)p, 1), 1));
/* 44 */     addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new DexterityPower((AbstractCreature)p, !this.upgraded ? 1 : 2), !this.upgraded ? 1 : 2));
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 48 */     return (AbstractCard)new LightSpeed_dashing();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 52 */     if (!this.upgraded) {
/* 53 */       upgradeName();
/* 54 */       upgradeMagicNumber(1);
/*    */       
/* 56 */       this.rawDescription = UPGRADE_DESCRIPTION;
/* 57 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\LightSpeed_dashing.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */