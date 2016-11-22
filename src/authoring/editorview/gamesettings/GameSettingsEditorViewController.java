package authoring.editorview.gamesettings;

import authoring.editorview.EditorViewController;

public class GameSettingsEditorViewController extends EditorViewController implements GameSettingsEditorViewDelegate {
	private GameSettingsDataSource gameSettingsDataSource;
	
	public GameSettingsEditorViewController(int editorWidth, int editorHeight){
		IGameSettingsEditorView myView = GameSettingsEditorViewFactory.build(editorWidth, editorHeight);
		myView.setDelegate(this);
		this.view = myView;
	}
	
	public void setGameSettingsDataSource(GameSettingsDataSource source){
		this.gameSettingsDataSource = source;
	}
}
