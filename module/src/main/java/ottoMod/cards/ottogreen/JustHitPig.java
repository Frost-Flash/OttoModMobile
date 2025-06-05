//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ottoMod.cards.ottogreen;

import com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.cards.DamageInfo.DamageType;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.AbstractPower.PowerType;
import ottoMod.enums.CardColorEnum;

public class JustHitPig extends CustomCard {
    public static final String ID = "JustHitPig";
    private static final CardStrings cardStrings;
    public static final String NAME;
    public static final String DESCRIPTION;
    public static final String UPGRADE_DESCRIPTION;
    public static final String IMG_PATH = "img/otto/JustHitPig.png";
    private static final int COST = 3;
    private static final int ATTACK_DMG = 13;
    private static final int UPGRADE_PLUS_DMG = 4;

    public JustHitPig() {
        super("JustHitPig", NAME, "img/otto/JustHitPig.png", 3, DESCRIPTION, CardType.ATTACK, CardColorEnum.ottogreen, CardRarity.COMMON, CardTarget.ENEMY);
        this.damage = this.baseDamage = 13;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
        this.addToBot(new DamageAction(m, new DamageInfo(p, this.damage, DamageType.NORMAL), AttackEffect.SLASH_HEAVY));

        for(AbstractPower power : m.powers) {
            if (power.type == PowerType.DEBUFF && !power.ID.equals("Shackled")) {
                this.addToBot(new DamageAction(m, new DamageInfo(p, this.damage, DamageType.NORMAL), AttackEffect.SLASH_HEAVY));
                CardCrawlGame.sound.play("JustHitPig");
            }
        }

    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeDamage(4);
            this.rawDescription = UPGRADE_DESCRIPTION;
            this.initializeDescription();
        }

    }

    public AbstractCard makeCopy() {
        return new JustHitPig();
    }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings("JustHitPig");
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
        UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
    }
}
