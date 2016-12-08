package authoring.editorview.level;

/**
 * 
 * @author Kayla Schulz, Andrew Bihl, Diane Hadley
 *
 */
public interface LevelEditorViewDelegate {

    public void onUserEnteredRewardScore (String score);

    public void onUserEnteredRewardMoney (String money);

    public void onUserEnteredRewardHealth (String health);

    public void onUserEnteredEditLevel (String level);

    public void onUserEnteredLevelName (String levelName);

    public void onUserEnteredCreateLevel ();

    public void onUserEnteredDeleteLevel ();

    public void onUserEnteredTransitionTime (String time);

    public void onUserEnteredEnemyFrequency (String frequency);

    public void onUserEnteredAddEnemy (WaveObject enemyData);

    public void onUserEnteredRemoveEnemy (int enemyID);

}
