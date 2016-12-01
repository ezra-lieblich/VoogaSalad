package engine.level;

import java.util.Map;
import java.util.function.BiConsumer;
import engine.BindableType;


public interface BindableLevel extends BindableType<LevelBuilder> {
    LevelBuilder addEnemyCountsListener (BiConsumer<Map<Integer, Integer>, Map<Integer, Integer>> listener);

    LevelBuilder addRewardHealthListener (BiConsumer<Double, Double> listener);

    LevelBuilder addRewardMoneyListener (BiConsumer<Double, Double> listener);

    LevelBuilder addRewardScoreListener (BiConsumer<Double, Double> listener);

    LevelBuilder addDurationInSecondsListener (BiConsumer<Double, Double> listener);

}
