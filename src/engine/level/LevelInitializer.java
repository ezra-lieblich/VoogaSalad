package engine.level;

import engine.TypeInitializer;
import engine.observer.ObservableMap;
import engine.observer.ObservableProperty;


public interface LevelInitializer extends TypeInitializer {
	//TODO Make enemyCounts of type ObservableMap
	ObservableMap<Integer, Integer> getEnemyCounts();
	ObservableProperty<Double> getRewardHealth();
    ObservableProperty<Double> getRewardMoney();
    ObservableProperty<Double> getRewardPoints();
    ObservableProperty<Double> getDurationInSeconds();
}
