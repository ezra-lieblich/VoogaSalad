package engine.tower;

import java.util.List;
import engine.TypeInitializer;
import engine.ability.Ability;
import engine.enemy.Enemy;
import engine.observer.ObservableProperty;
import engine.weapon.Weapon;


public interface TowerInitializer extends TypeInitializer {

    List<Integer> getUpgrades ();

    List<Integer> getWeapons ();

    List<Integer> getTargets ();

    List<Integer> getAbilities ();

    ObservableProperty<Double> getCost ();

    ObservableProperty<Double> getSellAmount ();

    ObservableProperty<Integer> getUnlockLevel ();

}
