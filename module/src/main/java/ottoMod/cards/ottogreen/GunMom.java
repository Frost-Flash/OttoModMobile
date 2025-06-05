//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ottoMod.cards.ottogreen;

import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.BorderLongFlashEffect;
import ottoMod.enums.CardColorEnum;
import ottoMod.enums.CustomTags;
import ottoMod.powers.Fury;

public class GunMom extends CustomCard {
    public static final String ID = "GunMom";
    private static final CardStrings cardStrings;
    public static final String NAME;
    public static final String DESCRIPTION;
    public static final String UPGRADE_DESCRIPTION;
    public static final String IMG_PATH = "img/otto/GunMom.png";

    public GunMom() {
        super("GunMom", NAME, "img/otto/GunMom.png", -2, DESCRIPTION, CardType.CURSE, CardColorEnum.ottogreen, CardRarity.CURSE, CardTarget.NONE);
        this.isEthereal = true;
        this.tags.add(CustomTags.AfterLife);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
    }

    public AbstractCard makeCopy() {
        return new GunMom();
    }

    public void triggerOnExhaust() {
        this.addToBot(new VFXAction(new BorderLongFlashEffect(Color.BLACK)));
        this.addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new Fury(AbstractDungeon.player, 1), 1));
    }

    public void upgrade() {
    }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings("GunMom");
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
        UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
    }
}
