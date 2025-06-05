/*    */ package ottoMod.cards.ottogreen;
/*    */ 
/*    */

import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.vfx.AbstractGameEffect;
import com.megacrit.cardcrawl.vfx.BorderLongFlashEffect;
import com.megacrit.cardcrawl.vfx.ThoughtBubble;
import ottoMod.enums.CardColorEnum;

import static ottoMod.OttoMod.makeId;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GodsCovenant
/*    */   extends CustomCard
/*    */ {
/*    */   public static final String ID = makeId("GodsCovenant");
/* 31 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("GodsCovenant");
/* 32 */   public static final String NAME = cardStrings.NAME;
/* 33 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/* 34 */   public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/otto/GodsCovenant.png";
/*    */   private static final int COST = 1;
/*    */   
/*    */   public GodsCovenant() {
/* 39 */     super("GodsCovenant", NAME, "img/otto/GodsCovenant.png", 1, DESCRIPTION, CardType.SKILL, CardColorEnum.ottogreen, CardRarity.UNCOMMON, CardTarget.SELF);
/* 40 */     this.magicNumber = this.baseMagicNumber = 1;
/*    */     
/* 42 */     this.cardsToPreview = (AbstractCard)new GodsRevival();
/* 43 */     this.exhaust = true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 48 */     addToBot((AbstractGameAction)new VFXAction((AbstractGameEffect)new BorderLongFlashEffect(Color.ORANGE)));
/* 49 */     AbstractDungeon.effectList.add(new ThoughtBubble(AbstractDungeon.player.dialogX, AbstractDungeon.player.dialogY, 3.0F, "「哈比下，哈比下，哈比下——」信徒们一遍又一遍，不知疲惫般...", true));
/* 50 */     GodsRevival godsRevival = new GodsRevival();
/* 51 */     godsRevival.upgrade();
/* 52 */     addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new StrengthPower((AbstractCreature)p, this.magicNumber), this.magicNumber));
/* 53 */     addToBot((AbstractGameAction)new MakeTempCardInDrawPileAction(!this.upgraded ? (AbstractCard)new GodsRevival() : (AbstractCard)godsRevival, 1, true, true));
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 57 */     return (AbstractCard)new GodsCovenant();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 61 */     if (!this.upgraded) {
/* 62 */       upgradeName();
/* 63 */       upgradeMagicNumber(1);
/* 64 */       this.rawDescription = UPGRADE_DESCRIPTION;
/* 65 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\GodsCovenant.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */