package engine.enemy;

import authoring.editorview.enemy.EnemyUpdateView;
import engine.ManagerController;
import engine.effect.EffectManagerController;

/**
 * Controller interface for enemies. Front end authoring has access to this interface and calls
 * these methods when they need to either get information or set information for enemies]
 * Extends the Manager Controller and is implemented by the EnemyTypeMangerController
 * @author ezra
 *
 */
public interface EnemyManagerController
        extends ManagerController<EnemyManager, EnemyBuilder, Enemy, EnemyUpdateView> {

	/**
	 * Accesses the enemy by its id from the EnemyManager and then sets its speed to
	 * enemySpeed
	 * @param enemyID
	 * @param enemySpeed
	 */
    public void setEnemySpeed (int enemyID, double enemySpeed);

    /**
	 * Accesses the enemy by its id from the EnemyManager and then sets its health to
	 * enemyHealth
	 * @param enemyID
	 * @param enemyHealth
	 */
    public void setEnemyHealth (int enemyID, double enemyHealth);

    /**
	 * Accesses the enemy by its id from the EnemyManager and then sets its damage to
	 * enemyDamage
	 * @param enemyID
	 * @param enemyDamage
	 */
    public void setEnemyDamage (int enemyID, double enemyDamage);

    /**
	 * Accesses the enemy by its id from the EnemyManager and then sets its reward money to
	 * enemyRewardMoney
	 * @param enemyID
	 * @param enemyRewardMoney
	 */
    public void setEnemyRewardMoney (int enemyID, double enemyRewardMoney);

    /**
	 * Accesses the enemy by its id from the EnemyManager and then sets its reward score to
	 * enemyRewardScore
	 * @param enemyID
	 * @param enemyRewardScore
	 */
    public void setEnemyRewardScore (int enemyID, double enemyRewardScore);

    /**
	 * Accesses the enemy by its id from the EnemyManager and then sets its collision effect to
	 * enemyCollisionEffect
	 * @param enemyID
	 * @param enemyCollisionEffect
	 */
    public void setEnemyCollisionEffect (int enemyID, String enemyCollisionEffect);

    /**
     * Returns the enemySpeed to the front end
     * @param enemyID
     * @return
     */
    public double getEnemySpeed (int enemyID); //

    /**
     * Returns the enemyHealth to the front end
     * @param enemyID
     * @return
     */
    public double getEnemyHealth (int enemyID); //

    /**
     * Returns the enemyDamage to the front end
     * @param enemyID
     * @return
     */
    public double getEnemyDamage (int enemyID); //

    /**
     * Returns the enemyRewardMoney to the front end
     * @param enemyID
     * @return
     */
    public double getEnemyRewardMoney (int enemyID); //

    /**
     * Returns the enemyRewardScore to the front end
     * @param enemyID
     * @return
     */
    public double getEnemyRewardScore (int enemyID); //

    /**
     * Returns the enemyCollisionEffect to the front end
     * @param enemyID
     * @return
     */
    public String getEnemyCollisionEffect (int enemyID);
    
    /**
     * Returns the effectManagerController to the front end
     * @param enemyID
     * @return
     */
    public EffectManagerController getEffectManagerController ();


}
