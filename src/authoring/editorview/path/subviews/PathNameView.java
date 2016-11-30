package authoring.editorview.path.subviews;

import java.util.ResourceBundle;

import authoring.editorview.path.PathEditorViewDelegate;
import authoring.utilityfactories.BoxFactory;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class PathNameView {
	
	private HBox root;
	private TextField nameTextField;
	private String name;
	private PathEditorViewDelegate delegate;
	private int activePathID;
	
	
	private static final String RESOURCE_FILE_NAME = "resources/GameAuthoringPath";	
	private ResourceBundle pathResource = ResourceBundle.getBundle(RESOURCE_FILE_NAME);
	
	public PathNameView(){
		makeNameTextField();
		
	}
	
	public Node getInstanceAsNode(){
		return root;
		
	}
	
	public void setDelegate(PathEditorViewDelegate delegate){
		this.delegate = delegate;
	}
	
	public void setActivePathId(int pathID){
		this.activePathID = pathID;
	}
	
	private void makeNameTextField(){
		nameTextField = TextFieldFactory.makeTextField("", 
				e -> delegate.onUserEnteredPathName(activePathID, nameTextField.getText()));
		nameTextField.setMaxWidth(75);
		root = BoxFactory.createHBoxWithLabelandNode(pathResource.getString("NameTextField"), nameTextField);
	}
	
	public void setName(String name){
		this.name = name;
		nameTextField.setText(name);
		
	}
	

}
