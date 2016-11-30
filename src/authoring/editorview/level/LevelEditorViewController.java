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
	public void onUserEnteredRewardPoints(String points) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUserEnteredRewardMoney(String money) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUserEnteredRewardHealth(String health) {
		// TODO Auto-generated method stub
		
	}
}
