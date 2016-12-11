package authoring.editorview.weapon.subviews.editorfields;

import java.util.ResourceBundle;
import authoring.editorview.weapon.IWeaponSetView;
import authoring.editorview.weapon.WeaponAuthoringViewDelegate;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.control.TextField;


public class WeaponSizeField implements IWeaponSetView {

    private TextField weaponSizeField;
    private WeaponAuthoringViewDelegate delegate;

    public WeaponSizeField (ResourceBundle labelsResource) {
        createField(labelsResource);
    }

    private void createField (ResourceBundle labelsResource) {
        weaponSizeField =
                TextFieldFactory.makeTextField(labelsResource.getString("EnterInt"), e -> delegate
                        .onUserEnteredWeaponSize(weaponSizeField.getText()));
    }

    @Override
    public void setDelegate (WeaponAuthoringViewDelegate delegate) {
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
