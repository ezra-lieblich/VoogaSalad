package authoring.editorview.gamesettings.subviews;

import authoring.editorview.gamesettings.GameSettingsEditorViewDelegate;
import authoring.utilityfactories.BoxFactory;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class GameNameView {
	
	private HBox root;
	private TextField nameTextField;
	GameSettingsEditorViewDelegate delegate;
	
	public GameNameView(){
		makeNameTextField();
		
	}
	
	public Node getInstanceAsNode(){
		return root;
	}
	
	public void setDelegate (GameSettingsEditorViewDelegate delegate) {
        this.delegate = delegate;
    }
	
	private void makeNameTextField(){
		nameTextField = TextFieldFactory.makeTextField("", 
				e -> delegate.onUserEnteredGameNames(nameTextField.getText()));
		root = BoxFactory.createHBoxWithLabelandNode("Choose game name:", nameTextField);
		
	}
	
	

}
