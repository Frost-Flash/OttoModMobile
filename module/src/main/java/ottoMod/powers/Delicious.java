//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ottoMod.powers;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.android.mods.AssetLoader;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.vfx.combat.BiteEffect;
import ottoMod.OttoMod;

public class Delicious extends AbstractPower {
    public static final String POWER_ID = OttoMod.makeId("Delicious");
    private static final PowerStrings powerStrings;
    private static final String NAME;
    private static final String[] DESCRIPTIONS;

    public Delicious(AbstractCreature owner) {
        this.name = NAME;
        this.ID = "OttoMod:Delicious";
        this.owner = owner;
        this.type = PowerType.BUFF;
        this.amount = -1;
        String path128 = "img/UI_Otto/Del128.png";
        String path48 = "img/UI_Otto/Del48.png";
        this.region128 = new TextureAtlas.AtlasRegion(AssetLoader.getTexture(OttoMod.MOD_ID,path128), 22, 22, 84, 84);
        this.region48 = new TextureAtlas.AtlasRegion(AssetLoader.getTexture(OttoMod.MOD_ID,path48), 8, 8, 32, 32);
        this.updateDescription();
    }

    public void stackPower(int stackAmount) {
        this.updateDescription();
    }

    public void onInitialApplication() {
        CardCrawlGame.sound.play("Dumpling");
        this.addToBot(new VFXAction(new BiteEffect(this.owner.hb.cX, this.owner.hb.cY), 0.3F));
        this.addToBot(new AbstractGameAction() {
            public void update() {
                CardCrawlGame.sound.play("Delicious");
                this.isDone = true;
            }
        });
    }

    public void onDeath() {
        CardCrawlGame.sound.play("Teammate");
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0];
    }

    static {
        powerStrings = CardCrawlGame.languagePack.getPowerStrings("OttoMod:Delicious");
        NAME = powerStrings.NAME;
        DESCRIPTIONS = powerStrings.DESCRIPTIONS;
    }
}
