package authoring.editorview.level.subviews;

import java.util.List;
import java.util.ResourceBundle;
import authoring.editorview.level.WaveObject;
import engine.level.wave.Wave;
import engine.level.wave.WaveString;
import engine.level.wave.WaveStringType;
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
    private TableColumn<WaveObject, Integer> waveNumberCol;
    private TableColumn<WaveObject, String> enemyNameCol;
    private TableColumn<WaveObject, Integer> numEnemiesCol;
    private TableColumn<WaveObject, Double> enemyFrequencyCol;
    private TableColumn<WaveObject, String> pathCol;
    private TableColumn<WaveObject, Double> timeDelayCol;
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
        waveNumberCol = new TableColumn<WaveObject, Integer>("Wave Number");
        enemyNameCol = new TableColumn<WaveObject, String>("Enemy Name");
        numEnemiesCol = new TableColumn<WaveObject, Integer>("Number of Enemies");
        enemyFrequencyCol = new TableColumn<WaveObject, Double>("Enemy Frequency");
        pathCol = new TableColumn<WaveObject, String>("Path");
        timeDelayCol = new TableColumn<WaveObject, Double>("Time Delay");
        waveNumberCol.setCellValueFactory(
                                          new PropertyValueFactory<WaveObject, Integer>("id"));
        enemyNameCol.setCellValueFactory(
                                         new PropertyValueFactory<WaveObject, String>("enemy"));
        numEnemiesCol
                .setCellValueFactory(new PropertyValueFactory<WaveObject, Integer>("count"));
        enemyFrequencyCol
                .setCellValueFactory(new PropertyValueFactory<WaveObject, Double>("frequency"));
        pathCol
                .setCellValueFactory(new PropertyValueFactory<WaveObject, String>("path"));
        timeDelayCol
                .setCellValueFactory(new PropertyValueFactory<WaveObject, Double>("startTime"));

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

    private void setData (List<WaveString> waves) {
        data.removeAll(data);
        for (WaveString n : waves) {
            WaveObject temp =
                    new WaveObject(n.getID(), n.getEnemy(), n.getCount(),
                                   n.getFrequency(), n.getPath(), n.getStartTime());
            data.add(temp);
        }
    }

    @SuppressWarnings("unchecked")
    public void updateWaveTableView (List<WaveString> waves) {
        setData(waves);
        waveTable.getColumns().clear();

        waveTable.getColumns().addAll(waveNumberCol, enemyNameCol, numEnemiesCol,
                                      enemyFrequencyCol, pathCol, timeDelayCol);
        waveTable.setItems(data);
        waveTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

}
