//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ottoMod.cards.ottogreen;

import com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.utility.SFXAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo.DamageType;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import ottoMod.enums.CardColorEnum;

public class Offensibility extends CustomCard {
    public static final String ID = "Offensibility";
    private static final CardStrings cardStrings;
    public static final String NAME;
    public static final String DESCRIPTION;
    public static final String UPGRADE_DESCRIPTION;
    public static final String IMG_PATH = "img/otto/Offensibility.png";
    private static final int COST = 2;

    public Offensibility() {
        super("Offensibility", NAME, "img/otto/Offensibility.png", 2, DESCRIPTION, CardType.ATTACK, CardColorEnum.ottogreen, CardRarity.COMMON, CardTarget.ALL_ENEMY);
        this.baseDamage = 10;
        this.isMultiDamage = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
        if (p.hasPower("OttoMod:Delicious")) {
            this.addToBot(new DamageAllEnemiesAction(p, this.multiDamage, DamageType.NORMAL, AttackEffect.LIGHTNING));
            this.addToTop(new SFXAction("ORB_LIGHTNING_EVOKE", 0.1F));
            this.addToBot(new DamageAllEnemiesAction(p, this.multiDamage, DamageType.NORMAL, AttackEffect.LIGHTNING));
            this.addToTop(new SFXAction("ORB_LIGHTNING_EVOKE", 0.1F));
        } else {
            this.addToBot(new DamageAllEnemiesAction(p, this.multiDamage, DamageType.NORMAL, AttackEffect.BLUNT_LIGHT));
        }

    }

    public AbstractCard makeCopy() {
        return new Offensibility();
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeDamage(4);
            this.rawDescription = UPGRADE_DESCRIPTION;
            this.initializeDescription();
        }

    }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings("Offensibility");
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
        UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
    }
}
