package engine.level;

import engine.Manager;
import engine.enemy.EnemyManager;
import engine.path.PathManager;
import engine.settings.GameModeManager;
import engine.weapon.WeaponManager;


/**
 * Created by ezra on 11/20/16.
 */
public interface LevelManager extends Manager<Level> {

    void visitRemoveEntry (EnemyManager manager, Integer index);
    void visitRemoveEntry(PathManager manager, Integer index);
    void visitAddPath(GameModeManager manager, Integer pathID);
    void visitRemovePath(GameModeManager manager, Integer pathID);
}
