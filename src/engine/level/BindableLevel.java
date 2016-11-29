package engine.level;

import java.util.Map;
import java.util.function.BiConsumer;

import engine.BindableType;

public interface BindableLevel  extends BindableType<LevelBuilder>{
	//TODO Add listener for observable Map change to double double
	LevelBuilder addEnemyCountsListener(BiConsumer<Map<Integer, Integer>, Map<Integer, Integer>> listener);
	LevelBuilder addRewardHealthListener(BiConsumer<Double, Double> listener);
	LevelBuilder addRewardMoneyListener(BiConsumer<Double, Double> listener);
	LevelBuilder addRewardPointsListener(BiConsumer<Double, Double> listener);
	LevelBuilder addDurationInSecondsListener(BiConsumer<Double, Double> listener);
	
}
