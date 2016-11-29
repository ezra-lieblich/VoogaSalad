package authoring.editorview.enemy;

import java.io.IOException;
import java.util.ResourceBundle;
import authoring.editorview.EditorViewController;
import authoring.utilityfactories.DialogueBoxFactory;


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
    private IEnemyUpdateView myView;

    public EnemyEditorViewController (int editorWidth, int editorHeight) throws IOException {
        myView = EnemyEditorViewFactory.build(editorWidth, editorHeight);
        myView.setDelegate(this);
        this.view = myView;
    }

    public void setEnemyDataSource (EnemyDataSource source) {
        this.enemyDataSource = source;
    }

    @Override
    public void onUserPressedCreateEnemy () {
        enemyDataSource.createEnemy(myView);
    }

    @Override
    public void onUserEnteredEnemySpeed (String enemySpeed) {
        try {
            Integer.parseInt(enemySpeed);
            enemyDataSource.setEnemySpeed(currentEnemyID, Integer.parseInt(enemySpeed));
        }
        catch (NumberFormatException e) {
            createDialogueBox();
        }
    }

    @Override
    public void onUserEnteredEnemyHealth (String enemyHealth) {
        try {
            Integer.parseInt(enemyHealth);
            enemyDataSource.setEnemyHealth(currentEnemyID, Integer.parseInt(enemyHealth));
        }
        catch (NumberFormatException e) {
            createDialogueBox();
        }

    }

    @Override
    public void onUserEnteredEnemyDamage (String enemyDamage) {
        try {
            Integer.parseInt(enemyDamage);
            enemyDataSource.setEnemyDamage(currentEnemyID, Integer.parseInt(enemyDamage));
        }
        catch (NumberFormatException e) {
            createDialogueBox();
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
            createDialogueBox();
        }
    }

    @Override
    public void onUserEnteredEnemyMoney (String enemyRewardMoney) {
        try {
            Integer.parseInt(enemyRewardMoney);
            enemyDataSource.setEnemyRewardMoney(currentEnemyID, Integer.parseInt(enemyRewardMoney));
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
