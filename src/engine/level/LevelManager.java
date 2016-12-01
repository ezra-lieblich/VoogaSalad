package engine.level;

import engine.Manager;
import engine.enemy.EnemyManager;


/**
 * Created by ezra on 11/20/16.
 */
public interface LevelManager extends Manager<Level> {

    void visitRemoveEntry (EnemyManager manager, Integer index);

}
