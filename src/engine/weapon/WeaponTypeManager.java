package engine.weapon;

import engine.AbstractTypeManager;
import engine.ManagerMediator;
import engine.MethodData;
import engine.VisitableManager;
import engine.VisitorManager;
import engine.enemy.EnemyManager;

public class WeaponTypeManager extends AbstractTypeManager<Weapon> implements WeaponManager {

    protected WeaponTypeManager (ManagerMediator managerMediator) {
        // TODO Auto-generated constructor stub
    }
    
    public void visitRemoveEntry(EnemyManager manager, Integer index) {
        applyToAllEntities(a -> a.removeEnemy(index));
    }

}