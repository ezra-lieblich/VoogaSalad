package authoring.editorview.path;

import authoring.editorview.path.subviews.PathBank;
import gameplayer.view.GridGUI;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;


public class PathEditorView implements IPathEditorView {
	private PathEditorViewDelegate delegate;
    private GridGUI gridGUI;
    private PathBank pathBank;
    private BorderPane pathView;
    

    public PathEditorView (int aWidth, int aHeight) {
        this.pathView = new BorderPane();
    	this.gridGUI = new GridGUI(50, 50);
        this.gridGUI.init();
        this.pathBank = new PathBank();
        pathView.setLeft(pathBank.getInstanceAsNode());
     
    }

    @Override
    public Node getInstanceAsNode () {
        return gridGUI.getGrid();
    }

	@Override
	public void setDelegate(PathEditorViewDelegate delegate) {
		this.delegate = delegate;
	}

    // TODO: One of the things we will need: setting the grid... # of columns and rows
    

}
