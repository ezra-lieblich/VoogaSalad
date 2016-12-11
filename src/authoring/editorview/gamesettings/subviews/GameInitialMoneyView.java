package authoring.editorview.gamesettings.subviews;

import java.util.ResourceBundle;
import authoring.editorview.gamesettings.GameSettingsAuthoringViewDelegate;
import authoring.editorview.gamesettings.IGameSettingsSetView;
import authoring.utilityfactories.GridFactory;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


public class GameInitialMoneyView implements IGameSettingsSetView {

    private TextField initialMoneyField;
    private GameSettingsAuthoringViewDelegate delegate;
    private GridPane root;

    public GameInitialMoneyView (ResourceBundle labelsResource) {
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
        initialMoneyField = TextFieldFactory.makeTextField("",
        		e -> delegate.onUserEnteredGameMoney(initialMoneyField.getText()));
        
        initialMoneyField.setPrefWidth(105);
        root = GridFactory.createRowWithLabelandNode(resource.getString("InitialMoney"), initialMoneyField);
        
    }

    public void updateInitialMoneyField (String initialLives) {
        initialMoneyField.setText(initialLives);
    }

}
