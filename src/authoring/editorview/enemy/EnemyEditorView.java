package authoring.editorview.enemy;

import authoring.editorview.enemy.subviews.EnemyImageBank;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;


/**
 * @author Diane Hadley
 * @author Kayla Schulz
 */

public class EnemyEditorView implements IEnemyEditorView {
    private EnemyEditorViewDelegate delegate;
    private BorderPane enemyEditorView;
    private EnemyImageBank enemyBank;

    public EnemyEditorView () {
        enemyEditorView = new BorderPane();
        enemyBank = new EnemyImageBank();
        setBorderPane();
    }
    
    private void setBorderPane () {
        enemyEditorView.setLeft(enemyBank.getInstanceAsNode());
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
        enemyBank.setDelegate(delegate);
    }

}
