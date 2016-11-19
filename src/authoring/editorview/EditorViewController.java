package authoring.editorview;

import javafx.scene.Node;

public abstract class EditorViewController {
	protected IEditorView view;
	public Node getView(){
		return view.getInstanceAsNode();
	}
}
