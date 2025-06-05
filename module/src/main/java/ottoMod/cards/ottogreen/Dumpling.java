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
import com.megacrit.cardcrawl.powers.RegenPower;
import com.megacrit.cardcrawl.vfx.BorderLongFlashEffect;
import com.megacrit.cardcrawl.vfx.ThoughtBubble;
import com.megacrit.cardcrawl.vfx.combat.EmptyStanceEffect;
import ottoMod.enums.CardColorEnum;
import ottoMod.enums.CustomTags;
import ottoMod.powers.Delicious;

public class Dumpling extends CustomCard {
    public static final String ID = "Dumpling";
    private static final CardStrings cardStrings;
    public static final String NAME;
    public static final String DESCRIPTION;
    public static final String IMG_PATH = "img/otto/Dumpling.png";
    private static final int COST = 1;
    private static final int BASE_Apply = 3;

    public Dumpling() {
        super("Dumpling", NAME, "img/otto/Dumpling.png", 1, DESCRIPTION, CardType.POWER, CardColorEnum.ottogreen, CardRarity.BASIC, CardTarget.SELF);
        this.magicNumber = this.baseMagicNumber = 3;
        this.tags.add(CardTags.HEALING);
        this.tags.add(CustomTags.AfterLife);
        this.isEthereal = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
        this.addToBot(new VFXAction(new BorderLongFlashEffect(Color.GREEN)));
        this.addToBot(new ApplyPowerAction(p, p, new RegenPower(p, this.magicNumber), this.magicNumber));
        this.addToBot(new ApplyPowerAction(p, p, new Delicious(p), 1));
    }

    public void triggerOnExhaust() {
        if (this.upgraded) {
            CardCrawlGame.sound.play("LostDelicious");
            this.addToBot(new VFXAction(new BorderLongFlashEffect(Color.GRAY)));
            AbstractDungeon.effectList.add(new ThoughtBubble(AbstractDungeon.player.dialogX, AbstractDungeon.player.dialogY, 3.0F, "那我缺的这个营养这一块的谁给我补啊", true));
            this.addToBot(new VFXAction(new EmptyStanceEffect(AbstractDungeon.player.hb.cX, AbstractDungeon.player.hb.cY)));
            this.addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new RegenPower(AbstractDungeon.player, 3), 3));
            this.addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player, new Delicious(AbstractDungeon.player), 1));
        }

    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.rawDescription = "获得 " + this.magicNumber + " 再生 。获得 ottomod:营养 。 虚无 。 ottomod:阴世 。 stslib:灵魂绑定 。";
            this.initializeDescription();
        }

    }

    public AbstractCard makeCopy() {
        return new Dumpling();
    }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings("Dumpling");
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
    }
}
