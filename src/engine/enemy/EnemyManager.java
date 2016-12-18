package engine.enemy;


import engine.Manager;
import engine.effect.EffectManager;

/**
 * Interface that manages all the Enemies created in authoring side. 
 * See the AbstractTypeManager to see how manager accesses the enemies created.
 * Also in charge in the effects associated with the enemies and holds effectsManager
 * Extends the Manager interface.
 * 
 * Created by ezra on 11/19/16.
 */
public interface EnemyManager extends Manager<Enemy> {
	
	/**
	 * Gives user access to enemyEffectManager
	 * @return The EffectManager class that allows users to create enemy effects
	 */
    EffectManager getEnemyEffectManager () ;
}
