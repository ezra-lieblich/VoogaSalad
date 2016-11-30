package authoring.editorview.weapon.subviews;

import java.io.File;
import java.util.List;
import java.util.ResourceBundle;
import authoring.editorview.weapon.WeaponEditorViewDelegate;
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

public class WeaponImageBank {

    private WeaponListDataSource dataSource;
    private WeaponEditorViewDelegate delegate;
    private ListView<Node> weaponListView;

    private ObservableList<Node> weapons;

    private final int CELL_HEIGHT = 60;
    private final int CELL_WIDTH = 60;
    private final int WEAPON_BANK_WIDTH = 120;
    private final String DEFAULT_WEAPON_IMAGE_PATH = "./Images/questionmark.png";

    public WeaponImageBank (ResourceBundle labelsResource) {
        Button createWeaponButton =
                ButtonFactory.makeButton("Create Weapon",
                                         e -> {
                                             delegate.onUserPressedCreateWeapon();
                                         });
        weaponListView = new ListView<Node>();
        weaponListView.setMaxWidth(WEAPON_BANK_WIDTH);
        weapons = FXCollections.observableArrayList();
        // First cell is a button
        weapons.add(createWeaponButton);
        weaponListView.setItems(weapons);
    }

    public Node getInstanceAsNode () {
        return weaponListView;
    }

    public void setDelegate (WeaponEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    public void setListDataSource (WeaponListDataSource source) {
        this.dataSource = source;
    }

    public void updateWeaponBank (List<Integer> activeWeapons) {
        this.weapons.remove(1, weapons.size() - 1);
        for (int i = 0; i < activeWeapons.size(); i++) {
            WeaponListCellData cellData = dataSource.getCellDataForWeapon(activeWeapons.get(i));
            Node cell = createCellFromData(cellData);
            weapons.add(cell);
        }
    }

    private Node createCellFromData (WeaponListCellData data) {
        ImageView cell = new ImageView();
        String imageFilePath = data.getImagePath();
        if (imageFilePath.equals(null) || imageFilePath.length() < 1) {
            imageFilePath = DEFAULT_WEAPON_IMAGE_PATH;
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
        weapons.add(cell);
    }

}
