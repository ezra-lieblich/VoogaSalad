package authoring.editorview.tower.subviews.editorfields;

import java.util.List;
import java.util.ResourceBundle;
import org.controlsfx.control.CheckComboBox;
import authoring.editorview.tower.TowerSetView;
import authoring.utilityfactories.ComboBoxFactory;
import authoring.editorview.tower.TowerAuthoringViewDelegate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class TowerWeaponBank implements TowerSetView {

    private TowerAuthoringViewDelegate delegate;
    private CheckComboBox<String> weaponComboBox;
    private ObservableList<String> availableWeaponsList;

    public TowerWeaponBank (ResourceBundle labelsResource) {
        availableWeaponsList = FXCollections.observableArrayList();
        weaponComboBox =
                ComboBoxFactory.makeCheckComboBox(availableWeaponsList, a -> updateWeapons(a));
    }

    @Override
    public void setDelegate (TowerAuthoringViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Node getInstanceAsNode () {
        return weaponComboBox;
    }

    public void updateTowerChosenWeapon (String chosenWeapon) {
    }

    private void updateWeapons (List<String> updateWeapons) {

    }

}
