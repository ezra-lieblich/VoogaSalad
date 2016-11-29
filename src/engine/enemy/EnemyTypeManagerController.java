package engine.enemy;

import authoring.editorview.enemy.EnemyDataSource;
import authoring.editorview.enemy.IEnemyUpdateView;

import java.util.List;

/**
 * Created by ezra on 11/29/16.
 */
public class EnemyTypeManagerController implements EnemyDataSource{
    private EnemyManager enemyManager;

    public EnemyTypeManagerController(EnemyManager enemyManager) {
        this.enemyManager = enemyManager;
    }
    @Override
    public int createEnemy(IEnemyUpdateView updateEnemyInterface) {
        return 0;
    }

    @Override
    public void deleteEnemy(int enemyID) {

    }

    @Override
    public void setEnemyName(int enemyID, String enemyName) {

    }

    @Override
    public void setEnemySize(int enemyID, double enemyScaleSize) {

    }

    @Override
    public void setEnemyImage(int enemyID, String enemyImagePath) {

    }

    @Override
    public void setEnemySpeed(int enemyID, double enemySpeed) {

    }

    @Override
    public void setEnemyHealth(int enemyID, double enemyHealth) {

    }

    @Override
    public void setEnemyDamage(int enemyID, double enemyDamage) {

    }

    @Override
    public void setEnemyRewardMoney(int enemyID, double enemyRewardMoney) {

    }

    @Override
    public void setEnemyRewardPoints(int enemyID, double enemyRewardPoints) {

    }

    @Override
    public void setEnemyCollisionEffect(int enemyID, String enemyCollisionEffect) {

    }

    @Override
    public String getEnemyImage(int enemyID) {
        return null;
    }

    @Override
    public String getEnemyName(int enemyID) {
        return null;
    }

    @Override
    public double getEnemySpeed(int enemyID) {
        return 0;
    }

    @Override
    public double getEnemySize(int enemyID) {
        return 0;
    }

    @Override
    public double getEnemyHealth(int enemyID) {
        return 0;
    }

    @Override
    public double getEnemyDamage(int enemyID) {
        return 0;
    }

    @Override
    public double getEnemyRewardMoney(int enemyID) {
        return 0;
    }

    @Override
    public double getEnemyRewardPoints(int enemyID) {
        return 0;
    }

    @Override
    public String getEnemyCollisionEffect(int enemyID) {
        return null;
    }

    @Override
    public List<Integer> getCreatedEnemyIDs() {
        return null;
    }
}
