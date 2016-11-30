package authoring.editorview.level.subviews;

import java.util.ResourceBundle;

import authoring.editorview.level.LevelEditorViewDelegate;
import authoring.utilityfactories.BoxFactory;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class LevelNameView {

	
	private HBox root;
	private LevelEditorViewDelegate delegate;
	private TextField nameTextField;
	private String levelName;
	private int activeLevelID;
	
	private static final String RESOURCE_FILE_NAME = "resources/GameAuthoringLevels";	
	private ResourceBundle levelResource = ResourceBundle.getBundle(RESOURCE_FILE_NAME);
	
	
	public LevelNameView(){
		makeNameTextField();
	}
	
	public Node getInstanceAsNode(){
		return root;
	}
	
	public void setDelegate(LevelEditorViewDelegate delegate){
		this.delegate = delegate;
	}
	
	public void setActiveLevelId(int levelID){
		this.activeLevelID = levelID;
	}
	
	public void setLevelName(String name){
		this.levelName = name;
		nameTextField.setText(levelName);
	}
	
	private void makeNameTextField(){
		nameTextField = TextFieldFactory.makeTextField("", 
				e -> delegate.onUserEnteredLevelName(activeLevelID, nameTextField.getText()));
		nameTextField.setMaxWidth(75);
		root = BoxFactory.createHBoxWithLabelandNode(levelResource.getString("NameTextField"), nameTextField);
		
		
	}
	
	
}
