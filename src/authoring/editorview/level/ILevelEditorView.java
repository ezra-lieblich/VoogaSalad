package authoring.editorview.level;

import authoring.editorview.IEditorView;
import javafx.scene.Node;

/**
 * 
 * Communicates with the model to indicate when a new level was chosen
 *
 */
public interface ILevelEditorView extends IEditorView {
	
	public void setDelegate(LevelEditorViewDelegate delegate);
}
