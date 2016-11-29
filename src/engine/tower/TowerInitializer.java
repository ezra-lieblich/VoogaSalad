package engine.tower;

import java.util.List;
import engine.TypeInitializer;
import engine.ability.Ability;
import engine.enemy.Enemy;
import engine.observer.ObservableProperty;
import engine.weapon.Weapon;


public interface TowerInitializer extends TypeInitializer {

    ObservableProperty<List<Integer>> getWeapons ();

    ObservableProperty<List<Integer>> getTargets ();

    ObservableProperty<List<Integer>> getAbilities ();
    
    ObservableProperty<Integer> getUpgrade ();

    ObservableProperty<Double> getCost ();

    ObservableProperty<Double> getSellAmount ();

    ObservableProperty<Integer> getUnlockLevel ();

}
