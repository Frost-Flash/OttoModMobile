//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ottoMod.cards.ottogreen;

import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainGoldAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.watcher.EndTurnDeathPower;
import com.megacrit.cardcrawl.vfx.BorderLongFlashEffect;
import com.megacrit.cardcrawl.vfx.RainingGoldEffect;
import ottoMod.enums.CardColorEnum;

public class TexasNight extends CustomCard {
    public static final String ID = "TexasNight";
    private static final CardStrings cardStrings;
    public static final String NAME;
    public static final String DESCRIPTION;
    public static final String UPGRADE_DESCRIPTION;
    public static final String IMG_PATH = "img/otto/TexasNight.png";
    private static final int COST = 0;
    private static final CardType TYPE;
    private static final CardColor COLOR;
    private static final CardRarity RARITY;
    private static final CardTarget TARGET;

    public TexasNight() {
        super("TexasNight", NAME, "img/otto/TexasNight.png", 0, DESCRIPTION, TYPE, COLOR, RARITY, TARGET);
        this.exhaust = true;
        this.retain = true;
        this.magicNumber = this.baseMagicNumber = 25;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
        this.addToBot(new VFXAction(new BorderLongFlashEffect(Color.GOLD)));
        this.addToBot(new GainGoldAction(this.magicNumber));
        this.addToBot(new VFXAction(new RainingGoldEffect(this.magicNumber)));
        this.addToBot(new ApplyPowerAction(p, p, new EndTurnDeathPower(p), 1));
    }

    public AbstractCard makeCopy() {
        return new TexasNight();
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeMagicNumber(5);
            this.rawDescription = UPGRADE_DESCRIPTION;
            this.initializeDescription();
        }

    }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings("TexasNight");
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
        UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
        TYPE = CardType.SKILL;
        COLOR = CardColorEnum.ottogreen;
        RARITY = CardRarity.RARE;
        TARGET = CardTarget.SELF;
    }
}
