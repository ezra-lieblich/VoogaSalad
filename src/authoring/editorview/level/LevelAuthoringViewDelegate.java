package authoring.editorview.level;

import authoring.editorview.EditorViewDelegate;

/**
 * 
 * @author Kayla Schulz, Andrew Bihl, Diane Hadley
 *
 */
public interface LevelAuthoringViewDelegate extends EditorViewDelegate {

    public void onUserEnteredRewardScore (String score);

    public void onUserEnteredRewardMoney (String money);

    public void onUserEnteredRewardHealth (String health);

    public void onUserEnteredEditLevel (String level);

    public void onUserEnteredCreateLevel ();

    public void onUserEnteredTransitionTime (String time);

    public void onUserPressedAddEffect ();

    public void onUserSelectedLevel (int levelID);

    public void onUserEnteredAddWave ();

    public void onUserEnteredRemoveWave (String waveID);

    public void onUserEnteredEnemyFrequency (String waveID, String frequency);

    public void onUserEnteredEnemy (String waveID, String enemyID);

    public void onUserEnteredNumofEnemies (String waveID, String numEnemies);

    public void onUserEnteredSpawnPoint (String waveID, String spawnPoint);

    public void onUserEnteredWaveTimeDelay (String waveID, String timeDelay);

    public void onUserEnteredLevelImagePath (String path);

}
