package authoring.editorview.gamesettings.subviews;

import java.util.ResourceBundle;

import authoring.editorview.NameView;

import authoring.editorview.gamesettings.GameSettingsEditorViewDelegate;
import authoring.editorview.gamesettings.IGameSettingsSetView;
import authoring.utilityfactories.BoxFactory;
import authoring.utilityfactories.TextFieldFactory;


/**
 * 
 * @author Diane Hadley
 * @author Kayla Schulz
 *
 */

public class GameNameView extends NameView implements IGameSettingsSetView {
	
    GameSettingsEditorViewDelegate delegate;

    public GameNameView (ResourceBundle settingsResource) {
    	super(settingsResource);

    }

    @Override
    public void setDelegate (GameSettingsEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    protected void makeNameTextField () {
        nameTextField = TextFieldFactory.makeTextField("",
                                                       e -> delegate
                                                               .onUserEnteredGameNames(nameTextField
                                                                       .getText()));
        root = BoxFactory.createHBoxWithLabelandNode(resource.getString("GameName"), nameTextField);

    }

}
