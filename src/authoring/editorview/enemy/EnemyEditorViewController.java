package authoring.editorview.enemy;

import java.io.IOException;
import authoring.ErrorBox;
import authoring.editorview.EditorViewController;


/**
 * 
 * @author Andrew Bihl
 * @author Kayla Schulz
 *
 */
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
        enemyDataSource.createEnemy();
    }

    @Override
    public void onUserEnteredEnemySpeed (String enemySpeed) {
        try {
            Integer.parseInt(enemySpeed);
            enemyDataSource.setEnemySpeed(currentEnemyID, Integer.parseInt(enemySpeed));
        }
        catch (NumberFormatException e) {
            ErrorBox.createErrorBox("This input is not an integer");
        }
    }

    @Override
    public void onUserEnteredEnemyHealth (String enemyHealth) {
        try {
            Integer.parseInt(enemyHealth);
            enemyDataSource.setEnemyHealth(currentEnemyID, Integer.parseInt(enemyHealth));
        }
        catch (NumberFormatException e) {
            ErrorBox.createErrorBox("This input is not an integer");
        }

    }

    @Override
    public void onUserEnteredEnemyDamage (String enemyDamage) {
        try {
            Integer.parseInt(enemyDamage);
            enemyDataSource.setEnemyDamage(currentEnemyID, Integer.parseInt(enemyDamage));
        }
        catch (NumberFormatException e) {
            ErrorBox.createErrorBox("This input is not an integer");
        }
    }

    @Override
    public void onUserEnteredEnemyPoints (String enemyRewardPoints) {
        try {
            Integer.parseInt(enemyRewardPoints);
            enemyDataSource.setEnemyRewardPoints(currentEnemyID,
                                                 Integer.parseInt(enemyRewardPoints));
        }
        catch (NumberFormatException e) {
            ErrorBox.createErrorBox("This input is not an integer");
        }
    }

    @Override
    public void onUserEnteredEnemyMoney (String enemyRewardMoney) {
        try {
            Integer.parseInt(enemyRewardMoney);
            enemyDataSource.setEnemyRewardMoney(currentEnemyID, Integer.parseInt(enemyRewardMoney));
        }
        catch (NumberFormatException e) {
            ErrorBox.createErrorBox("This input is not an integer");
        }
    }

    @Override
    public void onUserEnteredEnemyCollisionEffect (String enemyCollisionEffect) {
        enemyDataSource.setEnemyCollisionEffect(currentEnemyID, enemyCollisionEffect);
    }

    @Override
    public void onUserEnteredEnemyImagePath (String enemyImagePath) {
        enemyDataSource.setEnemyImage(currentEnemyID, enemyImagePath);
    }

    @Override
    public void onUserEnteredEnemyName (String enemyName) {
        enemyDataSource.setEnemyName(currentEnemyID, enemyName);
    }

    @Override
    public void onUserEnteredEnemyFrequency (String enemyFrequency) {
        try {
            Integer.parseInt(enemyFrequency);
            enemyDataSource.setEnemyFrequency(currentEnemyID, Integer.parseInt(enemyFrequency));
        }
        catch (NumberFormatException e) {
            ErrorBox.createErrorBox("This input is not an integer");
        }
    }

}
