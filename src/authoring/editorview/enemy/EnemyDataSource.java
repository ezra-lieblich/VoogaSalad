package authoring.editorview.enemy;

import java.util.List;


public interface EnemyDataSource {

    public void createEnemy ();

    public void setEnemyName (int enemyID, String enemyName);

    public void setEnemyImage (int enemyID, String enemyImagePath);

    public void setEnemySpeed (int enemyID, int enemySpeed);

    public void setEnemyHealth (int enemyID, int enemyHealth);

    public void setEnemyDamage (int enemyID, int enemyDamage);

    public void setEnemyRewardMoney (int enemyID, int enemyRewardMoney);

    public void setEnemyRewardPoints (int enemyID, int enemyRewardPoints);

    public void setEnemyCollisionEffect (int enemyID, String enemyCollisionEffect);

    public void setEnemyFrequency (int enemyID, int enemyFrequency);

    /**
     * Values to get from model
     * 
     * @param enemyID
     * @return
     */

    public String getEnemyImage (int enemyID);

    public String getEnemyName (int enemyID);

    public int getEnemySpeed (int enemyID);

    public int getEnemyHealth (int enemyID);

    public int getEnemyDamage (int enemyID);

    public int getEnemyRewardMoney (int enemyID);

    public int getEnemyRewardPoints (int enemyID);

    public int getEnemyFrequency (int enemyID);

    public String getEnemyCollisionEffect (int enemyID);

    public int getCreatedEnemy ();

    public List<Integer> getActiveEnemyIDs ();

}
