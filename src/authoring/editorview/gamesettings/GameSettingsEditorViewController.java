package authoring.editorview.gamesettings;

import authoring.editorview.EditorViewController;

public class GameSettingsEditorViewController extends EditorViewController implements GameSettingsEditorViewDelegate {

	public GameSettingsEditorViewController(int editorWidth, int editorHeight){
		IGameSettingsEditorView myView = GameSettingsEditorViewFactory.build(editorWidth, editorHeight);
		myView.setDelegate(this);
		this.view = myView;
	}
}
