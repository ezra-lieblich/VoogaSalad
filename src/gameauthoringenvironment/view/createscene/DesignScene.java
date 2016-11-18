package gameauthoringenvironment.view.createscene;

import gameauthoringenvironment.view.createscene.sidetabbedtoolbar.ISideTabbedToolbar;
import gameauthoringenvironment.view.createscene.sidetabbedtoolbar.SideTabbedToolbarFactory;
import gameauthoringenvironment.view.createscene.toolbar.IToolbar;
import gameauthoringenvironment.view.createscene.toolbar.ToolbarFactory;
import gameauthoringenvironment.view.path.IPathView;
import gameauthoringenvironment.view.path.PathViewFactory;
import gameauthoringenvironment.view.tower.ITowerView;
import gameauthoringenvironment.view.tower.TowerViewFactory;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class DesignScene implements IDesignScene {

    private Scene myScene;
    private Group myRoot;
    private IToolbar myToolbar;
    private ISideTabbedToolbar mySideTabbedToolbar;
    private static final int SIZE = 700;
    private BorderPane authoringView;
    private ITowerView towerView;
    private IPathView pathView;
    
    public DesignScene() {
        towerView = TowerViewFactory.build();
        pathView = PathViewFactory.build(SIZE, SIZE);
        myRoot = new Group();
        myScene = new Scene(myRoot, SIZE, SIZE);
        myToolbar = ToolbarFactory.build(SIZE, SIZE/20);
        mySideTabbedToolbar = SideTabbedToolbarFactory.build(SIZE, SIZE);
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
