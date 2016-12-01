package authoring.editorview.level.subviews;

import java.util.ResourceBundle;
import authoring.editorview.level.ILevelSetView;
import authoring.editorview.level.LevelEditorViewDelegate;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class EnemyTableView implements ILevelSetView {

    private TableView<Object> enemyTable;
    private TableColumn enemyName;
    private TableColumn numEnemies;
    private TableColumn enemyFrequency;

    private LevelEditorViewDelegate delegate;

    public EnemyTableView (ResourceBundle labelsResource, int width) {
        enemyTable = new TableView<Object>();
        enemyTable.setPrefWidth(width);
        createTableColumns();
        enemyTable.getColumns().addAll(enemyName, numEnemies, enemyFrequency);
        enemyTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    private void createTableColumns () {
        enemyName = new TableColumn("Enemy Name");
        numEnemies = new TableColumn("Number of Enemies");
        enemyFrequency = new TableColumn("Enemy Frequency");
        enemyName.setEditable(false);
        numEnemies.setEditable(true);
        enemyFrequency.setEditable(true);
    }

    @Override
    public Node getInstanceAsNode () {
        return enemyTable;
    }

    @Override
    public void setDelegate (LevelEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

}
