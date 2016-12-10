package authoring.editorview.enemy.subviews.editorfields;

import java.util.ResourceBundle;
import authoring.editorview.TextFieldView;
import authoring.editorview.enemy.EnemyEditorViewDelegate;
import authoring.editorview.enemy.IEnemySetView;
import authoring.utilityfactories.BoxFactory;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.control.TextField;


public class EnemySizeField extends TextFieldView implements IEnemySetView {

    private EnemyEditorViewDelegate delegate;
    private TextField enemySizeField;

    public EnemySizeField (ResourceBundle labelsResource) {
        super(labelsResource);
    }

    @Override
    public void setDelegate (EnemyEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Node getInstanceAsNode () {
        return hbox;
    }

    @Override
    public void updateField (String newData) {
        enemySizeField.setText(newData);
    }

    @Override
    protected void makeTextField (ResourceBundle labelsResource) {
        enemySizeField =
                TextFieldFactory.makeTextField(labelsResource.getString("EnterInt"),
                                               e -> delegate
                                                       .onUserEnteredEnemySize(enemySizeField
                                                               .getText()));
        hbox = BoxFactory.createHBoxWithLabelandNode(labelsResource.getString("Size"),
                                                     enemySizeField);
    }

}
