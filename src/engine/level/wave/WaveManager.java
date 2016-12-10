package engine.level.wave;

import engine.Manager;
import engine.enemy.EnemyManager;

public interface WaveManager extends Manager<Wave>{
    void visitRemoveEntry(EnemyManager manager, Integer index);

}
