package engine.level.wave;

import java.util.Collections;
import java.util.List;

import engine.AbstractTypeManager;
import engine.enemy.EnemyManager;

public class WaveTypeManager extends AbstractTypeManager<Wave> implements WaveManager {

	 @Override
	    public void visitRemoveEntry (EnemyManager manager, Integer index) {
	       // applyToAllEntities(a -> a.removeWave(index));
		 //Need to do something
	    }

	@Override
	public List<Wave> waveList() {
		return Collections.unmodifiableList((List<Wave>) getEntities().values());
	}
	 

}
