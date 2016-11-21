package engine.level;


import java.util.Collections;
import java.util.Map;

import engine.AbstractType;
import engine.enemy.EnemyType;
import java.util.HashMap;


public class LevelType extends AbstractType implements Level {
	private Map<EnemyType, Integer> enemyCounts;
	private int rewardHealth;
	private int rewardMoney;
	private int rewardPoints;
	private double durationInSeconds;

	public LevelType() {
		enemyCounts = new HashMap<>();
	}

	@Override
	public Map<EnemyType, Integer> getEnemyCounts() {
		return Collections.unmodifiableMap(enemyCounts);
	}

	@Override
	public void setEnemyCounts(EnemyType enemy, int enemyCount) {
		enemyCounts.put(enemy, enemyCount);
	}

	@Override
	public int getRewardHealth() {
		return rewardHealth;
	}

	@Override
	public void setRewardHealth(int rewardHealth) {
		this.rewardHealth = rewardHealth;
	}

	@Override
	public int getRewardMoney() {
		return rewardMoney;
	}

	@Override
	public void setRewardMoney(int rewardMoney) {
		this.rewardMoney = rewardMoney;
	}

	@Override
	public int getRewardPoints() {
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
