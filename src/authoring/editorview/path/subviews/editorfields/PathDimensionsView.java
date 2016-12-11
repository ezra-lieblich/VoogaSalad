package authoring.editorview.path.subviews.editorfields;

import java.util.ResourceBundle;


import authoring.editorview.path.IPathSetView;

import authoring.editorview.path.PathAuthoringViewDelegate;
import authoring.utilityfactories.BoxFactory;
import authoring.utilityfactories.DialogueBoxFactory;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;



public class PathDimensionsView implements IPathSetView{
	
	private VBox root;
	private int dimensions;
	
	private TextField dimensionsTextField;
	private HBox dimensionsBox;
	private PathAuthoringViewDelegate delegate;
	
	
	
	private static final int BOX_SPACING = 10;
	
	private static final String RESOURCE_FILE_NAME = "resources/GameAuthoringPath";	
	private ResourceBundle pathResource = ResourceBundle.getBundle(RESOURCE_FILE_NAME);
	
	public PathDimensionsView(){
		this.root = new VBox(BOX_SPACING);
		makeGridDimensionsTextField();
	}
	
	@Override
	public Node getInstanceAsNode(){		
		return root;
		
	}
	
	@Override
	public void setDelegate(PathAuthoringViewDelegate delegate){
		this.delegate = delegate;
	}
	
	public int getGridDimensions(){
		return dimensions;
	}
	
	public void setGridDimensions(int dimensions){
		this.dimensions = dimensions;
		dimensionsTextField.setText(Integer.toString(dimensions));
	}
	
	

	private void makeGridDimensionsTextField(){
		dimensionsTextField = TextFieldFactory.makeTextField("", 
				e -> submitGridDimensions(dimensionsTextField.getText()));
		dimensionsTextField.setMaxWidth(75);
		dimensionsBox = BoxFactory.createHBoxWithLabelandNode(pathResource.getString("DimensionsTextField"), dimensionsTextField);
		
		root.getChildren().add(dimensionsBox);
		
	}
	
	private void submitGridDimensions(String gridDimensionsString){
		try {
			dimensions = Integer.parseInt(gridDimensionsString);
			delegate.onUserEnteredGridDimensions(dimensions);
		}
		catch (NumberFormatException e){
			setGridDimensions(dimensions);
			Alert inputError = DialogueBoxFactory.createErrorDialogueBox("The dimensions of the grid must be an integer.", "Input error");
		}
	}


}
