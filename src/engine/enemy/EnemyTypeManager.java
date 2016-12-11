package engine.enemy;

import engine.AbstractTypeManager;
import engine.effect.EffectManager;
import engine.effect.EffectManagerFactory;

public class EnemyTypeManager extends AbstractTypeManager<Enemy> implements EnemyManager {
    private EffectManager enemyEffectManager;

    EnemyTypeManager() {
    	this.enemyEffectManager = new EffectManagerFactory().create();
    }
	@Override
	public EffectManager getEnemyEffectManager() {
		return enemyEffectManager;
	}

}
