package authoring.editorview.gamesettings;

import authoring.editorview.EditorViewController;
import authoring.editorview.level.ILevelEditorView;
import engine.settings.GameModeManagerController;

public class GameSettingsEditorViewController extends EditorViewController implements GameSettingsEditorViewDelegate {
	
	private IGameUpdateView gameView;
	private GameModeManagerController gameSettingsDataSource;
	
	public GameSettingsEditorViewController(int editorWidth, int editorHeight){
		IGameSettingsEditorView myView = GameSettingsEditorViewFactory.build(editorWidth, editorHeight);
		myView.setDelegate(this);
		this.view = myView;
	}
	
	public void setGameSettingsDataSource(GameModeManagerController source){
		this.gameSettingsDataSource = source;
		this.gameSettingsDataSource.addTypeBankListener(this.gameView);
	}

	@Override
	public void onUserEnteredGameLives(String lives) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUserEnteredGameNames(String name) {
		// TODO Auto-generated method stub
		
	}
}
