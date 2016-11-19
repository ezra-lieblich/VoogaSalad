package authoring.view;

import authoring.editortabpane.EditorTabPaneDelegate;
import authoring.editortabpane.EditorTabPaneFactory;
import authoring.editortabpane.IEditorTabPane;
import authoring.editorview.gamesettings.GameSettingsEditorViewFactory;
import authoring.editorview.gamesettings.IGameSettingsEditorView;
import authoring.editorview.path.IPathEditorView;
import authoring.editorview.path.PathEditorViewFactory;
import authoring.editorview.tower.ITowerEditorView;
import authoring.editorview.tower.TowerEditorViewFactory;
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
    
    public AuthoringView(int aWidth, int aHeight) {
        myRoot = new Group();
        myScene = new Scene(myRoot, SIZE, SIZE);
        myToolbar = ToolbarFactory.build(SIZE, SIZE/20);
        editorTabPane = EditorTabPaneFactory.build(SIZE, SIZE);
        authoringView = new BorderPane();
        editorView = createEditor();
        myRoot.getChildren().add(authoringView);
        initScene();
    }
    
    @Override
    public IEditorTabPane getMySideTabbedToolbar () {
        return editorTabPane;
    }

    private void initScene() {
        authoringView.setTop(myToolbar.getInstanceAsNode());
        authoringView.setRight(editorTabPane.getInstanceAsNode());
        authoringView.setCenter(editorView);
    }
    
    private Pane createEditor() {
        Pane editor = new Pane();
        //change back here for tower
        editor.setMaxSize(SIZE*9/10, SIZE);
        editor.setPrefSize(SIZE*7.9/10, SIZE*19/20);
        return editor;
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
	public void setEditorView(Node editor) {
		editorView.getChildren().clear();
		editorView.getChildren().add(editor);
	}

	@Override
	public void setEditorTabPaneDelegate(EditorTabPaneDelegate delegate) {
		editorTabPane.setDelegate(delegate);
	}

}
