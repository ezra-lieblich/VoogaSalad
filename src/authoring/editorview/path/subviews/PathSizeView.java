package authoring.editorview.path.subviews;

import authoring.utilityfactories.BoxFactory;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;


public class PathSizeView {
	
	private HBox root;
	private int numColumns;
	
	private TextField columnsTextField;
	private HBox columnsBox;
	
	public PathSizeView(){
		this.root = new HBox();
		makeGridColumnsTextField();
		makeGridRowsTextField();
	}
	
	public Node getInstanceAsNode(){
		
		return root;
		
	}
	
	private void makeGridColumnsTextField(){
		columnsTextField = TextFieldFactory.makeTextField("Choose Path", 
				e -> setNumColumns(columnsTextField.getText()));
		columnsBox = BoxFactory.createHBoxWithTextField("hi", columnsTextField);
		
		root.getChildren().add(columnsBox);
		
	}
	
	private void setNumColumns(String numColumns){
		//TODO: catch user error
		this.numColumns = Integer.parseInt(numColumns);
	}
	
	private void makeGridRowsTextField(){
		
	}

}
