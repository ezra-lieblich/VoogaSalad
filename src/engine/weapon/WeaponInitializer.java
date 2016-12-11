package engine.weapon;

import engine.TypeInitializer;
import engine.observer.ObservableList;
import engine.observer.ObservableProperty;


public interface WeaponInitializer extends TypeInitializer {

    ObservableList<Integer> getTargets ();
    
    ObservableProperty<Double> getReloadTime ();

    ObservableProperty<String> getTrajectory ();

    ObservableProperty<String> getEffect ();

    ObservableProperty<Double> getSpeed ();

    ObservableProperty<Double> getRange ();

}
