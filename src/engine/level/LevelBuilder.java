package engine.level;

import engine.TypeBuilder;

public interface LevelBuilder extends TypeBuilder<Level, LevelBuilder>, BindableLevel { //TODO - Add bindable interface
	//TODO Fix EnemyCounts
	LevelBuilder buildEnemyCounts(double speed);
	LevelBuilder buildRewardHealth(double rewardHealth);
	LevelBuilder buildRewardMoney(double rewardMoney);
	LevelBuilder buildRewardPoints(double rewardPoints);
	LevelBuilder buildDurationInSeconds(double durationInSeconds);


}
