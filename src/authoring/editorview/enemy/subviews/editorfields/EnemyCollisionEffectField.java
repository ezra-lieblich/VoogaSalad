package authoring.editorview.enemy.subviews.editorfields;

import java.util.ResourceBundle;
import authoring.editorview.enemy.EnemyEditorViewDelegate;
import authoring.editorview.enemy.IEnemySetView;
import authoring.utilityfactories.ComboBoxFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class EnemyCollisionEffectField implements IEnemySetView {

    private ComboBox<Object> enemyReactionsBox;
    private EnemyEditorViewDelegate delegate;
    private ResourceBundle labelsResource;

    public EnemyCollisionEffectField (ResourceBundle labelsResource) {
        this.labelsResource = labelsResource;
        ObservableList<Object> collisionOptions = setList();
        createBox(collisionOptions);
    }

    private ObservableList<Object> setList () {
        ObservableList<Object> collisionOptions =
                FXCollections.observableArrayList("Immediate Death", "Remove a life");
        return collisionOptions;
    }

    private void createBox (ObservableList<Object> collisionOptions) {
        enemyReactionsBox =
                ComboBoxFactory.makeComboBox(labelsResource.getString("EnterString"),
                                             e -> delegate
                                                     .onUserEnteredEnemyCollisionEffect((String) enemyReactionsBox
                                                             .getValue()),
                                             collisionOptions);
    }

    @Override
    public void setDelegate (EnemyEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Node getInstanceAsNode () {
        return enemyReactionsBox;
    }

    public void updateEnemyReaction (String enemyReaction) {
        enemyReactionsBox.setValue(enemyReaction);
    }

}
