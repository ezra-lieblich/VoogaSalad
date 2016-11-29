package engine.level;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import engine.AbstractTypeBuilder;
import engine.observer.ObservableMap;
import engine.observer.ObservableMapProperty;
import engine.observer.ObservableObjectProperty;
import engine.observer.ObservableProperty;


public class LevelTypeBuilder extends AbstractTypeBuilder<Level, LevelBuilder> implements LevelBuilder, LevelInitializer {

	public static final String DEFAULT_NAME = "Level";
    public static final String DEFAULT_IMAGE_PATH = "Images.blacksquare.jpg";
    public static final double DEFAULT_SIZE = 1;
    public static final Map<Integer, Integer> DEFAULT_ENEMY_COUNTS = new HashMap<Integer, Integer>();
    public static final double DEFAULT_REWARD_HEALTH = 0;
    public static final double DEFAULT_REWARD_MONEY = 200;
    public static final double DEFAULT_REWARD_POINTS = 200;
    public static final double DEFAULT_DURATION_IN_SECONDS = 1;

    //TODO needs to be observable map
    private ObservableMap<Integer, Integer> enemyCounts;
   	private ObservableProperty<Double> rewardHealth;
   	private ObservableProperty<Double> rewardMoney;
   	private ObservableProperty<Double> rewardPoints;
   	private ObservableProperty<Double> durationInSeconds;

	   
	protected LevelTypeBuilder() {
		super(DEFAULT_NAME, DEFAULT_IMAGE_PATH, DEFAULT_SIZE);
	}

	@Override
	public LevelBuilder addEnemyCountsListener(BiConsumer<Map<Integer, Integer>, Map<Integer, Integer>> listener) {
		enemyCounts.addListener(listener);
		return this;
	}

	@Override
	public LevelBuilder addRewardHealthListener(BiConsumer<Double, Double> listener) {
		rewardHealth.addListener(listener);
		return this;
	}

	@Override
	public LevelBuilder addRewardMoneyListener(BiConsumer<Double, Double> listener) {
		rewardMoney.addListener(listener);
		return this;
	}

	@Override
	public LevelBuilder addRewardPointsListener(BiConsumer<Double, Double> listener) {
		rewardPoints.addListener(listener);
		return this;
	}

	@Override
	public LevelBuilder addDurationInSecondsListener(BiConsumer<Double, Double> listener) {
		durationInSeconds.addListener(listener);
		return this;
	}

	@Override
	public ObservableMap<Integer, Integer> getEnemyCounts() {
		return enemyCounts;
	}

	@Override
	public ObservableProperty<Double> getRewardHealth() {
		return rewardHealth;
	}

	@Override
	public ObservableProperty<Double> getRewardMoney() {
		return rewardMoney;
	}

	@Override
	public ObservableProperty<Double> getRewardPoints() {
		return rewardPoints;
	}

	@Override
	public ObservableProperty<Double> getDurationInSeconds() {
		return durationInSeconds;
	}

	@Override
	public LevelBuilder buildEnemyCounts(Map<Integer, Integer> enemies) {
		this.enemyCounts.setProperty(enemies);
		return this;
	}


	@Override
	public LevelBuilder buildRewardHealth(double rewardHealth) {
		this.rewardHealth.setProperty(rewardHealth);
		return this;
	}

	@Override
	public LevelBuilder buildRewardMoney(double rewardMoney) {
		this.rewardMoney.setProperty(rewardMoney);
		return this;
	}

	@Override
	public LevelBuilder buildRewardPoints(double rewardPoints) {
		this.rewardPoints.setProperty(rewardPoints);
		return this;
	}

	@Override
	public LevelBuilder buildDurationInSeconds(double durationInSeconds) {
		this.durationInSeconds.setProperty(durationInSeconds);
		return this;
	}

	@Override
	protected Level create() {
		return new LevelType(this);
	}

	@Override
	protected void restoreTypeDefaults() {
		// TODO enemyCounts
		//this.enemyCounts;
		this.enemyCounts = new ObservableMapProperty<Integer, Integer>(DEFAULT_ENEMY_COUNTS);
		this.rewardHealth = new ObservableObjectProperty<Double>(DEFAULT_REWARD_HEALTH);
		this.rewardMoney = new ObservableObjectProperty<Double>(DEFAULT_REWARD_MONEY);
		this.rewardPoints = new ObservableObjectProperty<Double>(DEFAULT_REWARD_POINTS);
		this.durationInSeconds = new ObservableObjectProperty<Double>(DEFAULT_DURATION_IN_SECONDS);

	}

	@Override
	protected LevelBuilder getThis() {
		return this;
	}


}
