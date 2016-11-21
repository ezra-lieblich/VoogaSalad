package engine.tower;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import engine.AbstractTypeManager;
import engine.ability.Ability;
import engine.ability.AbilityType;
import engine.enemy.EnemyType;
import engine.weapon.Weapon;
import engine.weapon.WeaponType;

public class TowerTypeManager extends AbstractTypeManager<Tower> implements TowerManager {

    //private Map<WeaponType, List<TowerType>> weaponMappings = new HashMap<WeaponType, List<TowerType>>();

    @Override
    protected Tower createInstance () {
        return new TowerType();
    }

    @Override
    public void addUpgrade (Tower upgrade) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void removeUpgrade (Tower upgrade) {
        getActiveEntity().removeUpgrade(upgrade);
        notifyObservers(getActiveId());
    }

    @Override
    public List<Tower> getUpgrades () {
        return getActiveEntity().getUpgrades();
    }


}
