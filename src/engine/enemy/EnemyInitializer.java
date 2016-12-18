package engine.enemy;

import engine.TypeInitializer;
import engine.observer.ObservableProperty;

/**
 * Interface that returns the Observable Properties of the Enemy.
 * Utilized primarily when a new enemy has been created and called in the constructor of EnemyType
 * Extends TypeInitializer and implemented by The EnemyBuilder
 * @author ezra
 *
 */
public interface EnemyInitializer extends TypeInitializer{
	/**
	 * 
	 * @return The speed property of the Enemy
	 */
    ObservableProperty<Double> getSpeed();
    
    /**
     * 
     * @return The health property of the Enemy
     */
    ObservableProperty<Double> getHealth();
    
    /**
     * 
     * @return The damage property of the Enemy
     */
    ObservableProperty<Double> getDamage();
    
    /**
     * 
     * @return The score property of the Enemy
     */
    ObservableProperty<Double> getScore();
    
    /**
     * 
     * @return The money property of the Enemy
     */
    ObservableProperty<Double> getMoney();
    
    /**
     * 
     * @return The collision property of the Enemy
     */
    ObservableProperty<String> getCollisionEffect();
}
