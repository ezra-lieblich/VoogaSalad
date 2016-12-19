package engine.weapon;

import engine.Manager;
import engine.effect.EffectManager;
import engine.enemy.EnemyManager;

/**
 * 
 * 
 * @author seanhudson
 *
 */
public interface WeaponManager extends Manager<Weapon> {

    void visitRemoveEntry(EnemyManager manager, Integer index);
    
    EffectManager getWeaponEffectManager () ;
}
