package authoring.editorview.level;

import authoring.editorview.IEditorView;


/**
 * 
 * Communicates with the model to indicate when a new level was chosen
 * @author Diane Hadley
 * @author Kayla Schulz
 *
 */
public interface ILevelSetView extends IEditorView {

    public void setDelegate (LevelAuthoringViewDelegate delegate);
}
