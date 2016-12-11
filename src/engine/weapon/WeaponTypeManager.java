package engine.weapon;

import engine.AbstractTypeManager;
import engine.effect.EffectManager;
import engine.effect.EffectManagerFactory;
import engine.effect.EffectTypeManager;
import engine.enemy.EnemyManager;

public class WeaponTypeManager extends AbstractTypeManager<Weapon> implements WeaponManager {
    
    private EffectManager weaponEffectManager;
    
    WeaponTypeManager() {
        weaponEffectManager = new EffectManagerFactory().create();
    }
    
    @Override
    public void visitRemoveEntry(EnemyManager manager, Integer index) {
        applyToAllEntities(a -> a.removeTarget(index));
    }

    @Override
    public EffectManager getWeaponEffectManager () {
        return weaponEffectManager;
    }
 
}