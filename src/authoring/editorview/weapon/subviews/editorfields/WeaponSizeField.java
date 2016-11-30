package authoring.editorview.weapon.subviews.editorfields;

import java.util.ResourceBundle;
import authoring.editorview.weapon.IWeaponEditorView;
import authoring.editorview.weapon.WeaponEditorViewDelegate;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.control.TextField;


public class WeaponSizeField implements IWeaponEditorView {

    private TextField weaponSizeField;
    private WeaponEditorViewDelegate delegate;

    public WeaponSizeField (ResourceBundle labelsResource) {
        createField(labelsResource);
    }

    private void createField (ResourceBundle labelsResource) {
        weaponSizeField =
                TextFieldFactory.makeTextField(labelsResource.getString("EnterInt"), e -> delegate
                        .onUserEnteredWeaponSize(weaponSizeField.getText()));
    }

    @Override
    public void setDelegate (WeaponEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Node getInstanceAsNode () {
        return weaponSizeField;
    }

    public void updateWeaponSize (String weaponSize) {
        weaponSizeField.setText(weaponSize);
    }

}
