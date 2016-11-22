package engine.tower;

import java.util.List;
import engine.TypeInitializer;
import engine.ability.Ability;
import engine.enemy.Enemy;
import engine.weapon.Weapon;


public interface TowerInitializer extends TypeInitializer {

    List<Tower> getUpgrades ();

    List<Weapon> getWeapons ();

    List<Enemy> getTargets ();

    List<Ability> getAbilities ();

    double getCost ();

    double getSellAmount ();

    int getUnlockLevel ();

}
