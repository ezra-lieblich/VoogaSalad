package engine.level;

import engine.Manager;
import engine.enemy.EnemyManager;
import engine.path.PathManager;
import engine.weapon.WeaponManager;


/**
 * Created by ezra on 11/20/16.
 */
public interface LevelManager extends Manager<Level> {

    // TODO Need to go into waves and remove this
    void visitRemoveEntry (EnemyManager manager, Integer index);
    void visitRemoveEntry(PathManager manager, Integer index);

}
