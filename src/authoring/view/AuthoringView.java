package authoring.view;

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

    private Scene myScene;
    private Group myRoot;
    private IToolbar myToolbar;
    private IEditorTabPane editorTabPane;
    private static final int SIZE = 700;
    private BorderPane authoringView;
    private Pane editorView;

    public AuthoringView (int editorWidth, int edit) {
        myRoot = new Group();
        myScene = new Scene(myRoot, SIZE, SIZE);
        myToolbar = ToolbarFactory.build(SIZE, SIZE / 20);
        editorTabPane = EditorTabPaneFactory.build(SIZE, SIZE);
        authoringView = new BorderPane();
        myRoot.getChildren().add(authoringView);
        initScene();
    }

    @Override
    public IEditorTabPane getMySideTabbedToolbar () {
        return editorTabPane;
    }

    private void initScene () {
        authoringView.setTop(myToolbar.getInstanceAsNode());
        authoringView.setRight(editorTabPane.getInstanceAsNode());
        authoringView.setCenter(editorView);
    }

    private void createEditorView (Node editor) {
        editorView = new Pane();
        editorView.setPrefSize(editor.prefWidth(0), editor.prefHeight(0));
        editorView.setMaxSize(editor.maxWidth(0), editor.maxHeight(0));

    }

    @Override
    public Scene getScene () {
        return myScene;
    }

    @Override
    public Group getMyRoot () {
        return myRoot;
    }

    @Override
    public void setEditorView (Node editor) {
        if (editorView == null) {
            createEditorView(editor);
        }
        editorView.getChildren().clear();
        editorView.getChildren().add(editor);
    }

    @Override
    public void setEditorTabPaneDelegate (EditorTabPaneDelegate delegate) {
        editorTabPane.setDelegate(delegate);
    }

}