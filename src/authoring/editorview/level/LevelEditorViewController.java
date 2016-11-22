package authoring.editorview.level;

import authoring.editorview.EditorViewController;

public class LevelEditorViewController extends EditorViewController implements LevelEditorViewDelegate {
	
	private LevelDataSource levelDataSource;
	
	public LevelEditorViewController(int editorWidth, int editorHeight){
		ILevelEditorView myView = LevelEditorViewFactory.build(editorWidth, editorHeight);
		myView.setDelegate(this);
		this.view = myView;
	}
	
	public void setLevelDataSource(LevelDataSource source){
		this.levelDataSource = source;
	}
}
