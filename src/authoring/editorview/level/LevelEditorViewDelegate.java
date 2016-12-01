package authoring.editorview.level;

public interface LevelEditorViewDelegate {

    public void onUserEnteredRewardPoints (String points);

    public void onUserEnteredRewardMoney (String money);

    public void onUserEnteredRewardHealth (String health);

    public void onUserEnteredEditLevel (String level);

    public void onUserEnteredLevelName (String levelName);

    public void onUserEnteredCreateLevel ();

    public void onUserEnteredDeleteLevel ();

    public void onUserEnteredTransitionTime (String time);

    public void onUserEnteredEnemyFrequency (String frequency);

    public void onUserEnteredAddEnemy (String enemyID, String numEnemies);

    public void onUserEnteredRemoveEnemy (int enemyID);

}
