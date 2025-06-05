//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ottoMod.cards.ottogreen;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.android.mods.abstracts.CustomCard;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import ottoMod.enums.CardColorEnum;

public class CalmDetect extends CustomCard {
    public static final String ID = "CalmDetect";
    private static final CardStrings cardStrings;
    public static final String NAME;
    public static final String DESCRIPTION;
    public static final String UPGRADE_DESCRIPTION;
    public static final String IMG_PATH = "img/otto/CalmDetect.png";
    private static final int COST = 1;

    public CalmDetect() {
        super("CalmDetect", NAME, "img/otto/CalmDetect.png", 1, DESCRIPTION, CardType.SKILL, CardColorEnum.ottogreen, CardRarity.UNCOMMON, CardTarget.SELF);
        this.magicNumber = this.baseMagicNumber = 3;
        this.block = this.baseBlock = 5;
    }

    public void use(final AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new AbstractGameAction() {
            public void update() {
                if (p.hasPower("ottoMod:Fury")) {
                    switch (p.getPower("ottoMod:Fury").amount) {
                        case 0:
                            break;
                        case 1:
                            this.addToBot(new ReducePowerAction(p, p, "ottoMod:Fury", 1));
                            this.addToBot(new GainBlockAction(p, p, CalmDetect.this.block));
                            break;
                        case 2:
                            for(int i = 0; i < 2; ++i) {
                                this.addToBot(new ReducePowerAction(p, p, "ottoMod:Fury", 1));
                                this.addToBot(new GainBlockAction(p, p, CalmDetect.this.block));
                            }
                            break;
                        case 3:
                            for(int i = 0; i < 3; ++i) {
                                this.addToBot(new ReducePowerAction(p, p, "ottoMod:Fury", 1));
                                this.addToBot(new GainBlockAction(p, p, CalmDetect.this.block));
                            }
                            break;
                        default:
                            for(int i = 0; i < CalmDetect.this.magicNumber; ++i) {
                                this.addToBot(new ReducePowerAction(p, p, "ottoMod:Fury", 1));
                                this.addToBot(new GainBlockAction(p, p, CalmDetect.this.block));
                            }
                    }
                }

                this.isDone = true;
            }
        });
    }

    public AbstractCard makeCopy() {
        return new CalmDetect();
    }

    public void upgrade() {
        if (!this.upgraded) {
            this.upgradeName();
            this.upgradeMagicNumber(1);
        }

    }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings("CalmDetect");
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
        UPGRADE_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
    }
}
