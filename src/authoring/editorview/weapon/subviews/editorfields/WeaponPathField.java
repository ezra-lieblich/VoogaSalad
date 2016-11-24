package authoring.editorview.weapon.subviews.editorfields;

import authoring.editorview.weapon.IWeaponEditorView;
import authoring.editorview.weapon.WeaponEditorViewDelegate;
import authoring.utilityfactories.ComboBoxFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;


public class WeaponPathField implements IWeaponEditorView {

    private ComboBox<Object> weaponPathBox;
    private WeaponEditorViewDelegate delegate;

    public WeaponPathField () {
        ObservableList<Object> pathOptions = setList();
        createField(pathOptions);
    }

    private ObservableList<Object> setList () {
        ObservableList<Object> pathOptions =
                FXCollections.observableArrayList("I still don't know", "Sorry");
        return pathOptions;
    }

    private void createField (ObservableList<Object> pathOptions) {
        weaponPathBox =
                ComboBoxFactory.makeComboBox("Set weapon path: ", e -> delegate
                        .onUserEnteredWeaponPath((String) weaponPathBox.getValue()), pathOptions);
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
