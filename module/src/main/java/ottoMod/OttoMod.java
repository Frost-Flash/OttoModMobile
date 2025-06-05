package ottoMod;

import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.android.mods.BaseMod;
import com.megacrit.cardcrawl.android.mods.helpers.CardColorBundle;
import com.megacrit.cardcrawl.android.mods.interfaces.*;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.localization.CharacterStrings;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.localization.RelicStrings;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import com.megacrit.cardcrawl.unlock.UnlockTracker;
import ottoMod.cards.ottogreen.*;
import ottoMod.character.Mycharacter;
import ottoMod.effects.PushWheelEffect;
import ottoMod.enums.CardColorEnum;
import ottoMod.enums.LibraryTypeEnum;
import ottoMod.relics.*;

public class OttoMod implements EditCardsSubscriber,
                                       PostInitializeSubscriber,
                                       EditStringsSubscriber,
                                       EditRelicsSubscriber,
                                       AddAudioSubscriber,
                                       PostBattleSubscriber,
                                       EditKeywordsSubscriber,EditCharactersSubscriber {
    public static final String MOD_ID = "OttoMod";
    public static final Color YELLOW_COLOR = new Color(0.98F, 0.95F, 0.05F, 1.0F);
    private static final String MY_CHARACTER_BUTTON = getResourcePath("char/Character_Button_Otto.png");
    // 人物选择界面的立绘
    private static final String MY_CHARACTER_PORTRAIT = getResourcePath("char/Character_Portrait1.png");
    public static void initialize() {
        new OttoMod();
    }


    public OttoMod() {
        BaseMod.subscribe(this);
        CardColorBundle bundle = new CardColorBundle();
        bundle.cardColor = CardColorEnum.ottogreen;
        bundle.modId = MOD_ID;
        bundle.bgColor =
            bundle.cardBackColor =
            bundle.frameColor =
            bundle.frameOutlineColor =
            bundle.descBoxColor =
            bundle.trailVfxColor =
            bundle.glowColor = YELLOW_COLOR;
        bundle.libraryType = LibraryTypeEnum.ottogreen;
        bundle.attackBg = getResourcePath("512/bg_attack_512.png");
        bundle.skillBg = getResourcePath("512/bg_skill_512.png");
        bundle.powerBg = getResourcePath("512/bg_power_512.png");
        bundle.cardEnergyOrb = getResourcePath("512/cost_orb.png");
        bundle.energyOrb = getResourcePath("512/small_orb.png");
        bundle.attackBgPortrait = getResourcePath("1024/bg_attack.png");
        bundle.skillBgPortrait = getResourcePath("1024/bg_skill.png");
        bundle.powerBgPortrait = getResourcePath("1024/bg_power.png");
        bundle.energyOrbPortrait = getResourcePath("1024/card_orb.png");
        bundle.setEnergyPortraitWidth(164);
        bundle.setEnergyPortraitHeight(164);
        BaseMod.addColor(bundle);
    }

    public static String makeId(String name) {
        return MOD_ID + ":" + name;
    }

    public static String getResourcePath(String path) {
        return "TestImages/" + path;
    }

    @Override
    public void receiveEditCards() {
        BaseMod.addCard(new Allfordashing());
        BaseMod.addCard(new AriaSulG());
        BaseMod.addCard(new AttackOnMonkey());
        BaseMod.addCard(new BigFruit());
        BaseMod.addCard(new BigStone());
        BaseMod.addCard(new BreakDefense());
        BaseMod.addCard(new CallColorByte());
        BaseMod.addCard(new CalmDetect());
        BaseMod.addCard(new Cancerdashing());
        BaseMod.addCard(new Dashing());
        BaseMod.addCard(new DeathClaim());
        BaseMod.addCard(new Defend_Otto());
        BaseMod.addCard(new DeliveryMan());
        BaseMod.addCard(new Diagnosed());
        BaseMod.addCard(new DoubleLabel());
        BaseMod.addCard(new DownPut());
        BaseMod.addCard(new Dumpling());
        BaseMod.addCard(new FatalAttack());
        BaseMod.addCard(new FeelGrievance());
        BaseMod.addCard(new ForcedSmile());
        BaseMod.addCard(new FourWord());
        BaseMod.addCard(new FullFull());
        BaseMod.addCard(new GodFather());
        BaseMod.addCard(new GodsCovenant());
        BaseMod.addCard(new GodsGreat());
        BaseMod.addCard(new GodsRevival());
        BaseMod.addCard(new GodsSigh());
        BaseMod.addCard(new GunMom());
        BaseMod.addCard(new Hamood());
        BaseMod.addCard(new HeadMarkG());
        BaseMod.addCard(new HelloEverybody());
        BaseMod.addCard(new HugWarm());
        BaseMod.addCard(new HurryRoadBigStorm());
        BaseMod.addCard(new Ice_is_Sword());
        BaseMod.addCard(new InfiniteDashing());
        BaseMod.addCard(new JohnnyWalker());
        BaseMod.addCard(new JustHitPig());
        BaseMod.addCard(new KingsWrath());
        BaseMod.addCard(new Kon());
        BaseMod.addCard(new LightSpeed_dashing());
        BaseMod.addCard(new LogicRing());
        BaseMod.addCard(new LoseHomeDog());
        BaseMod.addCard(new MaliciousAttack());
        BaseMod.addCard(new MiddleTower());
        BaseMod.addCard(new MothersDay());
        BaseMod.addCard(new NamedOtto());
        BaseMod.addCard(new NotAngry());
        BaseMod.addCard(new Obedient());
        BaseMod.addCard(new Octane());
        BaseMod.addCard(new Offensibility());
        BaseMod.addCard(new OnDeathBed());
        BaseMod.addCard(new OneWheel());
        BaseMod.addCard(new OpenBig());
        BaseMod.addCard(new OttoKing());
        BaseMod.addCard(new Perfectdashing());
        BaseMod.addCard(new PoorLift());
        BaseMod.addCard(new ProfessionForm());
        BaseMod.addCard(new Refining());
        BaseMod.addCard(new ReGramPro());
        BaseMod.addCard(new Retired());
        BaseMod.addCard(new RobLogic());
        BaseMod.addCard(new SearingDashing());
        BaseMod.addCard(new SexMissOtto());
        BaseMod.addCard(new SilverDog());
        BaseMod.addCard(new SleepMan());
        BaseMod.addCard(new StableGun());
        BaseMod.addCard(new Strike_Otto());
        BaseMod.addCard(new TexasNight());
        BaseMod.addCard(new ThousandsOfWhy());
        BaseMod.addCard(new TripleWolf());
        BaseMod.addCard(new TryMakeMeAngry());
        BaseMod.addCard(new Wheelchair_dashing());
        BaseMod.addCard(new WheelchairReflection());
        BaseMod.addCard(new Wheelround());
        BaseMod.addCard(new WorldNo1());
        BaseMod.addCard(new Wow());
        BaseMod.addCard(new Zouwei());
    }

    @Override
    public void receivePostInitialize() {
        BaseMod.getColorBundleMap().get(CardColorEnum.ottogreen).loadRegion();
        UnlockTracker.unlockCard(Strike_Otto.ID);
    }

    public void receivePostBattle(AbstractRoom abstractRoom) {
            PushWheelEffect.reset();
    }

    @Override
    public void receiveEditStrings() {
        String language;
        switch (Settings.language) {
            case ZHS:
                language = "zhs";
                break;
            default:
                language = "eng";
        }
        BaseMod.loadCustomStringsFile(MOD_ID, CardStrings.class, "localization/" + language + "/ottoModCards.json");
        BaseMod.loadCustomStringsFile(MOD_ID, RelicStrings.class, "localization/" + language + "/ottoModRelics.json");
        BaseMod.loadCustomStringsFile(MOD_ID, CharacterStrings.class, "localization/" + language + "/ottoModCharacter.json");
        BaseMod.loadCustomStringsFile(MOD_ID, PowerStrings.class, "localization/" + language + "/ottoModPowers.json");

    }

    @Override
    public void receiveEditRelics() {
        BaseMod.addRelicToCustomPool(new GreenTrain(), CardColorEnum.ottogreen);
        BaseMod.addRelicToCustomPool(new Rusted_Wheelchair(), CardColorEnum.ottogreen);
        BaseMod.addRelicToCustomPool(new SecondDumpling(), CardColorEnum.ottogreen);
        BaseMod.addRelicToCustomPool(new Space_Capsule(), CardColorEnum.ottogreen);
        BaseMod.addRelicToCustomPool(new suona(), CardColorEnum.ottogreen);
    }

    @Override
    public void receiveEditKeywords() {
        BaseMod.addKeyword( null, new String[]{"推轮"}, "随机造成2点伤害，战斗内每触发8次伤害增加1。");
        BaseMod.addKeyword(null, new String[]{"冲刺"}, " #y冲刺 是一类具有强力效果的卡牌。");
        BaseMod.addKeyword(null, new String[]{"癌症"}, "在回合开始时失去等量生命，随后将 #y癌症 层数加1。 NL 超过15层时，每回合获得1层 #y虚弱 。");
        BaseMod.addKeyword( null, new String[]{"营养"}, "在此状态下，部分卡牌打出时将获得特殊效果。");
        BaseMod.addKeyword( null, new String[]{"怒气"}, "你打出的攻击牌将消耗1层 #y怒气 ，额外造成 #y怒气 层数的伤害。回合开始时每拥有1层，你受到1点伤害。");
        BaseMod.addKeyword( null, new String[]{"疾冲"}, "每层 #y疾冲 使得你 #y推轮 的伤害增加1点。");
        BaseMod.addKeyword( null, new String[]{"职业形态"}, "在你的回合开始时获得 #y疾冲 。");
        BaseMod.addKeyword( null, new String[]{"白银低分狗"}, "每层该能力使你在给予 #y癌症 时，施加1层 #y虚弱 。");
        BaseMod.addKeyword( null, new String[]{"阴世"}, "此牌被 #y消耗 时，仍触发其效果。");
        BaseMod.addKeyword( null, new String[]{"晚期"}, "敌人的 #y癌症 层数大于等于15时，即被视作晚期。");
        BaseMod.addKeyword( null, new String[]{"切换"}, "这张牌默认带有 #y即逝 。 NL 打出后，变化成另一张牌加入牌组。（战斗中临时打出时除外）");
        BaseMod.addKeyword( null, new String[]{"特殊效果"}, "攻击： #y推轮 1次。 NL 技能：抽1张牌。 NL 能力：获得3点 #y临时生命 。 NL 状态：下回合抽1张牌。 NL 诅咒：获得1点 #y怒气 。");
    }

    @Override
    public void receiveEditCharacters() {
        BaseMod.addCharacter(new Mycharacter(CardCrawlGame.playerName), MY_CHARACTER_BUTTON, MY_CHARACTER_PORTRAIT, CardColorEnum.otto);

    }

    @Override
    public void receiveAddAudio() {
        BaseMod.addAudio("Allfordashing", "audio/Allfordashing.mp3");
        BaseMod.addAudio("AriaSulG", "audio/AriaSulG.mp3");
        BaseMod.addAudio("AttackOnMonkey", "audio/AttackOnMonkey.mp3");
        BaseMod.addAudio("BreakDefense", "audio/BreakDefense.mp3");
        BaseMod.addAudio("CallColorByte", "audio/CallColorByte.mp3");
        BaseMod.addAudio(Cancerdashing.ID, "audio/Cancerdashing.mp3");
        BaseMod.addAudio(Dashing.ID, "audio/Dashing.mp3");
        BaseMod.addAudio(DeathClaim.ID, "audio/DeathClaim.mp3");
        BaseMod.addAudio(DownPut.ID, "audio/DownPut.mp3");
        BaseMod.addAudio(Dumpling.ID, "audio/Dumpling.mp3");
        BaseMod.addAudio(FeelGrievance.ID, "audio/FeelGrievance.mp3");
        BaseMod.addAudio(ForcedSmile.ID, "audio/ForcedSmile.mp3");
        BaseMod.addAudio(GodsGreat.ID, "audio/GodsGreat.mp3");
        BaseMod.addAudio(Hamood.ID, "audio/Hamood.mp3");
        BaseMod.addAudio(HelloEverybody.ID, "audio/HelloEverybody.mp3");
        BaseMod.addAudio(HugWarm.ID, "audio/HugWarm.mp3");
        BaseMod.addAudio(HurryRoadBigStorm.ID, "audio/HurryRoadBigStorm.mp3");
        BaseMod.addAudio(Ice_is_Sword.ID, "audio/Ice_is_Sword.mp3");
        BaseMod.addAudio(InfiniteDashing.ID, "audio/InfiniteDashing.mp3");
        BaseMod.addAudio(JustHitPig.ID, "audio/JustHitPig.mp3");
        BaseMod.addAudio(KingsWrath.ID, "audio/KingsWrath.mp3");
        BaseMod.addAudio(Kon.ID, "audio/Kon.mp3");
        BaseMod.addAudio(LightSpeed_dashing.ID, "audio/LightSpeed_dashing.mp3");
        BaseMod.addAudio(LogicRing.ID, "audio/LogicRing.mp3");
        BaseMod.addAudio("LoseHomeDog", "audio/LoseHomeDog.mp3");
        BaseMod.addAudio(NamedOtto.ID, "audio/NamedOtto.mp3");
        BaseMod.addAudio(NotAngry.ID, "audio/NotAngry.mp3");
        BaseMod.addAudio(Offensibility.ID, "audio/Offensibility.mp3");
        BaseMod.addAudio(OnDeathBed.ID, "audio/OnDeathBed.mp3");
        BaseMod.addAudio(Perfectdashing.ID, "audio/Perfectdashing.mp3");
        BaseMod.addAudio(Retired.ID, "audio/Retired.mp3");
        BaseMod.addAudio(RobLogic.ID, "audio/RobLogic.mp3");
        BaseMod.addAudio(SearingDashing.ID, "audio/SearingDashing.mp3");
        BaseMod.addAudio(SexMissOtto.ID, "audio/SexMissOtto.mp3");
        BaseMod.addAudio(Wheelchair_dashing.ID, "audio/Wheelchair_dashing.mp3");
        BaseMod.addAudio(Wow.ID, "audio/Wow.mp3");
        BaseMod.addAudio(Zouwei.ID, "audio/Zouwei1.mp3");
    }
}
