package gameauthoringenvironment.view.createscene;

import javafx.scene.Group;
import javafx.scene.Scene;

public class DesignScene implements IDesignScene {

    private Scene myScene;
    private Group myRoot;
    
    public DesignScene() {
        myRoot = new Group();
        myScene = new Scene(myRoot);
    }
    
    private void initScene() {

    }
    
    @Override
    public Scene getScene () {
        // TODO Auto-generated method stub
        return myScene;
    }

    @Override
    public Group getMyRoot () {
        // TODO Auto-generated method stub
        return null;
    }

}
