package authoring.editorview.path.subviews.editorfields;

import java.util.ResourceBundle;

import authoring.editorview.NameView;
import authoring.editorview.path.IPathSetView;
import authoring.editorview.path.PathEditorViewDelegate;
import authoring.utilityfactories.BoxFactory;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.layout.HBox;

public class PathNameView extends NameView implements IPathSetView {
	
	private HBox root;
	private PathEditorViewDelegate delegate;
		
	private static final String RESOURCE_FILE_NAME = "resources/GameAuthoringPath";	
	private ResourceBundle pathResource = ResourceBundle.getBundle(RESOURCE_FILE_NAME);
	
	public PathNameView(){
		makeNameTextField();
		
	}
	
	@Override
	public Node getInstanceAsNode(){
		return root;
		
	}
	
	@Override
	public void setDelegate(PathEditorViewDelegate delegate){
		this.delegate = delegate;
	}
	
	private void makeNameTextField(){
		nameTextField = TextFieldFactory.makeTextField("", 
				e -> delegate.onUserEnteredPathName(nameTextField.getText()));
		nameTextField.setMaxWidth(100);
		root = BoxFactory.createHBoxWithLabelandNode(pathResource.getString("NameTextField"), nameTextField);
	}
	
	

}
