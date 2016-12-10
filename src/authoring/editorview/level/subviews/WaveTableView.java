package authoring.editorview.level.subviews;

import java.util.List;
import java.util.ResourceBundle;
import authoring.editorview.level.WaveObject;
import authoring.editorview.level.ILevelSetView;
import authoring.editorview.level.LevelEditorViewDelegate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class WaveTableView implements ILevelSetView {

    private TableView<WaveObject> waveTable;
    private TableColumn waveNumberCol;
    private TableColumn enemyNameCol;
    private TableColumn numEnemiesCol;
    private TableColumn enemyFrequencyCol;
    private TableColumn pathCol;
    private TableColumn timeDelayCol;
    private ObservableList<WaveObject> data;

    private LevelEditorViewDelegate delegate;

    public WaveTableView (ResourceBundle labelsResource, int width) {
        waveTable = new TableView<WaveObject>();
        data = FXCollections.observableArrayList();
        waveTable.setPrefWidth(width);
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
        waveTable.getColumns().addAll(waveNumberCol, enemyNameCol, numEnemiesCol,
                                      enemyFrequencyCol, pathCol, timeDelayCol);
        waveTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    @Override
    public Node getInstanceAsNode () {
        return waveTable;
    }

    @Override
    public void setDelegate (LevelEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    private void setData (List<WaveObject> waves) {
        data.clear();
        for (WaveObject n : waves) {
            WaveObject temp =
                    new WaveObject(n.getWaveNumber(), n.getEnemyName(), n.getNumOfEnemies(),
                                   n.getEnemyFrequency(), n.getPath(), n.getTimeDelay());
            data.add(temp);
        }
    }

    public void updateWaveTableView (List<WaveObject> waves) {
        setData(waves);
        waveTable.getColumns().clear();
        waveTable.setItems(data);
        waveTable.getColumns().addAll(waveNumberCol, enemyNameCol, numEnemiesCol,
                                      enemyFrequencyCol, pathCol, timeDelayCol);
        waveTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    public void createNewWave () {

    }

}
