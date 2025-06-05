//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ottoMod.cards.ottogreen;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.watcher.VigorPower;
import ottoMod.enums.CardColorEnum;

public class LoseHomeDog extends CustomCard {
    public static final String ID = "LoseHomeDog";
    private static final CardStrings cardStrings;
    public static final String NAME;
    public static final String DESCRIPTION;
    public static final String UPGRADE_DESCRIPTION;
    public static final String IMG_PATH = "img/otto/LoseHomeDog.png";
    private static final int COST = 1;

    public LoseHomeDog() {
        super("LoseHomeDog", NAME, "img/otto/LoseHomeDog.png", 1, DESCRIPTION, CardType.SKILL, CardColorEnum.ottogreen, CardRarity.COMMON, CardTarget.SELF);
        this.magicNumber = this.baseMagicNumber = 0;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
        int FuryAmount = 0;
        if (p.hasPower("ottoMod:Fury")) {
            FuryAmount = p.getPower("ottoMod:Fury").amount;
            this.addToTop(new ApplyPowerAction(p, p, new VigorPower(p, FuryAmount * 2), FuryAmount * 2));
            this.addToTop(new RemoveSpecificPowerAction(p, p, "ottoMod:Fury"));
        }

        if (this.magicNumber > 0) {
            this.addToTop(new ApplyPowerAction(p, p, new VigorPower(p, this.magicNumber), this.magicNumber));
        }

    }

    public AbstractCard makeCopy() {
        return new LoseHomeDog();
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
        cardStrings = CardCrawlGame.languagePack.getCardStrings("LoseHomeDog");
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
        UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
    }
}
