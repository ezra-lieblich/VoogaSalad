package authoring.editorview;

import javafx.scene.Node;


public abstract class EditorViewController {

    protected IEditorView view;

    protected DataSource dataSource;

    public Node getView () {
        return view.getInstanceAsNode();
    }
}
