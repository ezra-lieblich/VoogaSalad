package authoring.editorview.weapon.subviews.editorfields;

import authoring.editorview.weapon.WeaponEditorViewDelegate;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.control.TextField;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class WeaponNameField {

    private TextField weaponNameField;
    private WeaponEditorViewDelegate delegate;

    public WeaponNameField () {
        weaponNameField =
                TextFieldFactory.makeTextField("Set weapon name: ",
                                               e -> delegate.onUserEnteredWeaponName(weaponNameField
                                                       .getText()));
    }

    public void setDelegate (WeaponEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    public TextField getWeaponNameField () {
        return weaponNameField;
    }

    public void updateWeaponName (String weaponName) {
        weaponNameField.setText(weaponName);
    }

}
