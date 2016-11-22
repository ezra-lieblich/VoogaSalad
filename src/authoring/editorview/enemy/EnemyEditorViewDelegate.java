package authoring.editorview.enemy;

public interface EnemyEditorViewDelegate {

    public void onUserPressedCreateEnemy ();

    public void onUserEnteredEnemySpeed (String speed);

    public void onUserEnteredEnemyHealth (String health);

    public void onUserEnteredEnemyDamage (String damage);

    public void onUserEnteredEnemyPoints (String points);

    public void onUserEnteredEnemyMoney (String money);

    public void onUserEnteredEnemyCollisionEffect (String collisionEffect);

    public void onUserEnteredEnemyImagePath (String imagePath);

}
