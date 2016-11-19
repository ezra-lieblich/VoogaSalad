package engine;

import gameplayer.model.Enemy;

import java.util.Collections;
import java.util.Map;
import java.util.HashMap;


public class Level {
	private Map<EnemyType, Integer> enemyCounts;
	private int rewardHealth;
	private int rewardMoney;
	private int rewardPoints;
	private double durationInSeconds;

	public Level() {
		enemyCounts = new HashMap<>();
	}

	public Map<EnemyType, Integer> getEnemyCounts() {
		return Collections.unmodifiableMap(enemyCounts);
	}

	public void setEnemyCounts(EnemyType enemy, int enemyCount) {
		enemyCounts.put(enemy, enemyCount);
	}

	public int getRewardHealth() {
		return rewardHealth;
	}

	public void setRewardHealth(int rewardHealth) {
		this.rewardHealth = rewardHealth;
	}

	public int getRewardMoney() {
		return rewardMoney;
	}

	public void setRewardMoney(int rewardMoney) {
		this.rewardMoney = rewardMoney;
	}

	public int getRewardPoints() {
		return rewardPoints;
	}

	public void setRewardPoints(int rewardPoints) {
		this.rewardPoints = rewardPoints;
	}

	public double getDurationInSeconds() {
		return durationInSeconds;
	}

	public void setDurationInSeconds(double durationInSeconds) {
		this.durationInSeconds = durationInSeconds;
	}
}
