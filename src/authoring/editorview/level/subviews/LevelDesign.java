package authoring.editorview.level.subviews;

import javafx.scene.Node;
import javafx.scene.layout.VBox;

public class LevelDesign {
	
	private VBox root;
	
	
	public LevelDesign(){
		root = new VBox();
		makePathComboBox();
	}
	
	public Node getInstanceAsNode(){
		return root;
	}
	
	private void makePathComboBox(){
		
	}
	
}
