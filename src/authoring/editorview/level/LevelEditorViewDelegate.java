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

    public void onUserEnteredAddWave (WaveObject enemyData);

    public void onUserEnteredRemoveWave (int waveID);

    public void onUserEnteredEnemy (int enemyID);

    public void onUserEnteredNumofEnemies (int numEnemies);

    public void onUserEnteredSpawnPoint (int spawnPoint);

    public void onUserEnteredWaveTimeDelay (int timeDelay);

}
