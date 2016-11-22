package authoring.editorview.enemy;

public interface EnemyDataSource {

    public void createEnemy ();

    public void setEnemyName (int enemyID, String name);

    public void setEnemyImage (int enemyImageID);

    public void setEnemySpeed (int enemyID, int speed);

    public void setEnemyHealth (int enemyID, int health);

    public void setEnemyRewardMoney (int enemyID, int money);

    public void setEnemyRewardPoints (int enemyID, int points);
}
