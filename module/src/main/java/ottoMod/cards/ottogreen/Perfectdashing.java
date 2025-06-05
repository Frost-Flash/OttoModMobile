//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ottoMod.cards.ottogreen;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.cards.DamageInfo.DamageType;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import ottoMod.enums.CardColorEnum;
import ottoMod.enums.CustomTags;

public class Perfectdashing extends CustomCard {
    public static final String ID = "Perfectdashing";
    private static final CardStrings cardStrings;
    public static final String NAME;
    private static final String DESCRIPTION;
    public static final String IMG_PATH = "img/otto/Perfectdashing.png";
    private static final int COST = 1;
    private static final int DAMAGE_AMT = 7;

    public Perfectdashing() {
        super("Perfectdashing", NAME, "img/otto/Perfectdashing.png", 1, DESCRIPTION, CardType.ATTACK, CardColorEnum.ottogreen, CardRarity.RARE, CardTarget.ENEMY);
        this.baseDamage = 7;
        this.tags.add(CustomTags.DASHING);
    }

    public void use(final AbstractPlayer p, final AbstractMonster m) {
        CardCrawlGame.sound.play("Dashing");
        this.addToBot(new AbstractGameAction() {
            public void update() {
                this.isDone = true;
                if (m != null && m.currentHealth > 0) {
                    int count = 0;

                    for(AbstractCard c : AbstractDungeon.actionManager.cardsPlayedThisCombat) {
                        if (c.hasTag(CustomTags.DASHING)) {
                            ++count;
                        }
                    }

                    --count;

                    for(int i = 0; i < count; ++i) {
                        this.addToTop(new DamageAction(m, new DamageInfo(p, Perfectdashing.this.damage, DamageType.NORMAL), AttackEffect.SLASH_VERTICAL));
                    }
                }

            }
        });
    }

    public AbstractCard makeCopy() {
        return new Perfectdashing();
    }

    public void onMoveToDiscard() {
        this.rawDescription = cardStrings.DESCRIPTION;
        this.initializeDescription();
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeDamage(2);
        }

    }

    public void applyPowers() {
        int count = 0;

        for(AbstractCard c : AbstractDungeon.actionManager.cardsPlayedThisCombat) {
            if (c.hasTag(CustomTags.DASHING)) {
                ++count;
            }
        }

        this.rawDescription = cardStrings.DESCRIPTION + " NL （已打出 " + count + " 张冲刺牌）";
        this.initializeDescription();
    }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings("Perfectdashing");
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
    }
}
