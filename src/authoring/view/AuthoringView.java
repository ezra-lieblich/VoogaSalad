package authoring.view;

import java.util.List;
import authoring.editortabpane.EditorTabPaneDelegate;
import authoring.editortabpane.EditorTabPaneFactory;
import authoring.editortabpane.IEditorTabPane;
import authoring.toolbar.IToolbar;
import authoring.toolbar.ToolbarFactory;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class AuthoringView implements IAuthoringView {

    private Scene scene;
    private Group root;
    private IToolbar toolbar;
    private IEditorTabPane editorTabPane;
    // TODO: Get this magic value out
    private static final int SIZE = 700;
    private BorderPane authoringView;
    private Pane editorView;

    public AuthoringView (int editorWidth, int edit) {
        this.root = new Group();
        this.scene = new Scene(root, SIZE, SIZE);
        this.toolbar = ToolbarFactory.build(SIZE, SIZE / 20);
        this.authoringView = new BorderPane();
        
        root.getChildren().add(authoringView);
        initScene();
    }

    @Override
    public IEditorTabPane getMySideTabbedToolbar () {
        return editorTabPane;
    }

    private void initScene () {
        authoringView.setTop(toolbar.getInstanceAsNode());
        authoringView.setCenter(editorView);
        
        
    }

    private void createEditorView (Node editor) {
        editorView = new Pane();
        editorView.setPrefHeight(SIZE);
        editorView.setPrefWidth(SIZE);

    }

    @Override
    public Scene getScene () {
        return scene;
    }

    @Override
    public void setEditorView (Node editor) {
        if (editorView == null) {
            createEditorView(editor);
        }

        editorView.getChildren().clear();
        editorView.getChildren().add(editor);
        authoringView.setCenter(editorView);
    }

    @Override
    public void createEditorTabPane (List<String> tabs) {
        editorTabPane = EditorTabPaneFactory.build(SIZE, SIZE, tabs);
        authoringView.setRight(editorTabPane.getInstanceAsNode());
    }

    @Override
    public void setEditorTabPaneDelegate (EditorTabPaneDelegate delegate) {
        editorTabPane.setDelegate(delegate);
    }

}
