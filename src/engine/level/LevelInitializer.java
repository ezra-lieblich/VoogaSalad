package engine.level;

import engine.TypeInitializer;
import engine.level.wave.Wave;
import engine.observer.ObservableList;
import engine.observer.ObservableMap;
import engine.observer.ObservableProperty;


public interface LevelInitializer extends TypeInitializer {
	ObservableList<Integer> getPaths ();
	
    ObservableMap<Integer, Wave> getWaves ();

    ObservableProperty<Double> getRewardHealth ();

    ObservableProperty<Double> getRewardMoney ();

    ObservableProperty<Double> getRewardScore ();

    ObservableProperty<Double> getDurationInSeconds ();
    
    ObservableProperty<Double> getLevelTime ();
}
