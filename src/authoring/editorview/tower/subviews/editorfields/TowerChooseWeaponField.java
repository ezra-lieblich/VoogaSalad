package authoring.editorview.tower.subviews.editorfields;

import authoring.editorview.tower.ITowerEditorView;
import authoring.editorview.tower.TowerEditorViewDelegate;
import authoring.utilityfactories.ComboBoxFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;

/**
 * 
 * @author  Kayla Schulz
 *
 */
public class TowerChooseWeaponField implements ITowerEditorView {

    private ComboBox<Object> towerChooseWeaponBox;
    private TowerEditorViewDelegate delegate;

    public TowerChooseWeaponField () {
        ObservableList<Object> weaponOptions = setList();
        createComboBox(weaponOptions);
    }

    private ObservableList<Object> setList () {
        ObservableList<Object> weaponOptions =
                FXCollections.observableArrayList("IDK", "Sorry");
        return weaponOptions;
    }

    private void createComboBox (ObservableList<Object> weaponOptions) {
        towerChooseWeaponBox =
                ComboBoxFactory.makeComboBox("Set tower weapon: ", e -> delegate
                        .onUserEnteredTowerChosenWeapon((String) towerChooseWeaponBox.getValue()),
                                             weaponOptions);
    }

    @Override
    public void setDelegate (TowerEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Node getInstanceAsNode () {
        return towerChooseWeaponBox;
    }

    public void updateTowerChosenWeapon (String chosenWeapon) {
        towerChooseWeaponBox.setValue(chosenWeapon);
    }

}
