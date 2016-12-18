package engine.enemy;

import java.util.function.BiConsumer;

import engine.BindableType;

/**
 * Interface that binds all of the enemies attributes to the corresponding calls in the front end.
 * These listeners will be called at creation of an enemy and is implemented by the by EnemyTypeBuilder
 * @author ezra
 *
 */
public interface BindableEnemy extends BindableType<EnemyBuilder>{ 
	
	/**
	 * Adds a listener to the enemies speed attribute.
	 * @param listener A consumer that takes in two parameters and calls the method in the 
	 * front end
	 * @return returns the EnemyBuilder to adhere to the builder pattern so they can continue to build their enemy
	 */
	EnemyBuilder addSpeedListener(BiConsumer<Double, Double> listener);
	
	/**
	 * Adds a listener to the enemies health attribute.
	 * @param listener A consumer that takes in two parameters and calls the method in the 
	 * front end
	 * @return returns the EnemyBuilder to adhere to the builder pattern so they can continue to build their enemy
	 */
	EnemyBuilder addHealthListener(BiConsumer<Double, Double> listener);
	
	/**
	 * Adds a listener to the enemies damage attribute.
	 * @param listener A consumer that takes in two parameters and calls the method in the 
	 * front end
	 * @return returns the EnemyBuilder to adhere to the builder pattern so they can continue to build their enemy
	 */
	EnemyBuilder addDamageListener(BiConsumer<Double, Double> listener);
	
	/**
	 * Adds a listener to the enemies score attribute.
	 * @param listener A consumer that takes in two parameters and calls the method in the 
	 * front end
	 * @return returns the EnemyBuilder to adhere to the builder pattern so they can continue to build their enemy
	 */
	EnemyBuilder addScoreListener(BiConsumer<Double, Double> listener);
	
	/**
	 * Adds a listener to the enemies money attribute.
	 * @param listener A consumer that takes in two parameters and calls the method in the 
	 * front end
	 * @return returns the EnemyBuilder to adhere to the builder pattern so they can continue to build their enemy
	 */
	EnemyBuilder addMoneyListener(BiConsumer<Double, Double> listener);
	
	/**
	 * Adds a listener to the enemies collision effect attribute.
	 * @param listener A consumer that takes in two parameters and calls the method in the 
	 * front
	 * @return returns the EnemyBuilder to adhere to the builder pattern so they can continue to build their enemy
	 */
	EnemyBuilder addCollisionEffectListener(BiConsumer<String, String> listener);

}
