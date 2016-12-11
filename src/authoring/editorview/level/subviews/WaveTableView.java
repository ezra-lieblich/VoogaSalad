package authoring.editorview.level.subviews;

import java.util.List;
import java.util.ResourceBundle;
import authoring.editorview.level.WaveObject;
import engine.level.wave.Wave;
import authoring.editorview.level.ILevelSetView;
import authoring.editorview.level.LevelAuthoringViewDelegate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class WaveTableView implements ILevelSetView {

    private TableView<WaveObject> waveTable;
    private TableColumn<WaveObject, String> waveNumberCol;
    private TableColumn<WaveObject, String> enemyNameCol;
    private TableColumn<WaveObject, String> numEnemiesCol;
    private TableColumn<WaveObject, String> enemyFrequencyCol;
    private TableColumn<WaveObject, String> pathCol;
    private TableColumn<WaveObject, String> timeDelayCol;
    private ObservableList<WaveObject> data;

    @SuppressWarnings("unused")
    private LevelAuthoringViewDelegate delegate;

    public WaveTableView (ResourceBundle labelsResource, int width) {
        waveTable = new TableView<WaveObject>();
        data = FXCollections.observableArrayList();
        waveTable.setPrefWidth(width);
        createTableColumns();
    }

    @SuppressWarnings("unchecked")
    private void createTableColumns () {
        waveNumberCol = new TableColumn<WaveObject, String>("Wave Number");
        enemyNameCol = new TableColumn<WaveObject, String>("Enemy Name");
        numEnemiesCol = new TableColumn<WaveObject, String>("Number of Enemies");
        enemyFrequencyCol = new TableColumn<WaveObject, String>("Enemy Frequency");
        pathCol = new TableColumn<WaveObject, String>("Path");
        timeDelayCol = new TableColumn<WaveObject, String>("Time Delay");
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
    public void setDelegate (LevelAuthoringViewDelegate delegate) {
        this.delegate = delegate;
    }

    private void setData (List<Wave> waves) {
        data.clear();
        for (Wave n : waves) {
            WaveObject temp =
                    new WaveObject(n.getId(), n.getEnemyID(), n.getEnemyCount(),
                                   n.getFrequency(), n.getPathID(), n.getStartTime());
            data.add(temp);
        }
    }

    @SuppressWarnings("unchecked")
    public void updateWaveTableView (List<Wave> waves) {
        setData(waves);
        waveTable.getColumns().clear();
        waveTable.setItems(data);
        waveTable.getColumns().addAll(waveNumberCol, enemyNameCol, numEnemiesCol,
                                      enemyFrequencyCol, pathCol, timeDelayCol);
        waveTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    public void updateWaveObject () {

    }

    public void createNewWave () {

    }

}
