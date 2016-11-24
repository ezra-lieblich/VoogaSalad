package engine.tower;

import engine.TypeBuilder;
import engine.ability.Ability;
import engine.enemy.Enemy;
import engine.weapon.Weapon;


public interface TowerBuilder extends TypeBuilder<Tower>, TowerInitializer { //TODO - Add bindable interface

    TowerBuilder buildUpgrades (Tower ... upgrades);

    TowerBuilder buildWeapons (Weapon ... weapons);

    TowerBuilder buildTargets (Enemy ... targets);

    TowerBuilder buildAbilities (Ability ... targets);

    TowerBuilder buildCost (double cost);

    TowerBuilder buildSellAmount (double sellAmount);

    TowerBuilder buildUnlockLevel (int unlockLevel);

}
