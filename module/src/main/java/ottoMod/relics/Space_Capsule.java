//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ottoMod.relics;

import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomRelic;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import ottoMod.OttoMod;
import ottoMod.effects.PushWheelEffect;

public class Space_Capsule extends CustomRelic {
    public static final String ID = OttoMod.makeId("Space_Capsule");
    private static final String IMG_PATH = "img/otto_relics/Space_Capsule.png";
    private static final String IMG_OTL = "img/otto_relics/outline/Space_Capsule.png";

    public Space_Capsule() {
        super(OttoMod.MOD_ID, ID, IMG_PATH, RelicTier.BOSS, LandingSound.MAGICAL);
    }

    public boolean canSpawn() {
        return AbstractDungeon.player.hasRelic("Rusted_Wheelchair");
    }

    public void obtain() {
        if (AbstractDungeon.player.hasRelic("Rusted_Wheelchair")) {
            this.instantObtain(AbstractDungeon.player, 0, false);
        } else {
            super.obtain();
        }

    }

    public void atBattleStart() {
        this.counter = 0;
    }

    public void onVictory() {
        this.counter = -1;
    }

    public void atTurnStartPostDraw() {
        this.addToBot(new RelicAboveCreatureAction(AbstractDungeon.player, this));
        this.flash();
        (new PushWheelEffect()).trigger(3);
        ++this.counter;
    }

    public String getUpdatedDescription() {
        return this.DESCRIPTIONS[0];
    }

    public AbstractRelic makeCopy() {
        return new Space_Capsule();
    }
}
