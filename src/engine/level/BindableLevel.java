package engine.level;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import engine.BindableType;
import engine.level.wave.Wave;


public interface BindableLevel extends BindableType<LevelBuilder> {
    LevelBuilder addWaveListener (BiConsumer<Map<Integer, Wave>, Map<Integer, Wave>> listener);

    LevelBuilder addPathListener (BiConsumer<List<Integer>, List<Integer>> listener);

    LevelBuilder addRewardHealthListener (BiConsumer<Double, Double> listener);

    LevelBuilder addRewardMoneyListener (BiConsumer<Double, Double> listener);

    LevelBuilder addRewardScoreListener (BiConsumer<Double, Double> listener);

    LevelBuilder addDurationInSecondsListener (BiConsumer<Double, Double> listener);

    LevelBuilder addLevelTimeListener (BiConsumer<Double, Double> listener);

}
