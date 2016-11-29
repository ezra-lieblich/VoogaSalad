package authoring.editorview.enemy;

import java.io.IOException;
import java.util.ResourceBundle;
import authoring.editorview.EditorViewController;
import authoring.utilityfactories.DialogueBoxFactory;
import engine.enemy.*;


/**
 * 
 * @author Andrew Bihl
 * @author Kayla Schulz
 *
 */
public class EnemyEditorViewController extends EditorViewController
        implements EnemyEditorViewDelegate {

    private EnemyManagerController enemyDataSource;
    private int currentEnemyID;
    private IEnemyUpdateView myView;

    public EnemyEditorViewController (int editorWidth, int editorHeight) throws IOException {
        myView = EnemyEditorViewFactory.build(editorWidth, editorHeight);
        myView.setDelegate(this);
        this.view = myView;
    }

    public void setEnemyDataSource (EnemyManagerController source) {
        this.enemyDataSource = source;
    }

    @Override
    public void onUserPressedCreateEnemy () {
        enemyDataSource.createEnemy(myView);
    }

    @Override
    public void onUserEnteredEnemySpeed (String enemySpeed) {
        try {
            Double.parseDouble(enemySpeed);
            enemyDataSource.setEnemySpeed(currentEnemyID, Double.parseDouble(enemySpeed));

        }
        catch (NumberFormatException e) {
            createDialogueBox();
        }
    }

    @Override
    public void onUserEnteredEnemyHealth (String enemyHealth) {
        try {
            Double.parseDouble(enemyHealth);
            enemyDataSource.setEnemyHealth(currentEnemyID, Double.parseDouble(enemyHealth));
        }
        catch (NumberFormatException e) {
            createDialogueBox();
        }

    }

    @Override
    public void onUserEnteredEnemyDamage (String enemyDamage) {
        try {
            Double.parseDouble(enemyDamage);
            enemyDataSource.setEnemyDamage(currentEnemyID, Double.parseDouble(enemyDamage));
        }
        catch (NumberFormatException e) {
            createDialogueBox();
        }
    }

    @Override
    public void onUserEnteredEnemyPoints (String enemyRewardPoints) {
        try {
            Double.parseDouble(enemyRewardPoints);
            enemyDataSource.setEnemyRewardPoints(currentEnemyID,
                                                 Double.parseDouble(enemyRewardPoints));
        }
        catch (NumberFormatException e) {
            createDialogueBox();
        }
    }

    @Override
    public void onUserEnteredEnemyMoney (String enemyRewardMoney) {
        try {
            Double.parseDouble(enemyRewardMoney);
            enemyDataSource.setEnemyRewardMoney(currentEnemyID, Double.parseDouble(enemyRewardMoney));
        }
        catch (NumberFormatException e) {
            createDialogueBox();
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

    private void createDialogueBox () {
        ResourceBundle dialogueBoxResource = ResourceBundle.getBundle("resources/DialogueBox");
        DialogueBoxFactory.createErrorDialogueBox(dialogueBoxResource.getString("Integer"),
                                                  dialogueBoxResource.getString("CheckInput"));
    }

    @Override
    public void onUserPressedDeleteEnemy () {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUserEnteredEnemySize (String enemySize) {
        // TODO Auto-generated method stub

    }

}
