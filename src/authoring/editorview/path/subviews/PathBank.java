package authoring.editorview.path.subviews;

import javafx.scene.Node;
import javafx.scene.control.ScrollPane;

public class PathBank {
	
	private ScrollPane pathBank;
	
	public PathBank(){
		this.pathBank = new ScrollPane();
	}
	
	public Node getInstanceAsNode () {
		return pathBank;
	}
	
	public void updatePathBank(){
		
	}

}
