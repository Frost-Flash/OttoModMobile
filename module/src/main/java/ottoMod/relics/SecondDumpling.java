//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ottoMod.relics;

import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomRelic;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.EnergizedPower;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import ottoMod.OttoMod;

public class SecondDumpling extends CustomRelic {
    public static final String ID = OttoMod.makeId("SecondDumpling");
    private static final String IMG_PATH = "img/otto_relics/SecondDumpling.png";
    private static final String IMG_OTL = "img/otto_relics/outline/SecondDumpling.png";

    public SecondDumpling() {
        super(OttoMod.MOD_ID, ID, IMG_PATH, RelicTier.UNCOMMON, LandingSound.SOLID);
    }

    public void atBattleStart() {
        this.addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new EnergizedPower(AbstractDungeon.player, 1), 1));
    }

    public AbstractRelic makeCopy() {
        return new SecondDumpling();
    }

    public String getUpdatedDescription() {
        return this.DESCRIPTIONS[0];
    }
}
