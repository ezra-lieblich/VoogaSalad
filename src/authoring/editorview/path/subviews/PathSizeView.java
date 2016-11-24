package authoring.editorview.path.subviews;

import java.util.ResourceBundle;

import authoring.utilityfactories.BoxFactory;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class PathSizeView {
	
	private VBox root;
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
		this.root = new VBox(BOX_SPACING);
		makeGridColumnsTextField();
		makeGridRowsTextField();
	}
	
	public Node getInstanceAsNode(){
		
		return root;
		
	}
	
	private void makeGridColumnsTextField(){
		columnsTextField = TextFieldFactory.makeTextField(pathResource.getString("NeedIntegerValue"), 
				e -> setNumColumns(columnsTextField.getText()));
		columnsBox = BoxFactory.createHBoxWithTextField(pathResource.getString("ColumnTextField"), columnsTextField);
		
		root.getChildren().add(columnsBox);
		
	}
	
	private void setNumColumns(String numColumns){
		//TODO: catch user error
		this.numColumns = Integer.parseInt(numColumns);
	}
	
	private void makeGridRowsTextField(){
		rowsTextField = TextFieldFactory.makeTextField(pathResource.getString("NeedIntegerValue"), 
				e -> setNumRows(rowsTextField.getText()));
		rowsBox = BoxFactory.createHBoxWithTextField(pathResource.getString("RowTextField"), rowsTextField);
		
		root.getChildren().add(rowsBox);
		
	}
	
	private void setNumRows(String numRows){
		//TODO: catch user error
		this.numRows = Integer.parseInt(numRows);
	}

}
