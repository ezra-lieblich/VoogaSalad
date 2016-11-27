package engine.weapon;

import engine.observer.ObservableProperty;


public interface WeaponInitializer {

    ObservableProperty<Double> getFireRate ();

    ObservableProperty<String> getTrajectory ();

    ObservableProperty<String> getEffect ();

    ObservableProperty<Double> getSpeed ();

    ObservableProperty<Double> getRange ();

}
