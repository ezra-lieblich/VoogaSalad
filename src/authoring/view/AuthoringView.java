package authoring.view;

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
    private IEditorTabPane mySideTabbedToolbar;
    private static final int SIZE = 700;
    private BorderPane authoringView;
    private ITowerEditorView towerView;
    private IPathEditorView pathView;
    private IGameSettingsEditorView gameSettingsView;
    
    public AuthoringView(int aWidth, int aHeight) {
        towerView = TowerEditorViewFactory.build();
        pathView = PathEditorViewFactory.build(SIZE, SIZE);
        gameSettingsView = GameSettingsEditorViewFactory.build(SIZE, SIZE);
        myRoot = new Group();
        myScene = new Scene(myRoot, SIZE, SIZE);
        myToolbar = ToolbarFactory.build(SIZE, SIZE/20);
        mySideTabbedToolbar = EditorTabPaneFactory.build(SIZE, SIZE);
        authoringView = new BorderPane();
        myRoot.getChildren().add(authoringView);
        initScene();
    }
    
    private void initScene() {
        authoringView.setTop(myToolbar.getInstanceAsNode());
        authoringView.setRight(mySideTabbedToolbar.getInstanceAsNode());
        authoringView.setCenter(createTempMidScreen());
    }
    
    private Pane createTempMidScreen() {
        Pane tempmid = new Pane();
        //change back here for tower
        Node pathViewNode = pathView.getInstanceAsNode();
        tempmid.getChildren().add(pathViewNode);
        tempmid.setMaxSize(SIZE*9/10, SIZE);
        tempmid.setPrefSize(SIZE*7.9/10, SIZE*19/20);
        return tempmid;
    }
    
    @Override
    public Scene getScene () {
        return myScene;
    }

    @Override
    public Group getMyRoot () {
        return myRoot;
    }

}
