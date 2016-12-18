package engine.enemy;

import engine.Type;

/**
 * An interface that allows access to the enemies properties. Note that the
 * EnemyManager and EnemyController are the only classes that have access to this interface.
 * Extends Type and also is implemented by the EnemyType
 * Created by ezra on 11/19/16.
 */
public interface Enemy extends Type {

	/**
	 * 
	 * @return The speed property of the Enemy
	 */
    double getSpeed();

    /**
     * Sets the speed of the enemy
     * @param speed 
     */
    void setSpeed(double speed);

    /**
     * 
     * @return The health of the enemy
     */
    double getHealth();

    /**
     * Sets the health of the enemy
     * @param health
     */
    void setHealth(double health);

    /**
     * 
     * @return the damage of the enemy
     */
    double getDamage();

    /**
     * Sets the damage of the enemy
     * @param damage 
     */
    void setDamage(double damage);

    /**
     * 
     * @return The score received for killing an enemy
     */
    double getScore();

    /**
     * Sets the score of the enemy for killing it
     * @param score
     */
    void setScore(double score);

    /**
     * 
     * @return The money received for killing an enemy
     */
    double getMoney();

    /**
     * Sets the money received for killing an enemy
     * @param money
     */
    void setMoney(double money);

    /**
     * 
     * @return The collision effect associated with the enemy
     */
    String getCollisionEffect();

    /**
     * Sets the collsion effect associated with the enemy
     * @param collisionEffect
     */
    void setCollisionEffect(String collisionEffect);
}
