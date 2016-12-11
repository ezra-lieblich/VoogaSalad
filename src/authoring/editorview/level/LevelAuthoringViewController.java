package authoring.editorview.level;

import java.util.ResourceBundle;
import authoring.editorview.EditorViewController;
import authoring.utilityfactories.DialogueBoxFactory;
import engine.enemy.EnemyManagerController;
import engine.level.LevelManagerController;


/**
 * 
 * @author Kayla Schulz
 * @author Diane Hadley
 *
 */
public class LevelAuthoringViewController extends EditorViewController
        implements LevelAuthoringViewDelegate {

    private ILevelUpdateView levelView;
    private LevelManagerController levelDataSource;
    private EnemyManagerController enemyDataSource;
    private int currentLevelID;
    private int currentWaveID;

    public LevelAuthoringViewController (int editorWidth, int editorHeight) {
        levelView = LevelAuthoringViewFactory.build(editorWidth, editorHeight);
        levelView.setDelegate(this);
        this.view = levelView;
    }

    public void setLevelDataSource (LevelManagerController source) {
        this.levelDataSource = source;
        this.levelDataSource.addTypeBankListener(this.levelView);
        onUserEnteredCreateLevel();
    }

    public void setEnemyDataSource (EnemyManagerController source) {
        this.enemyDataSource = source;
    }

    @Override
    public void onUserEnteredEditLevel (String level) {
        try {
            Integer.parseInt(level);
            currentLevelID = Integer.parseInt(level);
            currentLevelID = levelDataSource.createType(levelView);
        }
        catch (Exception e) {
            DialogueBoxFactory.createErrorDialogueBox("Not a correct level",
                                                      "Choose an appropriate integer");
        }
    }

    @Override
    public void onUserEnteredLevelName (String levelName) {
        levelDataSource.setName(currentLevelID, levelName);
    }

    @Override
    public void onUserEnteredCreateLevel () {
        currentLevelID = levelDataSource.createType(levelView);
        levelView.updateTransitionTime(levelDataSource.getTransitionTime(currentLevelID));
        levelView.updateRewardHealth(levelDataSource.getRewardHealth(currentLevelID));
        levelView.updateRewardMoney(levelDataSource.getRewardMoney(currentLevelID));
        levelView.updateRewardScore(levelDataSource.getRewardScore(currentLevelID));
        levelView.updateNameDisplay(levelDataSource.getName(currentLevelID));
        levelView.updateWaves(levelDataSource.getWaves(currentLevelID));
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
            createIntCheckDialogueBox();
        }
    }

    @Override
    public void onUserEnteredEnemyFrequency (String frequency) {
        try {
            Double.parseDouble(frequency);
            levelDataSource.setWaveFrequency(currentLevelID, currentWaveID,
                                             Double.parseDouble(frequency));
        }
        catch (NumberFormatException e) {
            createIntCheckDialogueBox();
        }
    }

    @Override
    public void onUserEnteredAddWave () {
        currentWaveID = levelDataSource.createWave(currentLevelID, levelView);
        // levelView.updateNumberOfEnemies(levelDataSource.getenem);
    }

    @Override
    public void onUserEnteredRemoveWave (int waveID) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUserEnteredRewardScore (String score) {
        try {
            Double.parseDouble(score);
            levelDataSource.setRewardScore(currentLevelID, Double.parseDouble(score));
        }
        catch (NumberFormatException e) {
            createIntCheckDialogueBox();
        }
    }

    @Override
    public void onUserEnteredRewardMoney (String money) {
        try {
            Double.parseDouble(money);
            levelDataSource.setRewardMoney(currentLevelID, Double.parseDouble(money));
        }
        catch (NumberFormatException e) {
            createIntCheckDialogueBox();
        }
    }

    @Override
    public void onUserEnteredRewardHealth (String health) {
        try {
            Double.parseDouble(health);
            levelDataSource.setRewardHealth(currentLevelID, Double.parseDouble(health));
        }
        catch (NumberFormatException e) {
            createIntCheckDialogueBox();
        }
    }

    private void createIntCheckDialogueBox () {
        ResourceBundle dialogueBoxResource = ResourceBundle.getBundle("resources/DialogueBox");
        DialogueBoxFactory.createErrorDialogueBox(dialogueBoxResource.getString("Integer"),
                                                  dialogueBoxResource.getString("CheckInput"));
    }

    @Override
    public void onUserEnteredEnemy (int enemyID) {
        levelDataSource.setWaveEnemy(currentLevelID, currentWaveID, enemyID);
    }

    @Override
    public void onUserEnteredNumofEnemies (String numEnemies) {
        try {
            Integer.parseInt(numEnemies);
            levelDataSource.setWaveCount(currentLevelID, currentWaveID,
                                         Integer.parseInt(numEnemies));
        }
        catch (NumberFormatException e) {
            createIntCheckDialogueBox();
        }
    }

    @Override
    public void onUserEnteredSpawnPoint (String spawnPoint) {
        try {
            Integer.parseInt(spawnPoint);
            levelDataSource.setWavePath(currentLevelID, currentWaveID,
                                        Integer.parseInt(spawnPoint));
        }
        catch (NumberFormatException e) {
            createIntCheckDialogueBox();
        }
    }

    @Override
    public void onUserEnteredWaveTimeDelay (String timeDelay) {
        try {
            Double.parseDouble(timeDelay);
            levelDataSource.setWaveDelay(currentLevelID, currentWaveID,
                                         Double.parseDouble(timeDelay));
        }
        catch (NumberFormatException e) {
            createIntCheckDialogueBox();
        }
    }
}
