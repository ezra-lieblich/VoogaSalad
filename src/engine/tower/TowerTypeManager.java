package engine.tower;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import engine.AbstractTypeManager;
import engine.ManagerMediator;
import engine.ability.Ability;
import engine.ability.AbilityManager;
import engine.ability.AbilityType;
import engine.enemy.EnemyManager;
import engine.enemy.EnemyType;
import engine.weapon.Weapon;
import engine.weapon.WeaponManager;
import engine.weapon.WeaponType;

public class TowerTypeManager extends AbstractTypeManager<Tower> implements TowerManager {

    public TowerTypeManager (ManagerMediator managerMediator) {
        // TODO Auto-generated constructor stub
    }
    
    public void visitRemoveEntry(WeaponManager manager, Integer index) {
        applyToAllEntities(a -> a.removeWeapon(index));
    }
    
    public void visitRemoveEntry(AbilityManager manager, Integer index) {
        applyToAllEntities(a -> a.removeAbility(index));
    }

        //TODO - Flatten hierarchy maybe?

}
