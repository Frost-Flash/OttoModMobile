//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ottoMod.powers;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.android.mods.AssetLoader;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.cards.DamageInfo.DamageType;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.WeakPower;
import ottoMod.OttoMod;

public class Cancer extends AbstractPower {
    public static final String POWER_ID = OttoMod.makeId("Cancer");
    private static final PowerStrings powerStrings;
    private static final String NAME;
    private static final String[] DESCRIPTIONS;

    public Cancer(AbstractCreature owner, int Amount) {
        this.name = NAME;
        this.ID = "OttoMod:Cancer";
        this.owner = owner;
        this.type = PowerType.DEBUFF;
        this.amount = Amount;
        String path128 = "img/UI_Otto/Cancer128.png";
        String path48 = "img/UI_Otto/Cancer48.png";
        this.region128 = new TextureAtlas.AtlasRegion(AssetLoader.getTexture(OttoMod.MOD_ID,path128), 22, 22, 84, 84);
        this.region48 = new TextureAtlas.AtlasRegion(AssetLoader.getTexture(OttoMod.MOD_ID,path48), 8, 8, 32, 32);
        this.updateDescription();
    }

    public void atStartOfTurn() {
        this.flash();
        this.addToBot(new DamageAction(this.owner, new DamageInfo(this.owner, this.amount, DamageType.HP_LOSS), AttackEffect.FIRE));
        this.addToBot(new ApplyPowerAction(this.owner, this.owner, new Cancer(this.owner, 1), 1));
        if (this.amount >= 15) {
            int weakAmount = 1;
            CardCrawlGame.sound.play("Cancer");
            this.addToBot(new ApplyPowerAction(this.owner, AbstractDungeon.player, new WeakPower(this.owner, weakAmount, false), weakAmount));
        }

    }

    public void stackPower(int stackAmount) {
        super.stackPower(stackAmount);
        this.updateDescription();
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1];
    }

    static {
        powerStrings = CardCrawlGame.languagePack.getPowerStrings("OttoMod:Cancer");
        NAME = powerStrings.NAME;
        DESCRIPTIONS = powerStrings.DESCRIPTIONS;
    }
}
