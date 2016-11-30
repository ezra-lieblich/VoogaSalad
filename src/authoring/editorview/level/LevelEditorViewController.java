package authoring.editorview.level;

import authoring.editorview.EditorViewController;
import engine.level.LevelManagerController;

public class LevelEditorViewController extends EditorViewController implements LevelEditorViewDelegate {
	
	private ILevelUpdateView levelView;
	private LevelManagerController levelDataSource;
	
	public LevelEditorViewController(int editorWidth, int editorHeight){
		ILevelEditorView myView = LevelEditorViewFactory.build(editorWidth, editorHeight);
		myView.setDelegate(this);
		this.view = myView;
	}
	
	public void setLevelDataSource(LevelManagerController source){
		this.levelDataSource = source;
	}


	@Override
	public void onUserEnteredEditLevel(int levelID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUserEnteredLevelName(int levelID, String levelName) {
		levelDataSource.setName(levelID, levelName);
		
	}

	@Override
	public void onUserEnteredCreateLevel() {
		int levelID = levelDataSource.createType(levelView);
		
	}

	@Override
	public void onUserEnteredDeleteLevel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUserEnteredTranstitionTime(int levelID, double time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUserEnteredEnemyFrequency(int levelID, double frequency) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUserEnteredAddEnemy(int levelID, int enemyId, int numEnemies) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUserEnteredRemoveEnemy(int levelID, int enemyID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUserEnteredRewardPoints(int levelID, double points) {
		levelDataSource.setRewardScore(levelID, points);
		
	}

	@Override
	public void onUserEnteredRewardMoney(int levelID, double money) {
		levelDataSource.setRewardMoney(levelID, money);
		
	}

	@Override
	public void onUserEnteredRewardHealth(int levelID, double health) {
		levelDataSource.setRewardHealth(levelID, health);
		
	}
}
