package authoring.editorview.enemy;

import authoring.editorview.EditorViewDelegate;

/**
 * 
 * @author Andrew Bihl
 * @author Kayla Schulz
 *
 */
public interface EnemyAuthoringViewDelegate extends EditorViewDelegate {

    public void onUserPressedCreateEnemy ();

    public void onUserEnteredEnemySpeed (String enemySpeed);

    public void onUserEnteredEnemyHealth (String enemyHealth);

    public void onUserEnteredEnemyDamage (String enemyDamage);

    public void onUserEnteredEnemyPoints (String enemyRewardPoints);

    public void onUserEnteredEnemyMoney (String enemyRewardMoney);

    public void onUserEnteredEnemyImagePath (String enemyImagePath);

    public void onUserEnteredEnemySize (String enemySize);

    public void onUserSelectedEnemy (int enemyID);

    public void onUserPressedAddEffect ();
}
