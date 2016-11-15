package gameauthoringenvironment.view.createscene;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class DesignScene implements IDesignScene {

    private Scene myScene;
    private Group myRoot;
    private IToolbar myToolbar;
    private static final int SIZE = 500;
    private Pane authoringView;
    
    public DesignScene() {
        myRoot = new Group();
        myScene = new Scene(myRoot);
        myToolbar = ToolbarFactory.build(SIZE, SIZE/20);
        authoringView = new Pane();
        initScene();
    }
    
    private void initScene() {
        authoringView.getChildren().add(myToolbar.getInstanceAsNode());
        myRoot.getChildren().add(myRoot);
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
