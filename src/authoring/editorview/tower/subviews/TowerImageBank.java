package authoring.editorview.tower.subviews;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import authoring.editorview.tower.TowerEditorViewDelegate;
import authoring.utilityfactories.ButtonFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class TowerImageBank {

    private TowerListDataSource dataSource;
    private TowerEditorViewDelegate delegate;
    private ListView<Node> towerListView;

    private ObservableList<Node> towers;
    
    private ArrayList<Integer> towerIDs;

    private final int CELL_HEIGHT = 60;
    private final int CELL_WIDTH = 60;
    private final int TOWER_BANK_WIDTH = 120;
    private final String DEFAULT_TOWER_IMAGE_PATH = "./Images/questionmark.png";

    public TowerImageBank () {
        Button createTowerButton =
                ButtonFactory.makeButton("Create Tower",
                                         e -> {
                                             delegate.onUserPressedCreateNewTower();
                                         });
        towerListView = new ListView<Node>();
        towerListView.setMaxWidth(TOWER_BANK_WIDTH);
        towers = FXCollections.observableArrayList();

        towers.add(createTowerButton);
        towerListView.setItems(towers);
    }

    public void setDelegate (TowerEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    public void setListDataSource (TowerListDataSource source) {
        this.dataSource = source;
    }

    public Node getInstanceAsNode () {
        return towerListView;
    }

    public void updateTowerBank (List<Integer> activeTowers) {
        this.towers.remove(1, towers.size() - 1);
        for (int i = 0; i < activeTowers.size(); i++) {
            TowerListCellData cellData = dataSource.getCellDataForTower(activeTowers.get(i));
            Node cell = createCellFromData(cellData);
            towers.add(cell);
        }
    }

    private Node createCellFromData (TowerListCellData data) {
        ImageView cell = new ImageView();
        String imageFilePath = data.getImagePath();
        if (imageFilePath.equals(null) || imageFilePath.length() < 1) {
            imageFilePath = DEFAULT_TOWER_IMAGE_PATH;
        }
        File file = new File(data.getImagePath());
        Image image = new Image(file.toURI().toString());
        cell.setImage(image);
        cell.setPreserveRatio(true);
        cell.setFitHeight(CELL_HEIGHT);
        cell.setFitWidth(CELL_WIDTH);
        return cell;
    }

    private void addImageToBank (Image image) {
        ImageView cell = new ImageView();
        cell.setImage(image);
        cell.setPreserveRatio(true);
        cell.setFitHeight(CELL_HEIGHT);
        cell.setFitWidth(CELL_WIDTH);
        towers.add(cell);
    }

}
