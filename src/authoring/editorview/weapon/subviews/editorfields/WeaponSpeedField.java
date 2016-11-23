package authoring.editorview.weapon.subviews.editorfields;

import authoring.editorview.weapon.WeaponEditorViewDelegate;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.control.TextField;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class WeaponSpeedField {

    private TextField weaponSpeedField;
    private WeaponEditorViewDelegate delegate;

    public WeaponSpeedField () {
        weaponSpeedField =
                TextFieldFactory.makeTextField("Set weapon speed: ",
                                               e -> delegate
                                                       .onUserEnteredProjectileSpeed(weaponSpeedField
                                                               .getText()));
    }

    public void setDelegate (WeaponEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    public TextField getWeaponSpeedField () {
        return weaponSpeedField;
    }

    public void updateWeaponSpeed (String weaponSpeed) {
        weaponSpeedField.setText(weaponSpeed);
    }

}
