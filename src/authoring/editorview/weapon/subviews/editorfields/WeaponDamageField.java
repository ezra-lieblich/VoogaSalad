package authoring.editorview.weapon.subviews.editorfields;

import authoring.editorview.weapon.WeaponEditorViewDelegate;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.control.TextField;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class WeaponDamageField {

    private TextField weaponDamageField;
    private WeaponEditorViewDelegate delegate;

    public WeaponDamageField () {
        weaponDamageField =
                TextFieldFactory.makeTextField("Set weapon damage: ",
                                               e -> delegate
                                                       .onUserEnteredWeaponDamage(weaponDamageField
                                                               .getText()));
    }

    public void setDelegate (WeaponEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    public TextField getWeaponDamageField () {
        return weaponDamageField;
    }

    public void updateWeaponDamage (String weaponDamage) {
        weaponDamageField.setText(weaponDamage);
    }

}
