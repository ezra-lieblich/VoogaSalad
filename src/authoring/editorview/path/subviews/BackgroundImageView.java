package authoring.editorview.path.subviews;

import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class BackgroundImageView {
	
	private HBox root = new HBox();
	
	public Node getInstanceAsNode(){
		Text hello = new Text("hello");
		root.getChildren().add(hello);
		return root;
		
	}

}
