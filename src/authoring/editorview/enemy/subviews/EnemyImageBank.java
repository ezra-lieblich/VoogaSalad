package authoring.editorview.enemy.subviews;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import authoring.editorview.ListCellData;
import authoring.editorview.enemy.EnemyEditorViewDelegate;
import authoring.utilityfactories.ButtonFactory;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 * 
 * @author Kayla Schulz, Andrew Bihl
 *
 */
public class EnemyImageBank implements ChangeListener<Number> {
    private EnemyListDataSource dataSource;
    private EnemyEditorViewDelegate delegate;
    private ListView<Node> enemyListView;

    private ObservableList<Node> enemies;
    private ArrayList<Integer> enemyIDs;

    private final int CELL_HEIGHT = 60;
    private final int CELL_WIDTH = 60;
    private final int ENEMY_BANK_WIDTH = 120;
    private final String DEFAULT_ENEMY_IMAGE_PATH = "./Images/questionmark.png";

    // TODO: Keep mapping in array of enemy IDs to list indices in order to be able to delete and
    // maintain order

    public EnemyImageBank () {
        enemies = FXCollections.observableArrayList();
        enemyIDs = new ArrayList<Integer>();
        enemyListView = new ListView<Node>();
        enemyListView.setItems(enemies);
        enemyListView.setPrefWidth(ENEMY_BANK_WIDTH);
        enemyListView.getSelectionModel().selectedIndexProperty().addListener(this);
        Button newEnemyButton = ButtonFactory.makeButton("New Enemy", e -> {
            delegate.onUserPressedCreateEnemy();
        });
        this.enemies.add(newEnemyButton);
    }

    public void setListDataSource (EnemyListDataSource source) {
        this.dataSource = source;
    }

    public Node getInstanceAsNode () {
        return enemyListView;
    }

    public void setDelegate(EnemyEditorViewDelegate delegate) {
    	this.delegate = delegate;
    }
    
    public void updateEnemyBank (List<Integer> activeEnemies) {
        this.enemies.remove(1, enemies.size() - 1);
        enemyIDs = new ArrayList<Integer>();
        for (int i = 0; i < activeEnemies.size(); i++) {
            ListCellData cellData = dataSource.getCellDataForEnemy(activeEnemies.get(i));
            Node cell = createCellFromData(cellData);
            enemies.add(cell);
            enemyIDs.set(enemies.size()-1, cellData.getId());
        }
    }

    private Node createCellFromData (ListCellData data) {
        ImageView cell = new ImageView();
        String imageFilePath = data.getImagePath();
        if (imageFilePath.equals(null) || imageFilePath.length() < 1) {
            imageFilePath = DEFAULT_ENEMY_IMAGE_PATH;
        }
        File file = new File(data.getImagePath());
        Image image = new Image(file.toURI().toString());
        cell.setImage(image);
        cell.setPreserveRatio(true);
        cell.setFitHeight(CELL_HEIGHT);
        cell.setFitWidth(CELL_WIDTH);
        return cell;
    }
//
//    private void addImageToBank (Image image) {
//        ImageView cell = new ImageView();
//        cell.setImage(image);
//        cell.setPreserveRatio(true);
//        cell.setFitHeight(CELL_HEIGHT);
//        cell.setFitWidth(CELL_WIDTH);
//        enemies.add(cell);
//    }

	@Override
	public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
		int selectedEnemy = this.enemyIDs.get(newValue.intValue());
		this.delegate.onUserSelectedEnemy(selectedEnemy);
	}
}
