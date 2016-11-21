package authoring.editorview.path;

import gameplayer.view.GridGUI;
import javafx.scene.Node;


public class PathEditorView implements IPathEditorView {
	private PathEditorViewDelegate delegate;
    private GridGUI gridGUI;

    public PathEditorView (int aWidth, int aHeight) {
        this.gridGUI = new GridGUI(8, 8);
        this.gridGUI.init();
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
