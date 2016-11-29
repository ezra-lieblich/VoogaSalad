package engine.level;

import java.util.Map;

import engine.TypeBuilder;

public interface LevelBuilder extends TypeBuilder<Level, LevelBuilder>, BindableLevel { //TODO - Add bindable interface
	//TODO Fix EnemyCounts
	
	LevelBuilder buildEnemyCounts(Map<Integer, Integer> enemies);
	LevelBuilder buildRewardHealth(double rewardHealth);
	LevelBuilder buildRewardMoney(double rewardMoney);
	LevelBuilder buildRewardPoints(double rewardPoints);
	LevelBuilder buildDurationInSeconds(double durationInSeconds);


}
