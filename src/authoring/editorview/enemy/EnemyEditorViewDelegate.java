package authoring.editorview.enemy;

/**
 * 
 * @author Andrew Bihl
 * @author Kayla Schulz
 *
 */
public interface EnemyEditorViewDelegate {

    public void onUserPressedCreateEnemy ();

    public void onUserPressedDeleteEnemy ();

    public void onUserEnteredEnemySpeed (String enemySpeed);

    public void onUserEnteredEnemyHealth (String enemyHealth);

    public void onUserEnteredEnemyDamage (String enemyDamage);

    public void onUserEnteredEnemyPoints (String enemyRewardPoints);

    public void onUserEnteredEnemyMoney (String enemyRewardMoney);

    public void onUserEnteredEnemyCollisionEffect (String enemyCollisionEffect);

    public void onUserEnteredEnemyImagePath (String enemyImagePath);

    public void onUserEnteredEnemyName (String enemyName);

    public void onUserEnteredEnemySize (String enemySize);
    
    public void onUserSelectedEnemy (int enemyID);
}
