package authoring.editorview.level;

import java.util.ResourceBundle;
import authoring.editorview.EditorViewController;
import authoring.utilityfactories.DialogueBoxFactory;
import engine.level.LevelManagerController;


public class LevelEditorViewController extends EditorViewController
        implements LevelEditorViewDelegate {

    private ILevelEditorView levelView;
    private LevelManagerController levelDataSource;
    private int currentLevelID;

    public LevelEditorViewController (int editorWidth, int editorHeight) {
        levelView = LevelEditorViewFactory.build(editorWidth, editorHeight);
        levelView.setDelegate(this);
        this.view = levelView;
    }

    public void setLevelDataSource (LevelManagerController source) {
        this.levelDataSource = source;
        onUserEnteredCreateLevel();
    }

    @Override
    public void onUserEnteredEditLevel () {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUserEnteredLevelName (String levelName) {
        levelDataSource.setName(currentLevelID, levelName);
    }

    @Override
    public void onUserEnteredCreateLevel () {
        currentLevelID = levelDataSource.createType(levelView);

    }

    @Override
    public void onUserEnteredDeleteLevel () {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUserEnteredTransitionTime (String time) {
        try {
            Double.parseDouble(time);
            levelDataSource.setTransitionTime(currentLevelID, Double.parseDouble(time));
        }
        catch (NumberFormatException e) {
            createDialogueBox();
        }
    }

    @Override
    public void onUserEnteredEnemyFrequency (String frequency) {
        try {
            Double.parseDouble(frequency);
            levelDataSource.setEnemyFrequency(currentLevelID, 0, Double.parseDouble(frequency));
            // TODO: HUGE BTW - the second parameter is the enemy that is set
        }
        catch (NumberFormatException e) {
            createDialogueBox();
        }
    }

    @Override
    public void onUserEnteredAddEnemy (int enemyId, int numEnemies) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUserEnteredRemoveEnemy (int enemyID) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUserEnteredRewardPoints (String points) {
        try {
            Double.parseDouble(points);
            levelDataSource.setRewardScore(currentLevelID, Double.parseDouble(points));
        }
        catch (NumberFormatException e) {
            createDialogueBox();
        }
    }

    @Override
    public void onUserEnteredRewardMoney (String money) {
        try {
            Double.parseDouble(money);
            levelDataSource.setRewardMoney(currentLevelID, Double.parseDouble(money));
        }
        catch (NumberFormatException e) {
            createDialogueBox();
        }
    }

    @Override
    public void onUserEnteredRewardHealth (String health) {
        try {
            Double.parseDouble(health);
            levelDataSource.setRewardHealth(currentLevelID, Double.parseDouble(health));
        }
        catch (NumberFormatException e) {
            createDialogueBox();
        }
    }

    private void createDialogueBox () {
        ResourceBundle dialogueBoxResource = ResourceBundle.getBundle("resources/DialogueBox");
        DialogueBoxFactory.createErrorDialogueBox(dialogueBoxResource.getString("Integer"),
                                                  dialogueBoxResource.getString("CheckInput"));
    }
}
