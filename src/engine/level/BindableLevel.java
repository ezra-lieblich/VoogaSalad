package engine.level;

import java.util.Map;
import java.util.function.BiConsumer;
import engine.BindableType;
import engine.level.wave.WaveType;


public interface BindableLevel extends BindableType<LevelBuilder> {
    LevelBuilder addWaveListener (BiConsumer<Map<Integer, WaveType>, Map<Integer, WaveType>> listener);

    LevelBuilder addRewardHealthListener (BiConsumer<Double, Double> listener);

    LevelBuilder addRewardMoneyListener (BiConsumer<Double, Double> listener);

    LevelBuilder addRewardScoreListener (BiConsumer<Double, Double> listener);

    LevelBuilder addDurationInSecondsListener (BiConsumer<Double, Double> listener);
    
    LevelBuilder addLevelTimeListener (BiConsumer<Double, Double> listener);

}
