package engine.level.wave;

import engine.AbstractTypeManager;
import engine.enemy.EnemyManager;

public class WaveTypeManager extends AbstractTypeManager<Wave> implements WaveManager {

	 @Override
	    public void visitRemoveEntry (EnemyManager manager, Integer index) {
	       // applyToAllEntities(a -> a.removeWave(index));
		 //Need to do something
	    }

}
