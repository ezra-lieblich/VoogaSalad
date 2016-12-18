package engine.enemy;

import engine.AbstractTypeManager;
import engine.effect.EffectManager;
import engine.effect.EffectManagerFactory;
import gameplayer.model.effect.AbstractEffectFactory;
import gameplayer.model.effect.CollisionEffectFactory;

/**
 * Concrete implementation of the EnemyManager. See EnemyManager for documentation for what this class does
 * @author ezra
 *
 */
public class EnemyTypeManager extends AbstractTypeManager<Enemy> implements EnemyManager {
    
    public static final Class<? extends AbstractEffectFactory> DEFAULT_EFFECT_FACTORY = CollisionEffectFactory.class;

    private EffectManager enemyEffectManager;
    
    /**
     * Initializes the EffectManager and sets it to the default Factory
     */
    EnemyTypeManager() {
    	this.enemyEffectManager = new EffectManagerFactory().create(DEFAULT_EFFECT_FACTORY);
    }
    
    /**
     * Returns the effect manager
     */
	@Override
	public EffectManager getEnemyEffectManager() {
		return enemyEffectManager;
	}

}
