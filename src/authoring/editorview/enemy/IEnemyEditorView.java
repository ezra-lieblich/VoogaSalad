package authoring.editorview.enemy;

import authoring.editorview.IEditorView;
import javafx.scene.Node;

/**
 * The Enemy View interface will detail the components of the enemy creation. The interface
 * determines a portion of our internal API.
 *
 */
public interface IEnemyEditorView extends IEditorView {
	public void setDelegate(EnemyEditorViewDelegate delegate);
}
