package authoring.editorview.gamesettings.subviews;

import java.util.ResourceBundle;
import authoring.editorview.gamesettings.GameSettingsEditorViewDelegate;
import authoring.editorview.gamesettings.IGameSettingsSetView;
import authoring.utilityfactories.BoxFactory;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;


public class GameInitialMoneyView implements IGameSettingsSetView {

    private TextField initialMoneyField;
    private GameSettingsEditorViewDelegate delegate;
    private HBox hbox;

    public GameInitialMoneyView (ResourceBundle labelsResource) {
        createField(labelsResource);
    }

    @Override
    public Node getInstanceAsNode () {
        return hbox;
    }

    @Override
    public void setDelegate (GameSettingsEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    private void createField (ResourceBundle levelResource) {
        initialMoneyField =
                TextFieldFactory.makeTextField("",
                                               e -> delegate
                                                       .onUserEnteredGameMoney(initialMoneyField
                                                               .getText()));
        hbox =
                BoxFactory.createHBoxWithLabelandNode(levelResource.getString("InitialMoney"),
                                                      initialMoneyField);
    }

    public void updateInitialMoneyField (String initialLives) {
        initialMoneyField.setText(initialLives);
    }

}
