package authoring.editorview.level;

import authoring.editorview.EditorViewController;

public class LevelEditorViewController extends EditorViewController implements LevelEditorViewDelegate {
	
	public LevelEditorViewController(int editorWidth, int editorHeight){
		ILevelEditorView myView = LevelEditorViewFactory.build(editorWidth, editorHeight);
		myView.setDelegate(this);
		this.view = myView;
	}
}
