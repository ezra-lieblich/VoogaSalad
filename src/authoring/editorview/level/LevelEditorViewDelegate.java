package authoring.editorview.level;

public interface LevelEditorViewDelegate {
	
	public void onUserEnteredRewardPoints (String points);

    public void onUserEnteredRewardMoney (String money);

    public void onUserEnteredRewardHealth (String health);
}
