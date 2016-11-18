package gameauthoringenvironment.view.createscene;

import gameauthoringenvironment.view.createscene.editortabpane.IEditorTabPane;
import gameauthoringenvironment.view.createscene.editortabpane.EditorTabPaneFactory;
import gameauthoringenvironment.view.createscene.toolbar.IToolbar;
import gameauthoringenvironment.view.createscene.toolbar.ToolbarFactory;
import gameauthoringenvironment.view.path.IPathEditorView;
import gameauthoringenvironment.view.path.PathEditorViewFactory;
import gameauthoringenvironment.view.tower.ITowerEditorView;
import gameauthoringenvironment.view.tower.TowerEditorViewFactory;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class DesignScene implements IDesignScene {

    private Scene myScene;
    private Group myRoot;
    private IToolbar myToolbar;
    private IEditorTabPane mySideTabbedToolbar;
    private static final int SIZE = 700;
    private BorderPane authoringView;
    private ITowerEditorView towerView;
    private IPathEditorView pathView;
    
    public DesignScene() {
        towerView = TowerEditorViewFactory.build();
        pathView = PathEditorViewFactory.build(SIZE, SIZE);
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
