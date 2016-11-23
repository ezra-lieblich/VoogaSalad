package authoring.editorview.weapon.subviews.editorfields;

import authoring.editorview.weapon.WeaponEditorViewDelegate;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.control.TextField;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class WeaponRangeField {

    private TextField weaponRangeField;
    private WeaponEditorViewDelegate delegate;

    public WeaponRangeField () {
        weaponRangeField =
                TextFieldFactory.makeTextField("Set weapon range: ",
                                               e -> delegate
                                                       .onUserEnteredWeaponRange(weaponRangeField
                                                               .getText()));
    }

    public void setDelegate (WeaponEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    public TextField getWeaponRangeField () {
        return weaponRangeField;
    }

    public void updateWeaponRange (String weaponRange) {
        weaponRangeField.setText(weaponRange);
    }

}
