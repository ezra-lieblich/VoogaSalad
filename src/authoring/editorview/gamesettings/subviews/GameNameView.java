package authoring.editorview.gamesettings.subviews;

import java.util.ResourceBundle;
import authoring.editorview.EditorNameView;
import authoring.editorview.gamesettings.GameSettingsAuthoringViewDelegate;
import authoring.editorview.gamesettings.IGameSettingsSetView;
import authoring.utilityfactories.BoxFactory;
import authoring.utilityfactories.GridFactory;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;


/**
 * 
 * @author Diane Hadley
 * @author Kayla Schulz
 *
 */

public class GameNameView implements IGameSettingsSetView {

	private GridPane root;
    private TextField nameTextField;

    private ResourceBundle resource;
	
    private GameSettingsAuthoringViewDelegate delegate;

    public GameNameView (ResourceBundle settingsResource) {
        this.resource = settingsResource;
        makeNameTextField();
    	//super(settingsResource);

    }

    @Override
    public void setDelegate (GameSettingsAuthoringViewDelegate delegate) {
        this.delegate = delegate;
    }

    protected void makeNameTextField () {
        nameTextField = TextFieldFactory.makeTextField("", e -> delegate.onUserEnteredGameNames(nameTextField.getText()));
        nameTextField.setMaxWidth(105);
        
        root = GridFactory.createRowWithLabelandNode(resource.getString("GameName"), nameTextField);
        
//        root = BoxFactory.createHBoxWithLabelandNode(, nameTextField);

    }

    @Override
    public Node getInstanceAsNode () {
        return root;
    }

    public void updateName (String name) {
        nameTextField.setText(name);
    }

    
}
