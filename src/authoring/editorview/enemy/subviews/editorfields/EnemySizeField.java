package authoring.editorview.enemy.subviews.editorfields;

import java.util.ResourceBundle;
import authoring.editorview.enemy.EnemyEditorViewDelegate;
import authoring.editorview.enemy.IEnemyEditorView;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.control.TextField;


public class EnemySizeField implements IEnemyEditorView {

    private EnemyEditorViewDelegate delegate;
    private TextField enemySizeField;

    public EnemySizeField (ResourceBundle labelsResource) {
        enemySizeField =
                TextFieldFactory.makeTextField(labelsResource.getString("EnterInt"),
                                               e -> delegate
                                                       .onUserEnteredEnemySize(enemySizeField
                                                               .getText()));
    }

    @Override
    public void setDelegate (EnemyEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Node getInstanceAsNode () {
        return enemySizeField;
    }

    public void updateEnemySize (String enemySize) {
        enemySizeField.setText(enemySize);
    }

}
