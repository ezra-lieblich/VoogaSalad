package engine.level;


import java.util.Collections;
import java.util.Map;

import engine.AbstractType;
import engine.TypeInitializer;


public class LevelType extends AbstractType implements Level {
	//TODO Make enemyCounts ObservableMap change to doubles
    private Map<Integer, Integer> enemyCounts;
	private double rewardHealth;
	private double rewardMoney;
	private double rewardPoints;
	private double durationInSeconds;


    protected LevelType (TypeInitializer typeBuilder) {
    	super(typeBuilder);	
	}
    


	@Override
	public Map<Integer, Integer> getEnemyCounts() {
		return Collections.unmodifiableMap(enemyCounts);
	}

	@Override
	public void setEnemyCounts(int enemy, int enemyCount) {
		enemyCounts.put(enemy, enemyCount);
	}

	@Override
	public double getRewardHealth() {
		return rewardHealth;
	}

	@Override
	public void setRewardHealth(int rewardHealth) {
		this.rewardHealth = rewardHealth;
	}

	@Override
	public double getRewardMoney() {
		return rewardMoney;
	}

	@Override
	public void setRewardMoney(int rewardMoney) {
		this.rewardMoney = rewardMoney;
	}

	@Override
	public double getRewardPoints() {
		return rewardPoints;
	}

	@Override
	public void setRewardPoints(int rewardPoints) {
		this.rewardPoints = rewardPoints;
	}

	@Override
	public double getDurationInSeconds() {
		return durationInSeconds;
	}

	@Override
	public void setDurationInSeconds(double durationInSeconds) {
		this.durationInSeconds = durationInSeconds;
	}

}
