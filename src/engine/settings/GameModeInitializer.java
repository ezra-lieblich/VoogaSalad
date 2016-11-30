package engine.settings;

import engine.TypeInitializer;
import engine.observer.ObservableList;
import engine.observer.ObservableProperty;

public interface GameModeInitializer extends TypeInitializer {
	ObservableList<String> getWinningConditions();
	ObservableList<String> getLosingConditions();
	ObservableProperty<Double> getInitalLives();
	ObservableProperty<Double> getInitialMoney();
    ObservableProperty<String> getGameType();

}
