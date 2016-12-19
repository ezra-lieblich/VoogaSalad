package authoring.editorview.enemy;

import java.util.Map;
import java.util.ResourceBundle;
import authoring.editorview.ListDataSource;
import authoring.editorview.enemy.subviews.EnemyEditorView;
import authoring.editorview.enemy.subviews.EnemyImageBank;
import authoring.editorview.enemy.subviews.editorfields.EnemyImageView;
import javafx.scene.Node;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;


/**
 * @author Kayla Schulz
 * @author Diane Hadley
 * 
 */

public class EnemyAuthoringView implements EnemySetView {
    @SuppressWarnings("unused")
    private EnemyAuthoringViewDelegate delegate;
    private GridPane enemyView;
    private EnemyImageBank enemyBank;
    private EnemyImageView enemyImage;
    private EnemyEditorView enemyEditorView;

    public EnemyAuthoringView (Map<String, Class<?>> myClasses) {
        String ENEMY_EFFECT_RESOURCE_PATH = "resources/GameAuthoringEnemy";
        ResourceBundle labelsResource = ResourceBundle.getBundle(ENEMY_EFFECT_RESOURCE_PATH);

        enemyView = new GridPane();
        enemyBank = new EnemyImageBank(labelsResource);
        enemyImage = new EnemyImageView(labelsResource);
        enemyEditorView =
                new EnemyEditorView(labelsResource, myClasses);
        buildView();
    }

    private void buildView () {

        ColumnConstraints bankColumn = new ColumnConstraints();
        bankColumn.setMinWidth(150);

        ColumnConstraints editorColumn = new ColumnConstraints();
        editorColumn.setPrefWidth(300);

        ColumnConstraints previewColumn = new ColumnConstraints();

        RowConstraints fullRow = new RowConstraints();

        fullRow.setMinHeight(700);

        enemyView.getColumnConstraints().addAll(bankColumn, editorColumn, previewColumn);
        enemyView.getRowConstraints().add(fullRow);

        enemyView.add(enemyBank.getInstanceAsNode(), 0, 0);
        enemyView.add(enemyEditorView.getInstanceAsNode(), 1, 0);
        enemyView.add(enemyImage.getInstanceAsNode(), 2, 0);
    }

    @Override
    public Node getInstanceAsNode () {
        return enemyView;
    }

    @Override
    public void setDelegate (EnemyAuthoringViewDelegate delegate) {
        this.delegate = delegate;
        enemyBank.setDelegate(delegate);
        enemyEditorView.setDelegate(delegate);
        enemyImage.setDelegate(delegate);
    }

    @Override
    public void setEnemyListDataSource (ListDataSource source) {
        this.enemyBank.setListDataSource(source);
    }

}
