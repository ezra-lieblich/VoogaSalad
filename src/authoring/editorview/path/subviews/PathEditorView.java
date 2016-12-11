package authoring.editorview.path.subviews;

import authoring.editorview.path.IPathSetView;
import authoring.editorview.path.PathAuthoringViewDelegate;
import authoring.editorview.path.subviews.editorfields.PathImageView;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

public class PathEditorView implements IPathSetView {

	private VBox root;
	
	private PathImageView pathImageView;
	
    public PathEditorView (int size) {
    	root = new VBox(10);
    	
    	this.pathImageView = new PathImageView();

    }

	@Override
	public Node getInstanceAsNode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDelegate(PathAuthoringViewDelegate delegate) {
		pathImageView.setDelegate(delegate);
		
	}
    
    

}
