package engine.level;

import engine.TypeInitializer;
import engine.observer.ObservableMap;
import engine.observer.ObservableProperty;


public interface LevelInitializer extends TypeInitializer {
    ObservableMap<Integer, WaveType> getWaves ();

    ObservableProperty<Double> getRewardHealth ();

    ObservableProperty<Double> getRewardMoney ();

    ObservableProperty<Double> getRewardScore ();

    ObservableProperty<Double> getDurationInSeconds ();
    
    ObservableProperty<Double> getLevelTime ();
}
