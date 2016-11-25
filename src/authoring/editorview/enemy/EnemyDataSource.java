package authoring.editorview.enemy;

import java.util.List;


public interface EnemyDataSource {

    public void createEnemy ();

    public void setEnemyName (int enemyID, String name);

    public void setEnemyImage (int enemyID, String enemyImagePath);

    public void setEnemySpeed (int enemyID, int speed);

    public void setEnemyHealth (int enemyID, int health);

    public void setEnemyDamage (int enemyID, int damage);

    public void setEnemyRewardMoney (int enemyID, int money);

    public void setEnemyRewardPoints (int enemyID, int points);

    public void setEnemyCollisionEffect (int enemyID, String collisionEffect);

    public void setEnemyFrequency (int enemyID, int frequency);

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
