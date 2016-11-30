package authoring.editorview.level;

import authoring.editorview.IEditorView;


/**
 * 
 * Communicates with the model to indicate when a new level was chosen
 *
 */
public interface ILevelSetView extends IEditorView {

    public void setDelegate (LevelEditorViewDelegate delegate);
}
