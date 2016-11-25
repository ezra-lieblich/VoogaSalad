package authoring.editorview.enemy;

import java.io.IOException;
import authoring.editorview.EditorViewController;


public class EnemyEditorViewController extends EditorViewController
        implements EnemyEditorViewDelegate {

    private EnemyDataSource enemyDataSource;
    private int currentEnemyID;

    public EnemyEditorViewController (int editorWidth, int editorHeight) throws IOException {
        IEnemyEditorView myView = EnemyEditorViewFactory.build(editorWidth, editorHeight);
        myView.setDelegate(this);
        this.view = myView;
    }

    public void setEnemyDataSource (EnemyDataSource source) {
        this.enemyDataSource = source;
    }

    @Override
    public void onUserPressedCreateEnemy () {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUserEnteredEnemySpeed (String enemySpeed) {
        enemyDataSource.setEnemySpeed(currentEnemyID, Integer.parseInt(enemySpeed));
    }

    @Override
    public void onUserEnteredEnemyHealth (String enemyHealth) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUserEnteredEnemyDamage (String enemyDamage) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUserEnteredEnemyPoints (String enemyRewardPoints) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUserEnteredEnemyMoney (String enemyRewardMoney) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUserEnteredEnemyCollisionEffect (String enemyCollisionEffect) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUserEnteredEnemyImagePath (String enemyImagePath) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUserEnteredEnemyName (String enemyName) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUserEnteredEnemyFrequency (String enemyFrequency) {
        // TODO Auto-generated method stub

    }

}
