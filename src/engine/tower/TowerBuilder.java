package engine.tower;

import java.util.List;
import engine.TypeBuilder;


/**
 * 
 * 
 * @author seanhudson
 *
 */
public interface TowerBuilder extends TypeBuilder<Tower, TowerBuilder>, BindableTower {
    
    TowerBuilder buildWeapons (Integer ... weapons);
    
    TowerBuilder buildWeapons (List<Integer> weapons);

    TowerBuilder buildAbilities (Integer ... targets);
    
    TowerBuilder buildAbilities (List<Integer> targets);
    
    TowerBuilder buildUpgrades(Integer ... upgrades);
    
    TowerBuilder buildUpgrades (List<Integer> upgrades);

    TowerBuilder buildCost (double cost);

    TowerBuilder buildSellAmount (double sellAmount);

    TowerBuilder buildUnlockLevel (int unlockLevel);

}
