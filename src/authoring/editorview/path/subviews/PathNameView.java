package authoring.editorview.path.subviews;

import java.util.ResourceBundle;

import authoring.utilityfactories.BoxFactory;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class PathNameView {
	
	private HBox root;
	private TextField nameTextField;
	private String name;
	
	private static final String RESOURCE_FILE_NAME = "resources/GameAuthoringPath";	
	private ResourceBundle pathResource = ResourceBundle.getBundle(RESOURCE_FILE_NAME);
	
	public PathNameView(){
		makeNameTextField();
		
	}
	
	public Node getInstanceAsNode(){
		return root;
		
	}
	
	private void makeNameTextField(){
		nameTextField = TextFieldFactory.makeTextField("Path 1", 
				e -> setName(nameTextField.getText()));
		nameTextField.setMaxWidth(75);
		root = BoxFactory.createHBoxWithLabelandNode(pathResource.getString("ColumnTextField"), nameTextField);
	}
	
	private void setName(String name){
		this.name = name;
	}
	

}
