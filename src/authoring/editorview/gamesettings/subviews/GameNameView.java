package authoring.editorview.gamesettings.subviews;

import authoring.editorview.gamesettings.GameSettingsEditorViewDelegate;
import authoring.utilityfactories.BoxFactory;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;


/**
 * 
 * @author Diane Hadley
 * @author Kayla Schulz
 *
 */
public class GameNameView {

    private HBox hbox;
    private TextField nameTextField;
    GameSettingsEditorViewDelegate delegate;

    public GameNameView () {
        makeNameTextField();

    }

    public Node getInstanceAsNode () {
        return hbox;
    }

    public void setDelegate (GameSettingsEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    private void makeNameTextField () {
        nameTextField = TextFieldFactory.makeTextField("",
                                                       e -> delegate
                                                               .onUserEnteredGameNames(nameTextField
                                                                       .getText()));
        hbox = BoxFactory.createHBoxWithLabelandNode("Choose game name:", nameTextField);

    }

}
