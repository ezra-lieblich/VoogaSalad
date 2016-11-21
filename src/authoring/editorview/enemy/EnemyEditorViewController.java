package authoring.editorview.enemy;

import authoring.editorview.EditorViewController;

public class EnemyEditorViewController extends EditorViewController implements EnemyEditorViewDelegate {

	public EnemyEditorViewController(int editorWidth, int editorHeight){
		IEnemyEditorView myView = EnemyEditorViewFactory.build(editorWidth, editorHeight);
		myView.setDelegate(this);
		this.view = myView;
	}
}
