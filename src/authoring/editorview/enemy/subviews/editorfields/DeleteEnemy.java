package authoring.editorview.enemy.subviews.editorfields;

import java.util.ResourceBundle;
import authoring.editorview.enemy.EnemyAuthoringViewDelegate;
import authoring.editorview.enemy.IEnemySetView;
import authoring.utilityfactories.ButtonFactory;
import javafx.scene.Node;
import javafx.scene.control.Button;


public class DeleteEnemy implements IEnemySetView {

    private EnemyAuthoringViewDelegate delegate;
    private Button deleteEnemyButton;

    public DeleteEnemy (ResourceBundle labelsResource) {
        createButton(labelsResource);
    }

    @Override
    public void setDelegate (EnemyAuthoringViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Node getInstanceAsNode () {
        return deleteEnemyButton;
    }

    private void createButton (ResourceBundle labelsResource) {
        deleteEnemyButton =
                ButtonFactory.makeButton(labelsResource.getString("Delete"),
                                         e -> delegate.onUserPressedDeleteEnemy());
    }

}
