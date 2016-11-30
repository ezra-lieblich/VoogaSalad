package authoring.editorview.level;

public interface LevelEditorViewDelegate {

    public void onUserEnteredRewardPoints (String points);

    public void onUserEnteredRewardMoney (String money);

    public void onUserEnteredRewardHealth (String health);

    public void onUserEnteredEditLevel ();

    public void onUserEnteredLevelName (String levelName);

    public void onUserEnteredCreateLevel ();

    public void onUserEnteredDeleteLevel ();

    public void onUserEnteredTranstitionTime (String time);

    public void onUserEnteredEnemyFrequency (String frequency);

    public void onUserEnteredAddEnemy (int enemyId, int numEnemies);

    public void onUserEnteredRemoveEnemy (int enemyID);

}
