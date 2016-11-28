package engine.tower;

import engine.Manager;
import engine.Type;
import engine.ability.AbilityManager;
import engine.enemy.EnemyManager;
import engine.weapon.WeaponManager;

public interface TowerManager extends Manager<Tower> {

    
    void visitRemoveEntry(EnemyManager manager, Integer index);
    
    void visitRemoveEntry(WeaponManager manager, Integer index);
    
    void visitRemoveEntry(AbilityManager manager, Integer index);
}
