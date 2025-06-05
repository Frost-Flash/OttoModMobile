//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ottoMod.cards.ottogreen;

import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.utility.SFXAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.combat.InflameEffect;
import ottoMod.enums.CardColorEnum;
import ottoMod.enums.CustomTags;
import ottoMod.powers.WheelBoostPower;

public class ProfessionForm extends CustomCard {
    public static final String ID = "ProfessionForm";
    private static final CardStrings cardStrings;
    public static final String NAME;
    public static final String DESCRIPTION;
    public static final String UPGRADE_DESCRIPTION;
    public static final String IMG_PATH = "img/otto/ProfessionForm.png";
    private static final int COST = 3;

    public ProfessionForm() {
        super("ProfessionForm", NAME, "img/otto/ProfessionForm.png", 3, DESCRIPTION, CardType.POWER, CardColorEnum.ottogreen, CardRarity.RARE, CardTarget.SELF);
        this.isEthereal = true;
        this.tags.add(CustomTags.FORM);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
        this.addToBot(new SFXAction("ATTACK_FLAME_BARRIER"));
        this.addToBot(new VFXAction(new InflameEffect(p), 0.5F));
        this.addToBot(new ApplyPowerAction(p, p, new ottoMod.powers.ProfessionForm(p, 1), 1));
        this.addToBot(new ApplyPowerAction(p, p, new WheelBoostPower(p, 1), 1));
    }

    public void triggerOnExhaust() {
        if (this.upgraded && AbstractDungeon.player.hasPower("ottoMod:Delicious")) {
            this.addToBot(new SFXAction("ATTACK_FLAME_BARRIER"));
            this.addToBot(new VFXAction(new InflameEffect(AbstractDungeon.player), 0.5F));
            this.addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new ottoMod.powers.ProfessionForm(AbstractDungeon.player, 1), 1));
            this.addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new WheelBoostPower(AbstractDungeon.player, 1), 1));
        }

    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.rawDescription = this.upgraded ? UPGRADE_DESCRIPTION : DESCRIPTION;
            this.tags.add(CustomTags.AfterLife);
            this.initializeDescription();
        }

    }

    public AbstractCard makeCopy() {
        return new ProfessionForm();
    }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings("ProfessionForm");
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
        UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
    }
}
