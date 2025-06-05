//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ottoMod.relics;

import com.megacrit.cardcrawl.android.mods.abstracts.CustomRelic;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import ottoMod.OttoMod;

public class GreenTrain extends CustomRelic {
    public static final String ID = OttoMod.makeId("GreenTrain");
    private static final String IMG_PATH = "img/otto_relics/GreenTrain.png";
    private static final String IMG_OTL = "img/otto_relics/outline/GreenTrain.png";

    public GreenTrain() {
        super(OttoMod.MOD_ID, ID, IMG_PATH, RelicTier.BOSS, LandingSound.HEAVY);
    }

    public void onEquip() {
        ++AbstractDungeon.player.energy.energyMaster;
    }

    public void onUnequip() {
        --AbstractDungeon.player.energy.energyMaster;
    }

    public String getUpdatedDescription() {
        return this.DESCRIPTIONS[0];
    }

    public AbstractRelic makeCopy() {
        return new GreenTrain();
    }
}
