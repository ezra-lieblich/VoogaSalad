package authoring.editorview.enemy;

public interface EnemyEditorViewDelegate {

    public void createEnemy ();

    public void setEnemySpeed (double speed);

    public void setEnemyHealth (double health);

    public void setEnemyDamage (double damage);

    public void setEnemyPoints (double points);

    public void setEnemyMoney (double money);

    public void setEnemyCollisionEffect (String collisionEffect);

    public void setEnemyImagePath (String imagePath);

}
