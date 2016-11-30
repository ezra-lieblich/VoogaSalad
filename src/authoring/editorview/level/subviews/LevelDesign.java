package authoring.editorview.level.subviews;

import authoring.utilityfactories.ComboBoxFactory;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;

public class LevelDesign {
	
	private ComboBox<Object> pathComboBox;
	
	private VBox root;
	
	
	public LevelDesign(){
		root = new VBox();
		makePathComboBox();
	}
	
	public Node getInstanceAsNode(){
		return root;
	}
	
	private void makePathComboBox(){
		pathComboBox = ComboBoxFactory.makeComboBox("Select path",
				e -> , 
				options)
	}
	
}
