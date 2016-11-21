package engine.tower;

import engine.ability.Ability;
import engine.weapon.Weapon;
import gameplayer.model.Enemy;


public interface TowerBuilder {

    TowerBuilder buildUpgrade (Tower ... upgrades);

    TowerBuilder buildWeapons (Weapon ... weapons);

    TowerBuilder buildTargets (Enemy ... targets);

    TowerBuilder buildAbilities (Ability ... targets);

    TowerBuilder buildCost (double cost);

    TowerBuilder buildSellAmount (double sellAmount);

    TowerBuilder buildUnlockLevel (int unlockLevel);

}
