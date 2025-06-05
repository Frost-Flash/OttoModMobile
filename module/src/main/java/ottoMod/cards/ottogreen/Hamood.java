//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ottoMod.cards.ottogreen;

import com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.cards.DamageInfo.DamageType;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.ThoughtBubble;
import ottoMod.enums.CardColorEnum;
import ottoMod.enums.CustomTags;
import ottoMod.powers.WheelBoostPower;

public class Hamood extends CustomCard {
    public static final String ID = "Hamood";
    private static final CardStrings cardStrings;
    public static final String NAME;
    public static final String DESCRIPTION;
    public static final String IMG_PATH = "img/otto/Hamood.png";
    private static final int COST = 3;

    public Hamood() {
        super("Hamood", NAME, "img/otto/Hamood.png", 3, DESCRIPTION, CardType.ATTACK, CardColorEnum.ottogreen, CardRarity.RARE, CardTarget.ENEMY);
        this.damage = this.baseDamage = 36;
        this.isEthereal = true;
        this.magicNumber = this.baseMagicNumber = 1;
        this.tags.add(CustomTags.AfterLife);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        CardCrawlGame.sound.play("Hamood");
        AbstractDungeon.effectList.add(new ThoughtBubble(AbstractDungeon.player.dialogX, AbstractDungeon.player.dialogY, 1.2F, "哈姆？", true));
        this.addToBot(new DamageAction(m, new DamageInfo(p, this.damage, DamageType.NORMAL), AttackEffect.POISON));
        this.addToBot(new ApplyPowerAction(p, p, new WheelBoostPower(p, this.magicNumber), this.magicNumber));
    }

    public void triggerOnExhaust() {
        AbstractPlayer p = AbstractDungeon.player;
        CardCrawlGame.sound.play("Hamood");
        AbstractDungeon.effectList.add(new ThoughtBubble(AbstractDungeon.player.dialogX, AbstractDungeon.player.dialogY, 1.2F, "哈姆！", true));
        this.addToBot(new ApplyPowerAction(p, p, new WheelBoostPower(p, this.magicNumber), this.magicNumber));
    }

    public AbstractCard makeCopy() {
        return new Hamood();
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeDamage(9);
            this.upgradeMagicNumber(1);
        }

    }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings("Hamood");
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
    }
}
