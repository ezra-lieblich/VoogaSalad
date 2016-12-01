package authoring.editorview.level.subviews;

import java.util.List;
import java.util.ResourceBundle;
import authoring.editorview.level.ILevelSetView;
import authoring.editorview.level.LevelEditorViewDelegate;
import authoring.editorview.path.NameIdPair;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class EnemyTableView implements ILevelSetView {

    private TableView<Enemy> enemyTable;
    private TableColumn enemyNameCol;
    private TableColumn numEnemiesCol;
    private TableColumn enemyFrequencyCol;
    private ObservableList<Enemy> data;

    private LevelEditorViewDelegate delegate;

    public EnemyTableView (ResourceBundle labelsResource, int width) {
        enemyTable = new TableView<Enemy>();
        data = FXCollections.observableArrayList();
        enemyTable.setPrefWidth(width);
        createTableColumns();
    }

    private void createTableColumns () {
        enemyNameCol = new TableColumn("Enemy Name");
        numEnemiesCol = new TableColumn("Number of Enemies");
        enemyFrequencyCol = new TableColumn("Enemy Frequency");
        enemyNameCol.setEditable(false);
        numEnemiesCol.setEditable(true);
        enemyFrequencyCol.setEditable(true);
        enemyNameCol.setCellValueFactory(
                                      new PropertyValueFactory<Enemy, String>("enemyName"));
        numEnemiesCol.setCellValueFactory(new PropertyValueFactory<Enemy, String>("numOfEnemies"));
        enemyFrequencyCol.setCellValueFactory(new PropertyValueFactory<Enemy, String>("enemyFrequency"));
    }

    @Override
    public Node getInstanceAsNode () {
        return enemyTable;
    }

    @Override
    public void setDelegate (LevelEditorViewDelegate delegate) {
        this.delegate = delegate;
    }
    
    private void setData(List<NameIdPair> enemies) {
        data.clear();
        for (NameIdPair n: enemies) {
            Enemy temp = new Enemy (n.getName(), "0", "0");
            data.add(temp);
        }
    }

    public void updateEnemyTableView(List<NameIdPair> enemies) {
        setData(enemies);
        enemyTable.getColumns().clear();
        enemyTable.setItems(data);
        enemyTable.getColumns().addAll(enemyNameCol, numEnemiesCol, enemyFrequencyCol);
        enemyTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }
    
    public static class Enemy {
        
        private final SimpleStringProperty enemyName;
        private final SimpleStringProperty enemyFrequency;
        private final SimpleStringProperty numOfEnemies;
 
        private Enemy(String enemyName, String enemyFrequency, String numOfEnemies) {
            this.enemyName = new SimpleStringProperty(enemyName);
            this.enemyFrequency = new SimpleStringProperty(enemyFrequency);
            this.numOfEnemies = new SimpleStringProperty(numOfEnemies);
        }
 
        public String getEnemyName() {
            return enemyName.get();
        }
 
        public void setEnemyName(String enemyName) {
            this.enemyName.set(enemyName);
        }
 
        public String getEnemyFrequency() {
            return enemyFrequency.get();
        }
 
        public void setEnemyFrequency(String enemyFrequency) {
            this.enemyFrequency.set(enemyFrequency);
        }
 
        public String getNumOfEnemies() {
            return numOfEnemies.get();
        }
 
        public void setNumOfEnemies(String numOfEnemies) {
            this.numOfEnemies.set(numOfEnemies);
        }
    }

}
