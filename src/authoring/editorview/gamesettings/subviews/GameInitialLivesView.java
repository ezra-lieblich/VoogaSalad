package authoring.editorview.gamesettings.subviews;

import java.util.ResourceBundle;
import authoring.editorview.gamesettings.GameSettingsEditorViewDelegate;
import authoring.editorview.gamesettings.IGameSettingsSetView;
import authoring.utilityfactories.BoxFactory;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;


public class GameInitialLivesView implements IGameSettingsSetView {

    private TextField initialLivesField;
    private GameSettingsEditorViewDelegate delegate;
    private HBox hbox;

    public GameInitialLivesView (ResourceBundle labelsResource) {
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
        initialLivesField =
                TextFieldFactory.makeTextField("",
                                               e -> delegate
                                                       .onUserEnteredGameLives(initialLivesField
                                                               .getText()));
        hbox =
                BoxFactory.createHBoxWithLabelandNode(levelResource.getString("TransitionTime"),
                                                      initialLivesField);
    }

    public void updateInitialLivesField (String initialLives) {
        initialLivesField.setText(initialLives);
    }

}
