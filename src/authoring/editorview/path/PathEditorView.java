package authoring.editorview.path;

import authoring.editorview.path.subviews.PathBank;
import gameplayer.view.GridGUI;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;


public class PathEditorView implements IPathEditorView {

    private GridGUI gridGUI;
    private PathEditorViewDelegate delegate;
    private PathBank pathBank;
    private BorderPane pathView;
    

    public PathEditorView (int aWidth, int aHeight) {
        this.pathView = new BorderPane();
    	this.gridGUI = new GridGUI(8, 8);
        this.gridGUI.init();
        this.pathBank = new PathBank();
        pathView.setLeft(pathBank.getInstanceAsNode());
     
    }

    @Override
    public Node getInstanceAsNode () {
        return gridGUI.getGrid();
    }

    // TODO: One of the things we will need: setting the grid... # of columns and rows
    
    @Override
    public void setDelegate (PathEditorViewDelegate delegate) {
        this.delegate = delegate;
        
    }

}
