package engine.weapon;

import engine.TypeInitializer;
import engine.observer.ObservableProperty;


public interface WeaponInitializer extends TypeInitializer {

    ObservableProperty<Double> getFireRate ();

    ObservableProperty<String> getTrajectory ();

    ObservableProperty<String> getEffect ();

    ObservableProperty<Double> getSpeed ();

    ObservableProperty<Double> getRange ();

}
