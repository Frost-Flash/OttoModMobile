//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ottoMod.relics;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomRelic;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import ottoMod.OttoMod;

public class suona extends CustomRelic {
    public static final String ID = OttoMod.makeId("suona");
    private static final String IMG_PATH = "img/otto_relics/suona.png";
    private static final String IMG_OTL = "img/otto_relics/outline/suona.png";

    public suona() {
        super(OttoMod.MOD_ID, ID, IMG_PATH, RelicTier.COMMON, LandingSound.CLINK);
    }

    public void onEquip() {
        this.counter = 1;
    }

    public void onMonsterDeath(AbstractMonster m) {
        if ((m.isDying || m.currentHealth <= 0) && !m.isEscaping && !m.halfDead && !m.hasPower("Minion")) {
            if (this.counter < 30) {
                ++this.counter;
            }

            this.flash();
            AbstractDungeon.actionManager.addToBottom(new RelicAboveCreatureAction(AbstractDungeon.player, this));
            AbstractDungeon.actionManager.addToBottom(new GainBlockAction(AbstractDungeon.player, AbstractDungeon.player, this.counter));
        } else {
            this.flash();
        }

    }

    public String getUpdatedDescription() {
        return this.DESCRIPTIONS[0];
    }

    public AbstractRelic makeCopy() {
        return new suona();
    }
}
