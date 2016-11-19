package authoring.editorview.enemy;

import authoring.editorview.EditorViewController;

public class EnemyEditorViewController extends EditorViewController {

	public EnemyEditorViewController(int editorWidth, int editorHeight){
		view = EnemyEditorViewFactory.build(editorWidth, editorHeight);
	}
}
