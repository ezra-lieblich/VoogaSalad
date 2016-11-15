package gameauthoringenvironment.view.createscene;

import gameauthoringenvironment.view.createscene.sidetabbedtoolbar.ISideTabbedToolbar;
import gameauthoringenvironment.view.createscene.sidetabbedtoolbar.SideTabbedToolbarFactory;
import gameauthoringenvironment.view.createscene.toolbar.IToolbar;
import gameauthoringenvironment.view.createscene.toolbar.ToolbarFactory;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class DesignScene implements IDesignScene {

    private Scene myScene;
    private Group myRoot;
    private IToolbar myToolbar;
    private ISideTabbedToolbar mySideTabbedToolbar;
    private static final int SIZE = 500;
    private BorderPane authoringView;
    
    public DesignScene() {
        myRoot = new Group();
        myScene = new Scene(myRoot);
        myToolbar = ToolbarFactory.build(SIZE, SIZE/20);
        mySideTabbedToolbar = SideTabbedToolbarFactory.build(SIZE, SIZE);
        authoringView = new BorderPane();
        myRoot.getChildren().add(authoringView);
        initScene();
    }
    
    private void initScene() {
        authoringView.setTop(myToolbar.getInstanceAsNode());
        authoringView.setRight(mySideTabbedToolbar.getInstanceAsNode());
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
