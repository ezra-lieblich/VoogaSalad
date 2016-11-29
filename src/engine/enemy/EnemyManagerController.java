package engine.enemy;
import java.util.List;

import authoring.editorview.enemy.IEnemyUpdateView;
import engine.ManagerController;

//IEnemyUpdateView needs to extend IUpdateView
public interface EnemyManagerController extends ManagerController<EnemyManager, EnemyBuilder, Enemy, IEnemyUpdateView> {

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

    public double getEnemySpeed (int enemyID); //

    public double getEnemyHealth (int enemyID); // 

    public double getEnemyDamage (int enemyID); // 

    public double getEnemyRewardMoney (int enemyID); //

    public double getEnemyRewardPoints (int enemyID); //

    public String getEnemyCollisionEffect (int enemyID);

}
