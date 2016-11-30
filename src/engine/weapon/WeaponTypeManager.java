package engine.weapon;

import engine.AbstractTypeManager;
import engine.enemy.EnemyManager;

public class WeaponTypeManager extends AbstractTypeManager<Weapon> implements WeaponManager {
    
    @Override
    public void visitRemoveEntry(EnemyManager manager, Integer index) {
        applyToAllEntities(a -> a.removeTarget(index));
    }

}