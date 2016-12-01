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
    private TableColumn enemyFrequency;

    private LevelEditorViewDelegate delegate;

    public EnemyTableView (ResourceBundle labelsResource) {
        enemyTable = new TableView<Object>();
        enemyName = new TableColumn("Enemy Name");
        enemyFrequency = new TableColumn("Enemy Frequency");
        enemyName.setEditable(false);
        enemyFrequency.setEditable(true);
        enemyTable.getColumns().addAll(enemyName, enemyFrequency);
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
