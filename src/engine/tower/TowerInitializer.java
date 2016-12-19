package engine.tower;

import engine.TypeInitializer;
import engine.observer.ObservableList;
import engine.observer.ObservableProperty;

/**
 * 
 * 
 * @author seanhudson
 *
 */
public interface TowerInitializer extends TypeInitializer {

    ObservableList<Integer> getWeapons ();

    ObservableList<Integer> getAbilities ();
    
    ObservableList<Integer> getUpgrades ();

    ObservableProperty<Double> getCost ();

    ObservableProperty<Double> getSellAmount ();

    ObservableProperty<Integer> getUnlockLevel ();

}
