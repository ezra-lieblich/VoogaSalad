package authoring.editortabpane;

import authoring.editorview.INodeView;


/**
 * 
 * @author Kayla Schulz
 *
 */
public interface IEditorTabPane extends INodeView {

    public void setDelegate (EditorTabPaneDelegate delegate);

    public String getViewToOpen ();
}
