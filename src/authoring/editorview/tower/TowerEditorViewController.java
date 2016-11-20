package authoring.editorview.tower;

import authoring.editorview.EditorViewController;

public class TowerEditorViewController extends EditorViewController {

	public TowerEditorViewController(int editorWidth, int editorHeight){
		view = TowerEditorViewFactory.build(editorWidth, editorHeight);
	}
}
