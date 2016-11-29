package authoring.editorview.weapon.subviews.editorfields;

import java.util.ResourceBundle;
import authoring.editorview.weapon.IWeaponEditorView;
import authoring.editorview.weapon.WeaponEditorViewDelegate;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.control.TextField;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class WeaponFireRateField implements IWeaponEditorView {

    private TextField weaponFireRateField;
    private WeaponEditorViewDelegate delegate;

    public WeaponFireRateField (ResourceBundle labelsResource) {
        createField(labelsResource);
    }

    private void createField (ResourceBundle labelsResource) {
        weaponFireRateField =
                TextFieldFactory.makeTextField(labelsResource.getString("EnterInt"), e -> delegate
                        .onUserEnteredWeaponFireRate(weaponFireRateField.getText()));
    }

    @Override
    public void setDelegate (WeaponEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Node getInstanceAsNode () {
        return weaponFireRateField;
    }

    public void updateWeaponFireRate (String weaponFireRate) {
        weaponFireRateField.setText(weaponFireRate);
    }

}
