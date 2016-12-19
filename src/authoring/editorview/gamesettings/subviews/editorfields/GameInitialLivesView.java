package authoring.editorview.gamesettings.subviews.editorfields;

import java.util.ResourceBundle;

import authoring.editorview.TextFieldView;
import authoring.editorview.gamesettings.GameSettingsAuthoringViewDelegate;
import authoring.editorview.gamesettings.GameSettingsSetView;
import authoring.utilityfactories.DialogueBoxFactory;
import authoring.utilityfactories.GridFactory;
import authoring.utilityfactories.TextFieldFactory;


public class GameInitialLivesView extends TextFieldView implements GameSettingsSetView {

    private int initialLives;
    private GameSettingsAuthoringViewDelegate delegate;

    public GameInitialLivesView (ResourceBundle resource) {
    	super(resource);
    }

    @Override
    public void setDelegate (GameSettingsAuthoringViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
	protected void makeTextField(ResourceBundle labelsResource) {
    	textField = TextFieldFactory.makeTextField("",
                                                           e -> submitInitialLives(textField
                                                                   .getText()));

    	textField.setPrefWidth(105); // TODO magic number
        root = GridFactory.createRowWithLabelandNode(resource.getString("InitialLives"),
        		textField, 125);
    }

    public void updateInitialLives (int lives) {
        initialLives = lives;
        textField.setText(Integer.toString(lives));
    }

    private void submitInitialLives (String livesString) {
        try {
            initialLives = Integer.parseInt(livesString);
            delegate.onUserEnteredGameLives(initialLives);
        }
        catch (NumberFormatException e) {
            updateInitialLives(initialLives);
           
            DialogueBoxFactory.createErrorDialogueBox(
                                                      "The number of lives must be an integer.",
                                                      "Input error");
            
        }
    }

}
