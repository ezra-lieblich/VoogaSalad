package gameauthoringenvironment.view.path;

import gameplayer.view.GridGUI;
import javafx.scene.Node;
import javafx.scene.control.TextField;


public class PathView implements IPathView {

    private GridGUI gridGUI;

    public PathView (int aWidth, int aHeight) {
        this.gridGUI = new GridGUI(8, 8);
        this.gridGUI.init();
    }

    @Override
    public Node getInstanceAsNode () {
        return gridGUI.getGrid();
    }
    
    private void makeTextField(String label) {
        //HBox
        //TextField textField = new TextField();
    }
    
    //TODO: One of the things we will need: setting the grid... # of columns and rows

}
