package authoringview.path;

import gameplayer.view.GridGUI;
import javafx.scene.Node;


public class PathEditorView implements IPathEditorView {

    private GridGUI gridGUI;

    public PathEditorView (int aWidth, int aHeight) {
        this.gridGUI = new GridGUI(4, 4);
        this.gridGUI.init();
    }

    @Override
    public Node getInstanceAsNode () {
        return gridGUI.getGrid();
    }

    // TODO: One of the things we will need: setting the grid... # of columns and rows

}
