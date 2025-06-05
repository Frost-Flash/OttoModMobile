//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ottoMod.cards.ottogreen;

import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.vfx.combat.CleaveEffect;
import ottoMod.enums.CardColorEnum;
import ottoMod.enums.CustomTags;

public class AriaSulG extends CustomCard {
    public static final String ID = "AriaSulG";
    private static final CardStrings cardStrings;
    public static final String NAME;
    public static final String DESCRIPTION;
    public static final String IMG_PATH = "img/otto/AriaSulG.png";
    private static final int COST = 2;

    public AriaSulG() {
        super("AriaSulG", NAME, "img/otto/AriaSulG.png", 2, DESCRIPTION, CardType.SKILL, CardColorEnum.ottogreen, CardRarity.UNCOMMON, CardTarget.ALL_ENEMY);
        this.isEthereal = true;
        this.tags.add(CustomTags.AfterLife);
        this.magicNumber = this.baseMagicNumber = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
        this.addToBot(new VFXAction(p, new CleaveEffect(), 0.0F));
        if (!AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
            this.flash();

            for(AbstractMonster monster : AbstractDungeon.getMonsters().monsters) {
                if (!monster.isDead && !monster.isDying) {
                    this.addToBot(new ApplyPowerAction(monster, p, new StrengthPower(monster, monster.hasPower("ottoMod:Cancer") && monster.getPower("ottoMod:Cancer").amount >= 15 ? -this.magicNumber - 1 : -this.magicNumber), monster.hasPower("ottoMod:Cancer") && monster.getPower("ottoMod:Cancer").amount >= 15 ? -this.magicNumber - 1 : -this.magicNumber));
                }
            }
        }

    }

    public void triggerOnExhaust() {
        if (!AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
            this.flash();

            for(AbstractMonster monster : AbstractDungeon.getMonsters().monsters) {
                if (!monster.isDead && !monster.isDying) {
                    this.addToBot(new ApplyPowerAction(monster, AbstractDungeon.player, new StrengthPower(monster, monster.hasPower("ottoMod:Cancer") && monster.getPower("ottoMod:Cancer").amount >= 15 ? -this.magicNumber - 1 : -this.magicNumber), monster.hasPower("ottoMod:Cancer") && monster.getPower("ottoMod:Cancer").amount >= 15 ? -this.magicNumber - 1 : -this.magicNumber));
                }
            }
        }

    }

    public AbstractCard makeCopy() {
        return new AriaSulG();
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeMagicNumber(1);
        }

    }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings("AriaSulG");
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
    }
}
