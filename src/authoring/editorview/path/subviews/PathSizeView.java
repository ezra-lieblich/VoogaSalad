package authoring.editorview.path.subviews;

import java.util.ResourceBundle;

import authoring.editorview.path.PathEditorViewDelegate;
import authoring.utilityfactories.BoxFactory;
import authoring.utilityfactories.DialogueBoxFactory;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class PathSizeView {
	
	private VBox root;
	private int numColumns = 10;
	private int numRows = 10;
	
	private TextField columnsTextField;
	private HBox columnsBox;
	
	private TextField rowsTextField;
	private HBox rowsBox;
	private PathEditorViewDelegate delegate;
	
	
	
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
	
	public int getNumberOfColumns(){
		return numColumns;
	}
	
	public int getNumberOfRows(){
		return numRows;
	}
	
	public void setNumberOfColumns(int numColumns){
		this.numColumns = numColumns;
		columnsTextField.setText(Integer.toString(numColumns));
	}
	
	public void setNumberOfRows(int numRows){
		this.numRows = numRows;
		rowsTextField.setText(Integer.toString(numRows));
	}
	
	public void setDelegate(PathEditorViewDelegate delegate){
		this.delegate = delegate;
	}

	private void makeGridColumnsTextField(){
		columnsTextField = TextFieldFactory.makeTextField("", 
				e -> submitNumColumns(columnsTextField.getText()));
		columnsTextField.setMaxWidth(75);
		columnsBox = BoxFactory.createHBoxWithLabelandNode(pathResource.getString("ColumnTextField"), columnsTextField);
		
		root.getChildren().add(columnsBox);
		
	}
	
	private void submitNumColumns(String numColumnsString){
		try {
			numColumns = Integer.parseInt(numColumnsString);
			delegate.onUserEnteredNumberColumns(numColumns);
		}
		catch (NumberFormatException e){
			setNumberOfColumns(numColumns);
			Alert inputError = DialogueBoxFactory.createErrorDialogueBox("The number of columns must be an integer.", "Input error");
		}
	}
	
	
	
	private void makeGridRowsTextField(){
		rowsTextField = TextFieldFactory.makeTextField("", 
				e -> submitNumRows(rowsTextField.getText()));
		rowsTextField.setMaxWidth(75);
		rowsBox = BoxFactory.createHBoxWithLabelandNode(pathResource.getString("RowTextField"), rowsTextField);
		
		root.getChildren().add(rowsBox);
		
	}
	
	private void submitNumRows(String numRowsString){
		try {
			numRows = Integer.parseInt(numRowsString);
			delegate.onUserEnteredNumberRows(numRows);
		}
		catch (NumberFormatException e){
			setNumberOfRows(numRows);
			Alert inputError = DialogueBoxFactory.createErrorDialogueBox("The number of rows must be an integer.", "Input error");
			
			
		}
	}
	

}
