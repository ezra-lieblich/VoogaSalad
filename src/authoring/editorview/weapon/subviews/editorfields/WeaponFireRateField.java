package authoring.editorview.weapon.subviews.editorfields;

import authoring.editorview.weapon.WeaponEditorViewDelegate;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.control.TextField;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class WeaponFireRateField {

    private TextField weaponFireRateField;
    private WeaponEditorViewDelegate delegate;

    public WeaponFireRateField () {
        weaponFireRateField =
                TextFieldFactory.makeTextField("Set weapon fire rate: ",
                                               e -> delegate
                                                       .onUserEnteredWeaponFireRate(weaponFireRateField
                                                               .getText()));
    }

    public void setDelegate (WeaponEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    public TextField getWeaponFireRateField () {
        return weaponFireRateField;
    }

    public void updateWeaponFireRate (String weaponFireRate) {
        weaponFireRateField.setText(weaponFireRate);
    }

}
