package authoring.toolbar;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;


public class Toolbar implements IToolbar {

    private ToolBar toolbar;

    public Toolbar (int aWidth, int aHeight) {
    	
    	
        this.toolbar = new ToolBar(
                                new Button("New"),
                                new Button("Open"));
    }

    @Override
    public Node getInstanceAsNode () {
        return toolbar;
    }

}
