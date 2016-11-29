package engine.level;


import java.util.Collections;
import java.util.Map;

import engine.AbstractType;
import engine.TypeInitializer;
import engine.observer.ObservableMap;
import engine.observer.ObservableProperty;


public class LevelType extends AbstractType implements Level {
	//TODO Make enemyCounts ObservableMap change to doubles
    private ObservableMap<Integer, Integer> enemyCounts;
	private ObservableProperty<Double> rewardHealth;
	private ObservableProperty<Double> rewardMoney;
	private ObservableProperty<Double> rewardPoints;
	private ObservableProperty<Double> durationInSeconds;


    protected LevelType (TypeInitializer typeBuilder) {
    	super(typeBuilder);	
	}
    

	@Override
	public Map<Integer, Integer> getEnemyCounts() {
		return Collections.unmodifiableMap(enemyCounts.getProperty());
	}

	@Override
	public void setEnemyCounts(int enemy, int enemyCount) {
		enemyCounts.put(enemy, enemyCount);
	}

	@Override
	public void removeEnemy(int enemy) {
		enemyCounts.remove(enemy);
	}
	
	@Override
	public double getRewardHealth() {
		return rewardHealth.getProperty();
	}

	@Override
	public void setRewardHealth(double rewardHealth) {
		this.rewardHealth.setProperty(rewardHealth);
	}

	@Override
	public double getRewardMoney() {
		return rewardMoney.getProperty();
	}

	@Override
	public void setRewardMoney(double rewardMoney) {
		this.rewardMoney.setProperty(rewardMoney);
	}

	@Override
	public double getRewardPoints() {
		return rewardPoints.getProperty();
	}

	@Override
	public void setRewardPoints(double rewardPoints) {
		this.rewardPoints.setProperty(rewardPoints);
	}

	@Override
	public double getDurationInSeconds() {
		return durationInSeconds.getProperty();
	}

	@Override
	public void setDurationInSeconds(double durationInSeconds) {
		this.durationInSeconds.setProperty(durationInSeconds);
	}

}
