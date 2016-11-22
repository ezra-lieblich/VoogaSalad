package authoring.editorview.enemy;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;


/**
 * @author Diane Hadley
 */

public class EnemyEditorView implements IEnemyEditorView {
    private EnemyEditorViewDelegate delegate;
    private BorderPane enemyEditorView;

    public EnemyEditorView () {
        enemyEditorView = new BorderPane();

    }

    @Override
    public Node getInstanceAsNode () {
        return enemyEditorView;
    }

    public void getEnemySetter () {
        Group designEnemy = new Group();
        enemyEditorView.setCenter(designEnemy);
    }

    @Override
    public void setDelegate (EnemyEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

}
