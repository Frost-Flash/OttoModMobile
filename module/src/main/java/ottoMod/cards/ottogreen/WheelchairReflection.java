//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ottoMod.cards.ottogreen;

import com.megacrit.cardcrawl.actions.common.HealAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import ottoMod.enums.CardColorEnum;

public class WheelchairReflection extends CustomCard {
    public static final String ID = "WheelchairReflection";
    private static final CardStrings cardStrings;
    public static final String NAME;
    public static final String DESCRIPTION;
    private static final int BASE_BLOCK = 4;
    private static final int BASE_COST = 0;
    public static final String IMG_PATH = "img/otto/WheelchairReflection.png";

    public WheelchairReflection() {
        super("WheelchairReflection", cardStrings.NAME, "img/otto/WheelchairReflection.png", 0, DESCRIPTION, CardType.SKILL, CardColorEnum.ottogreen, CardRarity.RARE, CardTarget.SELF);
        this.block = this.baseBlock = 4;
        this.magicNumber = this.baseMagicNumber = 2;
        this.isEthereal = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
        this.updateCost(this.cost + 1);
        if (p.hasPower("ottoMod:Delicious")) {
            AbstractDungeon.actionManager.addToBottom(new HealAction(p, p, 2 * this.block));
            this.addToBot(new HealAction(p, p, 2 * this.magicNumber));
        } else {
            AbstractDungeon.actionManager.addToBottom(new HealAction(p, p, this.block));
            this.addToBot(new HealAction(p, p, this.magicNumber));
        }

    }

    public AbstractCard makeCopy() {
        return new WheelchairReflection();
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeBlock(1);
            this.upgradeMagicNumber(1);
        }

    }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings("WheelchairReflection");
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
    }
}
