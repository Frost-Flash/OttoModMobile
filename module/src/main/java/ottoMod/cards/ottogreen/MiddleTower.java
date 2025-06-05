//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ottoMod.cards.ottogreen;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.HealAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DrawCardNextTurnPower;
import com.megacrit.cardcrawl.powers.EnergizedPower;
import ottoMod.enums.CardColorEnum;
import ottoMod.enums.CustomTags;

public class MiddleTower extends CustomCard {
    public static final String ID = "MiddleTower";
    private static final CardStrings cardStrings;
    public static final String NAME;
    public static final String DESCRIPTION;
    public static final String UPGRADE_DESCRIPTION;
    private static final int COST = 3;
    public static final String IMG_PATH = "img/otto/MiddleTower.png";
    private static final CardType TYPE;

    public MiddleTower() {
        super("MiddleTower", NAME, "img/otto/MiddleTower.png", 3, DESCRIPTION, TYPE, CardColorEnum.ottogreen, CardRarity.RARE, CardTarget.SELF);
        this.magicNumber = this.baseMagicNumber = 1;
        this.block = this.baseBlock = 15;
        this.tags.add(CustomTags.AfterLife);
        this.isEthereal = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
        this.addToBot(new HealAction(p, p, this.block));
        this.addToBot(new ApplyPowerAction(p, p, new DrawCardNextTurnPower(p, this.magicNumber), this.magicNumber));
        this.addToBot(new ApplyPowerAction(p, p, new EnergizedPower(p, this.magicNumber)));
    }

    public AbstractCard makeCopy() {
        return new MiddleTower();
    }

    public void triggerOnExhaust() {
        this.addToBot(new HealAction(AbstractDungeon.player, AbstractDungeon.player, this.block));
        this.addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new DrawCardNextTurnPower(AbstractDungeon.player, this.magicNumber), this.magicNumber));
        this.addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new EnergizedPower(AbstractDungeon.player, this.magicNumber)));
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeBlock(7);
        }

    }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings("MiddleTower");
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
        UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
        TYPE = CardType.SKILL;
    }
}
