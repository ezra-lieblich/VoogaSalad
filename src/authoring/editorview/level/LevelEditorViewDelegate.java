package authoring.editorview.level;

public interface LevelEditorViewDelegate {
	
	public void onUserEnteredRewardPoints (int levelID, double points);

    public void onUserEnteredRewardMoney (int levelID, double money);

    public void onUserEnteredRewardHealth (int levelID, double health);
    
    public void onUserEnteredEditLevel (int levelID);
    
    public void onUserEnteredLevelName (int levelID, String levelName);
    
    public void onUserEnteredCreateLevel ();
    
    public void onUserEnteredDeleteLevel ();
    
    public void onUserEnteredTranstitionTime (int levelID, double time);
    
    public void onUserEnteredEnemyFrequency (int levelID, double frequency);
    
    public void onUserEnteredAddEnemy (int levelID, int enemyId, int numEnemies);
    
    public void onUserEnteredRemoveEnemy (int levelID, int enemyID);
    
    
}
