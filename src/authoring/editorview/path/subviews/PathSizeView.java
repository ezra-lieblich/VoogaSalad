package authoring.editorview.path.subviews;

import java.util.ResourceBundle;

import authoring.utilityfactories.BoxFactory;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class PathSizeView {
	
	private HBox root;
	private int numColumns;
	private int numRows;
	
	private TextField columnsTextField;
	private HBox columnsBox;
	
	private TextField rowsTextField;
	private HBox rowsBox;
	
	private static final int BOX_SPACING = 10;
	
	private static final String RESOURCE_FILE_NAME = "resources/GameAuthoringPath";	
	private ResourceBundle pathResource = ResourceBundle.getBundle(RESOURCE_FILE_NAME);
	
	public PathSizeView(){
		this.root = new HBox(BOX_SPACING);
		makeGridColumnsTextField();
		makeGridRowsTextField();
	}
	
	public Node getInstanceAsNode(){
		
		return root;
		
	}
	
	private void makeGridColumnsTextField(){
		columnsTextField = TextFieldFactory.makeTextField("1", 
				e -> setNumColumns(columnsTextField.getText()));
		columnsTextField.setMaxWidth(75);
		columnsBox = BoxFactory.createHBoxWithTextField(pathResource.getString("ColumnTextField"), columnsTextField);
		
		root.getChildren().add(columnsBox);
		
	}
	
	private void setNumColumns(String numColumns){
		//TODO: catch user error
		this.numColumns = Integer.parseInt(numColumns);
	}
	
	private void makeGridRowsTextField(){
		rowsTextField = TextFieldFactory.makeTextField("1", 
				e -> setNumRows(rowsTextField.getText()));
		rowsTextField.setMaxWidth(75);
		rowsBox = BoxFactory.createHBoxWithTextField(pathResource.getString("RowTextField"), rowsTextField);
		
		root.getChildren().add(rowsBox);
		
	}
	
	private void setNumRows(String numRows){
		//TODO: catch user error
		this.numRows = Integer.parseInt(numRows);
	}

}
