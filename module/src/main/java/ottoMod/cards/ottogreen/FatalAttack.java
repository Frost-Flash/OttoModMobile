/*    */ package ottoMod.cards.ottogreen;
/*    */ 
/*    */

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.vfx.ThoughtBubble;
import ottoMod.enums.CardColorEnum;
import ottoMod.powers.Cancer;

import static ottoMod.OttoMod.makeId;
/*    */ 
/*    */ public class FatalAttack
/*    */   extends CustomCard
/*    */ {
/*    */   public static final String ID = makeId("FatalAttack");
/* 26 */   private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("FatalAttack");
/* 27 */   public static final String NAME = cardStrings.NAME;
/* 28 */   public static final String DESCRIPTION = cardStrings.DESCRIPTION;
/* 29 */   public static final String UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
/*    */   public static final String IMG_PATH = "img/otto/FatalAttack.png";
/*    */   
/*    */   public FatalAttack() {
/* 33 */     super("FatalAttack", NAME, "img/otto/FatalAttack.png", 0, DESCRIPTION, CardType.ATTACK, CardColorEnum.ottogreen, CardRarity.RARE, CardTarget.ENEMY);
/* 34 */     this.magicNumber = this.baseMagicNumber = 8;
/* 35 */     this.damage = this.baseDamage = 8;
/*    */   }
/*    */   
/*    */   private static final int COST = 0;
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
/* 42 */     addToBot((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, DamageInfo.DamageType.NORMAL), AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
/* 43 */     if (m.hasPower("OttoMod:Cancer")) {
/* 44 */       if ((m.getPower("OttoMod:Cancer")).amount >= 15) {
/* 45 */         addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)m, (AbstractCreature)p, (AbstractPower)new Cancer((AbstractCreature)m, this.magicNumber), this.magicNumber));
/*    */       } else {
/*    */         
/* 48 */         AbstractDungeon.effectList.add(new ThoughtBubble(AbstractDungeon.player.dialogX, AbstractDungeon.player.dialogY, 3.0F, "这名敌人不是癌症晚期！", true));
/*    */       } 
/*    */     } else {
/* 51 */       AbstractDungeon.effectList.add(new ThoughtBubble(AbstractDungeon.player.dialogX, AbstractDungeon.player.dialogY, 3.0F, "这名敌人没有癌症！", true));
/*    */     } 
/*    */   }
/*    */   
/*    */   public AbstractCard makeCopy() {
/* 56 */     return (AbstractCard)new FatalAttack();
/*    */   }
/*    */   
/*    */   public void upgrade() {
/* 60 */     if (!this.upgraded) {
/* 61 */       upgradeName();
/* 62 */       upgradeMagicNumber(2);
/* 63 */       upgradeDamage(2);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\桌面\尖塔移植计划\otto原版\!\ottoMod\cards\FatalAttack.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */