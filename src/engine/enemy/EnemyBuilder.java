package engine.enemy;


import engine.TypeBuilder;

/**
 * Interface that builds the Enemy and its attributes. Sets the attributes in the builder implementation
 * and then initializes and creates the enemy when the build method implemented in the AbstractBuilder is called.
 * This class is implemented by EnemyTypeBuilder class
 * @author ezra
 *
 */
public interface EnemyBuilder extends TypeBuilder<Enemy, EnemyBuilder>, BindableEnemy { 

	/**
	 * Builds the enemies speed attribute
	 * @param speed
	 * @return the EnemyBuilder so the user has the ability to build multiple attribute at once
	 */
	EnemyBuilder buildSpeed(double speed);
	
	/**
	 * Builds the enemies health attribute
	 * @param health
	 * @return the EnemyBuilder so the user has the ability to build multiple attribute at once
	 */
	EnemyBuilder buildHealth(double health);
	
	/**
	 * Builds the enemies damage attribute
	 * @param damage
	 * @return the EnemyBuilder so the user has the ability to build multiple attribute at once
	 */
	EnemyBuilder buildDamage(double damage);
	
	/**
	 * Builds the enemies score attribute
	 * @param score
	 * @return the EnemyBuilder so the user has the ability to build multiple attribute at once
	 */
	EnemyBuilder buildScore(double score);
	
	/**
	 * Builds the enemies money attribute
	 * @param money
	 * @return the EnemyBuilder so the user has the ability to build multiple attribute at once
	 */
	EnemyBuilder buildMoney(double money);
	
	/**
	 * Builds the enemies collision effect attribute
	 * @param collisionEffect
	 * @return the EnemyBuilder so the user has the ability to build multiple attribute at once
	 */
	EnemyBuilder buildCollisionEffect(String collisionEffect);
}
