package gameauthoringenvironment.view.createscene;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;

public class Toolbar implements IToolbar {

    private ToolBar myToolbar;
    
    public Toolbar(int aWidth, int aHeight) {
        myToolbar = new ToolBar(new Button("Open"));
    }

    @Override
    public Node getInstanceAsNode () {
        return myToolbar;
    }
    
}
