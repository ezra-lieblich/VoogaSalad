package authoring.editorview.enemy;

import java.util.List;


/**
 * 
 * @author Kayla Schulz
 *
 */
public interface EnemyDataSource {

    public int createEnemy (IEnemyUpdateView updateEnemyInterface);

    public void deleteEnemy (int enemyID);

    public void setEnemyName (int enemyID, String enemyName);

    public void setEnemySize (int enemyID, double enemyScaleSize);

    public void setEnemyImage (int enemyID, String enemyImagePath);

    public void setEnemySpeed (int enemyID, double enemySpeed);

    public void setEnemyHealth (int enemyID, double enemyHealth);

    public void setEnemyDamage (int enemyID, double enemyDamage);

    public void setEnemyRewardMoney (int enemyID, double enemyRewardMoney);

    public void setEnemyRewardPoints (int enemyID, double enemyRewardPoints);

    public void setEnemyCollisionEffect (int enemyID, String enemyCollisionEffect);

    /**
     * Values to get from model
     * 
     * @param enemyID
     * @return
     */

    public String getEnemyImage (int enemyID); //

    public String getEnemyName (int enemyID); //

    public double getEnemySpeed (int enemyID); //

    public double getEnemySize (int enemyID); //

    public double getEnemyHealth (int enemyID); // 

    public double getEnemyDamage (int enemyID); // 

    public double getEnemyRewardMoney (int enemyID); //

    public double getEnemyRewardPoints (int enemyID); //

    public String getEnemyCollisionEffect (int enemyID);

    public List<Integer> getCreatedEnemyIDs ();

}
