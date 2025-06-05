//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ottoMod.powers;

import com.megacrit.cardcrawl.actions.common.ApplyPowerToRandomEnemyAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import ottoMod.OttoMod;

public class GunFather extends AbstractPower {
    public static final String POWER_ID = OttoMod.makeId("GunFather");
    private static final PowerStrings powerStrings;
    private static final String NAME;
    private static final String[] DESCRIPTIONS;

    public GunFather(AbstractCreature owner, int amount) {
        this.name = NAME;
        this.ID = "OttoMod:GunFather";
        this.owner = owner;
        this.type = PowerType.BUFF;
        this.amount = amount;
        this.loadRegion("corruption");
        this.updateDescription();
    }

    public void onPlayCard(AbstractCard card, AbstractMonster m) {
        if (card.isEthereal) {
            this.addToBot(new ApplyPowerToRandomEnemyAction(AbstractDungeon.player, new Cancer(AbstractDungeon.player, this.amount), this.amount));
            this.addToBot(new GainBlockAction(AbstractDungeon.player, AbstractDungeon.player, this.amount));
        }

    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
    }

    public void stackPower(int stackAmount) {
        super.stackPower(stackAmount);
        this.updateDescription();
    }

    public void onInitialApplication() {
        CardCrawlGame.sound.play("GodFather");
    }

    static {
        powerStrings = CardCrawlGame.languagePack.getPowerStrings("OttoMod:GunFather");
        NAME = powerStrings.NAME;
        DESCRIPTIONS = powerStrings.DESCRIPTIONS;
    }
}
