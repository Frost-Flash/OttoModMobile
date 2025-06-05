//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ottoMod.effects;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageRandomEnemyAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.cards.DamageInfo.DamageType;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.vfx.combat.HbBlockBrokenEffect;
import ottoMod.powers.WheelBoostPower;

public class PushWheelEffect {
    private static int triggerCount = 0;
    private static int baseDamage = 2;

    public PushWheelEffect() {
    }

    public static void reset() {
        triggerCount = 0;
        if (AbstractDungeon.player.hasRelic("GreenTrain")) {
            baseDamage = 0;
        } else {
            baseDamage = 2;
        }

    }

    public void trigger(final int times) {
        AbstractDungeon.actionManager.addToBottom(new AbstractGameAction() {
            public void update() {
                for(int i = 0; i < times; ++i) {
                    this.addToBot(PushWheelEffect.this.new SingleHitAction());
                }

                this.isDone = true;
            }
        });
    }

    private class SingleHitAction extends AbstractGameAction {
        private final int storedDamage = this.calculateDamage();
        private boolean targetAcquired = false;

        public SingleHitAction() {
        }

        private int calculateDamage() {
            if (PushWheelEffect.triggerCount++ >= 8) {
                PushWheelEffect.baseDamage++;
                if (AbstractDungeon.player.hasRelic("Rusted_Wheelchair")) {
                    ++AbstractDungeon.player.getRelic("Rusted_Wheelchair").counter;
                    AbstractDungeon.player.getRelic("Rusted_Wheelchair").flash();
                }

                PushWheelEffect.triggerCount = 0;
                AbstractDungeon.effectList.add(new HbBlockBrokenEffect(AbstractDungeon.player.hb.cX, AbstractDungeon.player.hb.cY));
            }

            return PushWheelEffect.baseDamage + (WheelBoostPower.hasBoost() ? WheelBoostPower.getTotalBoost() : 0);
        }

        public void update() {
            if (!this.targetAcquired) {
                this.addToBot(new DamageRandomEnemyAction(new DamageInfo(AbstractDungeon.player, this.storedDamage, DamageType.THORNS), AttackEffect.BLUNT_LIGHT));
                this.targetAcquired = true;
            }

            this.isDone = true;
        }
    }
}
