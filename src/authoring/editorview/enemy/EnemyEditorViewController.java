package authoring.editorview.enemy;

import java.io.IOException;
import java.util.ResourceBundle;
import authoring.editorview.EditorViewController;
import authoring.editorview.enemy.subviews.EnemyListCellData;
import authoring.editorview.enemy.subviews.EnemyListDataSource;
import authoring.utilityfactories.DialogueBoxFactory;
import engine.enemy.*;


/**
 * 
 * @author Andrew Bihl
 * @author Kayla Schulz
 *
 */
public class EnemyEditorViewController extends EditorViewController
        implements EnemyEditorViewDelegate, EnemyListDataSource {

    private EnemyManagerController enemyDataSource;
    private int currentEnemyID;
    private IEnemyEditorView myView;

    public EnemyEditorViewController (int editorWidth, int editorHeight) throws IOException {
        myView = EnemyEditorViewFactory.build(editorWidth, editorHeight);
        myView.setDelegate(this);
        myView.setEnemyListDataSource(this);
        this.view = myView;
    }

    public void setEnemyDataSource (EnemyManagerController source) {
        this.enemyDataSource = source;
    }

    @Override
    public int onUserPressedCreateEnemy () {
        return enemyDataSource.createType(myView);
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
            enemyDataSource.setEnemyRewardScore(currentEnemyID,
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
            enemyDataSource.setEnemyRewardMoney(currentEnemyID,
                                                Double.parseDouble(enemyRewardMoney));
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
        enemyDataSource.setImagePath(currentEnemyID, enemyImagePath);
    }

    @Override
    public void onUserEnteredEnemyName (String enemyName) {
        enemyDataSource.setName(currentEnemyID, enemyName);
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

    @Override
    public EnemyListCellData getCellDataForEnemy (int enemyID) {
        EnemyListCellData cellData = new EnemyListCellData();
        cellData.setName(enemyDataSource.getName(enemyID));
        cellData.setImagePath(enemyDataSource.getImagePath(enemyID));
        return cellData;
    }

}
