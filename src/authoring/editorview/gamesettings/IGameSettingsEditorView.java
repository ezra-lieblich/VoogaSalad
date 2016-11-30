package authoring.editorview.gamesettings;

import authoring.editorview.IEditorView;

public interface IGameSettingsEditorView extends IEditorView {
	
	public void setDelegate(GameSettingsEditorViewDelegate delegate);
}
