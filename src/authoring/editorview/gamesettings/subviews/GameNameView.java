package authoring.editorview.gamesettings.subviews;

import java.util.ResourceBundle;
import authoring.editorview.NameView;
import authoring.editorview.enemy.EnemyEditorViewDelegate;
import authoring.editorview.enemy.IEnemySetView;
import authoring.editorview.gamesettings.GameSettingsEditorViewDelegate;
import authoring.editorview.gamesettings.IGameSettingsSetView;
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
public class GameNameView extends NameView implements IGameSettingsSetView {

    private GameSettingsEditorViewDelegate delegate;

    public GameNameView (ResourceBundle labelsResource) {
        super(labelsResource);
    }

    @Override
    protected void makeNameTextField () {
        nameTextField =
                TextFieldFactory.makeTextField(resource.getString("EnterString"),
                                               e -> delegate.onUserEnteredGameNames(nameTextField
                                                       .getText()));
        hbox = BoxFactory.createHBoxWithLabelandNode(resource.getString("NameTextField"),
                                                     nameTextField);
    }

    @Override
    public void setDelegate (GameSettingsEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

}
