package authoring.editorview.weapon.subviews.editorfields;

import authoring.editorview.weapon.WeaponEditorViewDelegate;
import authoring.utilityfactories.ComboBoxFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;


public class WeaponPathField {

    private ComboBox<Object> weaponPathBox;
    private WeaponEditorViewDelegate delegate;

    public WeaponPathField () {
        ObservableList<Object> pathOptions =
                FXCollections.observableArrayList("I still don't know", "Sorry");
        weaponPathBox =
                ComboBoxFactory.makeComboBox("Set weapon path: ",
                                             e -> delegate
                                                     .onUserEnteredWeaponPath((String) weaponPathBox
                                                             .getValue()),
                                             pathOptions);
    }

    public void setDelegate (WeaponEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    public ComboBox<Object> getWeaponPathField () {
        return weaponPathBox;
    }

    public void updateWeaponPath (String weaponPath) {
        weaponPathBox.setValue(weaponPath);
    }

}
