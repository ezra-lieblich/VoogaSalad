package engine.level;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import engine.AbstractTypeBuilder;
import engine.level.wave.Wave;
import engine.level.wave.WaveType;
import engine.observer.ObservableMap;
import engine.observer.ObservableMapProperty;
import engine.observer.ObservableObjectProperty;
import engine.observer.ObservableProperty;


public class LevelTypeBuilder extends AbstractTypeBuilder<Level, LevelBuilder>
        implements LevelBuilder, LevelInitializer {

	public static final String DEFAULT_NAME = "Level";
    public static final String DEFAULT_IMAGE_PATH = "Images/blacksquarejpg";
    public static final double DEFAULT_SIZE = 1;
    public static final Map<Integer, Wave> DEFAULT_ENEMY_COUNTS = new HashMap<Integer, Wave>();
    public static final double DEFAULT_REWARD_HEALTH = 0;
    public static final double DEFAULT_REWARD_MONEY = 200;
    public static final double DEFAULT_REWARD_SCORE = 200;
    public static final double DEFAULT_DURATION_IN_SECONDS = 1;
    public static final double DEFAULT_LEVEL_TIME = 0;

    private ObservableMap<Integer, Wave> enemyCounts;
    private ObservableProperty<Double> rewardHealth;
    private ObservableProperty<Double> rewardMoney;
    private ObservableProperty<Double> rewardScore;
    private ObservableProperty<Double> durationInSeconds;
    private ObservableProperty<Double> time;

    protected LevelTypeBuilder () {
        super(DEFAULT_NAME, DEFAULT_IMAGE_PATH, DEFAULT_SIZE);
    }

    @Override
    public LevelBuilder addWaveListener (BiConsumer<Map<Integer, Wave>, Map<Integer, Wave>> listener) {
        enemyCounts.addListener(listener);
        return this;
    }

    @Override
    public LevelBuilder addRewardHealthListener (BiConsumer<Double, Double> listener) {
        rewardHealth.addListener(listener);
        return this;
    }

    @Override
    public LevelBuilder addRewardMoneyListener (BiConsumer<Double, Double> listener) {
        rewardMoney.addListener(listener);
        return this;
    }

    @Override
    public LevelBuilder addRewardScoreListener (BiConsumer<Double, Double> listener) {
        rewardScore.addListener(listener);
        return this;
    }

    @Override
    public LevelBuilder addDurationInSecondsListener (BiConsumer<Double, Double> listener) {
        durationInSeconds.addListener(listener);
        return this;
    }

    @Override
    public ObservableMap<Integer, Wave> getWaves () {
        return enemyCounts;
    }

    @Override
    public ObservableProperty<Double> getRewardHealth () {
        return rewardHealth;
    }

    @Override
    public ObservableProperty<Double> getRewardMoney () {
        return rewardMoney;
    }

    @Override
    public ObservableProperty<Double> getRewardScore () {
        return rewardScore;
    }

    @Override
    public ObservableProperty<Double> getDurationInSeconds () {
        return durationInSeconds;
    }

    @Override
    public LevelBuilder buildWaves (Map<Integer, Wave> enemies) {
        this.enemyCounts.setProperty(enemies);
        return this;
    }

    @Override
    public LevelBuilder buildRewardHealth (double rewardHealth) {
        this.rewardHealth.setProperty(rewardHealth);
        return this;
    }

    @Override
    public LevelBuilder buildRewardMoney (double rewardMoney) {
        this.rewardMoney.setProperty(rewardMoney);
        return this;
    }

    @Override
    public LevelBuilder buildRewardScore (double rewardPoints) {
        this.rewardScore.setProperty(rewardPoints);
        return this;
    }

    @Override
    public LevelBuilder buildDurationInSeconds (double durationInSeconds) {
        this.durationInSeconds.setProperty(durationInSeconds);
        return this;
    }

    @Override
    protected Level create () {
        return new LevelType(this);
    }

    @Override
    protected void restoreTypeDefaults () {
        this.enemyCounts = new ObservableMapProperty<Integer, Wave>(DEFAULT_ENEMY_COUNTS);
        this.rewardHealth = new ObservableObjectProperty<Double>(DEFAULT_REWARD_HEALTH);
        this.rewardMoney = new ObservableObjectProperty<Double>(DEFAULT_REWARD_MONEY);
        this.rewardScore = new ObservableObjectProperty<Double>(DEFAULT_REWARD_SCORE);
        this.durationInSeconds = new ObservableObjectProperty<Double>(DEFAULT_DURATION_IN_SECONDS);
        this.time = new ObservableObjectProperty<Double>(DEFAULT_LEVEL_TIME);

    }

    @Override
    protected LevelBuilder getThis () {
        return this;
    }

	@Override
	public LevelBuilder addLevelTimeListener(BiConsumer<Double, Double> listener) {
		this.time.addListener(listener);
		return this;
	}

	@Override
	public ObservableProperty<Double> getLevelTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LevelBuilder buildLevelTime(double time) {
		// TODO Auto-generated method stub
		return null;
	}

}
