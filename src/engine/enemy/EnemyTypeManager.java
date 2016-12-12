package engine.enemy;

import engine.AbstractTypeManager;
import engine.effect.EffectManager;
import engine.effect.EffectManagerFactory;
import engine.effect.player.AbstractEffectFactory;
import engine.effect.player.CollisionEffectFactory;

public class EnemyTypeManager extends AbstractTypeManager<Enemy> implements EnemyManager {
    
    public static final Class<? extends AbstractEffectFactory> DEFAULT_EFFECT_FACTORY = CollisionEffectFactory.class;

    private EffectManager enemyEffectManager;
    

    EnemyTypeManager() {
    	this.enemyEffectManager = new EffectManagerFactory().create(DEFAULT_EFFECT_FACTORY);
    }
	@Override
	public EffectManager getEnemyEffectManager() {
		return enemyEffectManager;
	}

}
