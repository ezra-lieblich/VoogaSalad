package engine.level;

import engine.AbstractTypeManager;
import engine.enemy.EnemyManager;


/**
 *
 * Created by ezra on 11/17/16.
 */
public class LevelTypeManager extends AbstractTypeManager<Level> implements LevelManager {

    @Override
    public void visitRemoveEntry (EnemyManager manager, Integer index) {
        applyToAllEntities(a -> a.removeWave(index));

    }

}
