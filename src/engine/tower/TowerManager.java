package engine.tower;

import java.util.Map;
import engine.Manager;
import engine.ability.AbilityManager;
import engine.effect.EffectManager;
import engine.weapon.WeaponManager;

/**
 * 
 * 
 * @author seanhudson
 *
 */
public interface TowerManager extends Manager<Tower> {

    void visitRemoveEntry(WeaponManager manager, Integer index);
    
    void visitRemoveEntry(AbilityManager manager, Integer index);
    
    int addUpgrade(Tower upgrade, int parentId);
    
    void removeUpgrade(int id, int parentId);
    
    Map<Integer, Tower> getUpgrades();
    
    EffectManager getEffectManager ();
}
