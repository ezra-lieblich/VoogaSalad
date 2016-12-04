package authoring.editorview.level.subviews;

import java.util.List;
import java.util.ResourceBundle;
import authoring.editorview.level.WaveObject;
import authoring.editorview.level.ILevelSetView;
import authoring.editorview.level.LevelEditorViewDelegate;
import authoring.editorview.path.NameIdPair;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class EnemyTableView implements ILevelSetView {

    private TableView<WaveObject> enemyTable;
    private TableColumn waveNumberCol;
    private TableColumn enemyNameCol;
    private TableColumn numEnemiesCol;
    private TableColumn enemyFrequencyCol;
    private TableColumn pathCol;
    private TableColumn timeDelayCol;
    private ObservableList<WaveObject> data;

    private LevelEditorViewDelegate delegate;

    public EnemyTableView (ResourceBundle labelsResource, int width) {
        enemyTable = new TableView<WaveObject>();
        data = FXCollections.observableArrayList();
        enemyTable.setPrefWidth(width);
        createTableColumns();
    }

    private void createTableColumns () {
        waveNumberCol = new TableColumn("Wave Number");
        enemyNameCol = new TableColumn("Enemy Name");
        numEnemiesCol = new TableColumn("Number of Enemies");
        enemyFrequencyCol = new TableColumn("Enemy Frequency");
        pathCol = new TableColumn("Path");
        timeDelayCol = new TableColumn("Time Delay");
        waveNumberCol.setEditable(false);
        enemyNameCol.setEditable(true);
        numEnemiesCol.setEditable(true);
        enemyFrequencyCol.setEditable(true);
        waveNumberCol.setCellValueFactory(
                                          new PropertyValueFactory<WaveObject, String>("waveNumber"));
        enemyNameCol.setCellValueFactory(
                                         new PropertyValueFactory<WaveObject, String>("enemyName"));
        numEnemiesCol
                .setCellValueFactory(new PropertyValueFactory<WaveObject, String>("numOfEnemies"));
        enemyFrequencyCol
                .setCellValueFactory(new PropertyValueFactory<WaveObject, String>("enemyFrequency"));
        pathCol
                .setCellValueFactory(new PropertyValueFactory<WaveObject, String>("path"));
        timeDelayCol
                .setCellValueFactory(new PropertyValueFactory<WaveObject, String>("timeDelay"));
    }

    @Override
    public Node getInstanceAsNode () {
        return enemyTable;
    }

    @Override
    public void setDelegate (LevelEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    private void setData (List<NameIdPair> enemies) {
        data.clear();
        for (NameIdPair n : enemies) {
            // WaveObject temp = new WaveObject(n.getName(), "0", "0");
            // data.add(temp);
        }
    }

    public void updateEnemyTableView (List<NameIdPair> enemies) {
        setData(enemies);
        enemyTable.getColumns().clear();
        enemyTable.setItems(data);
        enemyTable.getColumns().addAll(waveNumberCol, enemyNameCol, numEnemiesCol,
                                       enemyFrequencyCol, pathCol, timeDelayCol);
        enemyTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

}
