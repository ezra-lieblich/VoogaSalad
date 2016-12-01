package authoring.editorview.weapon.subviews.editorfields;

import java.util.ResourceBundle;
import authoring.editorview.weapon.IWeaponSetView;
import authoring.editorview.weapon.WeaponEditorViewDelegate;
import authoring.utilityfactories.ComboBoxFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class WeaponPathField implements IWeaponSetView {

    private ComboBox<Object> weaponPathBox;
    private WeaponEditorViewDelegate delegate;
    private ResourceBundle labelsResource;

    public WeaponPathField (ResourceBundle labelsResource) {
        this.labelsResource = labelsResource;
        ObservableList<Object> pathOptions = setList();
        createField(pathOptions);
    }

    private ObservableList<Object> setList () {
        ObservableList<Object> pathOptions =
                FXCollections.observableArrayList("Straight", "Heat Follow");
        return pathOptions;
    }

    private void createField (ObservableList<Object> pathOptions) {
        weaponPathBox =
                ComboBoxFactory.makeComboBox(labelsResource.getString("Path"), e -> delegate
                        .onUserEnteredWeaponTrajectory((String) weaponPathBox.getValue()), pathOptions);
    }

    @Override
    public void setDelegate (WeaponEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Node getInstanceAsNode () {
        return weaponPathBox;
    }

    public void updateWeaponPath (String weaponPath) {
        weaponPathBox.setValue(weaponPath);
    }

}
