//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ottoMod.relics;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomRelic;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import ottoMod.OttoMod;
import ottoMod.effects.PushWheelEffect;

public class Rusted_Wheelchair extends CustomRelic {
    public static final String ID = OttoMod.makeId("Rusted_Wheelchair");
    private static final String IMG_PATH = "img/otto_relics/Rusted_Wheelchair.png";
    private static final String IMG_OTL = "img/otto_relics/outline/Rusted_Wheelchair.png";
    private boolean usedThisCombat = false;

    public Rusted_Wheelchair() {
        super(OttoMod.MOD_ID, ID, IMG_PATH, RelicTier.STARTER, LandingSound.HEAVY);
    }

    public void onEquip() {
        this.counter = -1;
    }

    public void atBattleStart() {
        this.counter = 2 + (AbstractDungeon.player.hasRelic("GreenTrain") ? -2 : 0);
        if (this.counter <= 0) {
            this.counter = 0;
        }

        if (!this.usedThisCombat) {
            this.addToBot(new RelicAboveCreatureAction(AbstractDungeon.player, this));

            for(int i = 0; i < 5; ++i) {
                this.flash();
                (new PushWheelEffect()).trigger(1);
            }

            this.usedThisCombat = true;
        }

        this.getUpdatedDescription();
    }

    public void onVictory() {
        this.usedThisCombat = false;
        this.counter = -1;
    }

    public void onEnterRoom(AbstractRoom room) {
        this.usedThisCombat = false;
    }

    public void render(SpriteBatch sb) {
        this.grayscale = this.usedThisCombat;
        super.render(sb);
    }

    public String getUpdatedDescription() {
        return this.usedThisCombat ? this.DESCRIPTIONS[1] : this.DESCRIPTIONS[0];
    }

    public AbstractRelic makeCopy() {
        return new Rusted_Wheelchair();
    }
}
