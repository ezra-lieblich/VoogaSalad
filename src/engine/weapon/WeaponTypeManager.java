package engine.weapon;

import engine.AbstractTypeManager;
import engine.effect.EffectManager;
import engine.enemy.EnemyManager;

public class WeaponTypeManager extends AbstractTypeManager<Weapon> implements WeaponManager {
    
    private EffectManager weaponEffectManager;
    
    @Override
    public void visitRemoveEntry(EnemyManager manager, Integer index) {
        applyToAllEntities(a -> a.removeTarget(index));
    }

    @Override
    public EffectManager getWeaponEffectManager () {
        return weaponEffectManager;
    }
 
}