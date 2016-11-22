package authoring.editorview.enemy;

import authoring.editorview.EditorViewController;


public class EnemyEditorViewController extends EditorViewController
        implements EnemyEditorViewDelegate {

    private EnemyDataSource enemyDataSource;

    public EnemyEditorViewController (int editorWidth, int editorHeight) {
        IEnemyEditorView myView = EnemyEditorViewFactory.build(editorWidth, editorHeight);
        myView.setDelegate(this);
        this.view = myView;
    }

    public void setEnemyDataSource (EnemyDataSource source) {
        this.enemyDataSource = source;
    }

    @Override
    public void createEnemy () {
        // TODO Auto-generated method stub

    }

    @Override
    public void setEnemySpeed (double speed) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setEnemyHealth (double health) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setEnemyDamage (double damage) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setEnemyPoints (double points) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setEnemyMoney (double money) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setEnemyCollisionEffect (String collisionEffect) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setEnemyImagePath (String imagePath) {
        // TODO Auto-generated method stub

    }

}
