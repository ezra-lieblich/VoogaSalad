package authoring.editorview.gamesettings.subviews;

import java.util.ResourceBundle;
import authoring.editorview.gamesettings.GameSettingsAuthoringViewDelegate;
import authoring.editorview.gamesettings.IGameSettingsSetView;
import authoring.utilityfactories.BoxFactory;
import authoring.utilityfactories.GridFactory;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;


public class GameInitialLivesView implements IGameSettingsSetView {

    private TextField initialLivesField;
    private GameSettingsAuthoringViewDelegate delegate;
    private GridPane root;

    public GameInitialLivesView (ResourceBundle labelsResource) {
        createField(labelsResource);
    }

    @Override
    public Node getInstanceAsNode () {
        return root;
    }

    @Override
    public void setDelegate (GameSettingsAuthoringViewDelegate delegate) {
        this.delegate = delegate;
    }

    private void createField (ResourceBundle resource) {
        initialLivesField = TextFieldFactory.makeTextField("", 
        				e -> delegate.onUserEnteredGameLives(initialLivesField.getText()));
        
        initialLivesField.setPrefWidth(105);
        root = GridFactory.createRowWithLabelandNode(resource.getString("InitialLives"),
                                                      initialLivesField);
    }

    public void updateInitialLivesField (String initialLives) {
        initialLivesField.setText(initialLives);
    }

}
