package authoring.editorview.level.subviews;

import java.util.ResourceBundle;
import authoring.editorview.level.ILevelSetView;
import authoring.editorview.level.LevelEditorViewDelegate;
import authoring.utilityfactories.BoxFactory;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;


public class LevelEnemyFrequencyField implements ILevelSetView {

    private TextField enemyFrequencyField;
    private LevelEditorViewDelegate delegate;
    private HBox hbox;

    public LevelEnemyFrequencyField (ResourceBundle levelResource) {
        enemyFrequencyField =
                TextFieldFactory.makeTextField("",
                                               e -> delegate
                                                       .onUserEnteredEnemyFrequency(enemyFrequencyField
                                                               .getText()));
        hbox =
                BoxFactory.createHBoxWithLabelandNode(levelResource.getString("EnemyFrequency"),
                                                      enemyFrequencyField);
    }

    @Override
    public void setDelegate (LevelEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Node getInstanceAsNode () {
        return hbox;
    }

    public void updateEnemyFrequencyField (String enemyFrequency) {
        enemyFrequencyField.setText(enemyFrequency);
    }

}
