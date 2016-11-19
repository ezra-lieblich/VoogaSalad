package engine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TowerTypeManager extends EntityManager<TowerType> {

    private Map<WeaponType, List<TowerType>> weaponMappings = new HashMap<WeaponType, List<TowerType>>();

    @Override
    protected TowerType createInstance () {
        return new TowerType();
    }
    
    public void removeWeaponMapping(WeaponType weapon) {
        //Can do a dope stream here
        for (TowerType tower : weaponMappings.get(weapon)) {
            tower.removeWeapon(weapon);
        }
        weaponMappings.remove(weapon);
    }

}
