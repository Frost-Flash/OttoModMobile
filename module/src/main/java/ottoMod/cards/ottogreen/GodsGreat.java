//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ottoMod.cards.ottogreen;

import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.utility.ShakeScreenAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo.DamageType;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ScreenShake.ShakeDur;
import com.megacrit.cardcrawl.helpers.ScreenShake.ShakeIntensity;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.BorderLongFlashEffect;
import com.megacrit.cardcrawl.vfx.ThoughtBubble;
import com.megacrit.cardcrawl.vfx.combat.GrandFinalEffect;
import ottoMod.enums.CardColorEnum;

public class GodsGreat extends CustomCard {
    public static final String ID = "GodsGreat";
    private static final CardStrings cardStrings;
    public static final String NAME;
    public static final String DESCRIPTION;
    public static final String UPGRADE_DESCRIPTION;
    public static final String IMG_PATH = "img/otto/GodsGreat.png";
    private static final int COST = 3;

    public GodsGreat() {
        super("GodsGreat", NAME, "img/otto/GodsGreat.png", 3, DESCRIPTION, CardType.ATTACK, CardColorEnum.ottogreen, CardRarity.SPECIAL, CardTarget.ALL_ENEMY);
        this.baseDamage = 50;
        this.isMultiDamage = true;
        this.selfRetain = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
             CardCrawlGame.sound.play(ID);
        this.addToBot(new VFXAction(new BorderLongFlashEffect(Color.GOLD)));
        AbstractDungeon.effectList.add(new ThoughtBubble(AbstractDungeon.player.dialogX, AbstractDungeon.player.dialogY, 3.0F, "汝等...不可存疑...汝等...此乃神之伟业汝等...不得冒犯...求您将我等佑护...", true));
        this.addToBot(new AbstractGameAction() {
            public void update() {
                CardCrawlGame.sound.play("GodsGreat");
                this.isDone = true;
            }
        });
        this.addToBot(new VFXAction(new GrandFinalEffect(), 2.0F));
        this.addToBot(new ShakeScreenAction(0.1F, ShakeDur.LONG, ShakeIntensity.HIGH));
        this.addToBot(new DamageAllEnemiesAction(p, this.multiDamage, DamageType.NORMAL, AttackEffect.SMASH));
    }

    public AbstractCard makeCopy() {
        return new GodsGreat();
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeDamage(8);
        }

    }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings("GodsGreat");
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
        UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
    }
}
