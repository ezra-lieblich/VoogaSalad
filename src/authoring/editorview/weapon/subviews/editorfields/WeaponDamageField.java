package authoring.editorview.weapon.subviews.editorfields;

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
public class WeaponDamageField implements IWeaponEditorView {

    private TextField weaponDamageField;
    private WeaponEditorViewDelegate delegate;

    public WeaponDamageField () {
        createField();
    }

    private void createField () {
        weaponDamageField =
                TextFieldFactory.makeTextField("Set weapon damage: ", e -> delegate
                        .onUserEnteredWeaponDamage(weaponDamageField.getText()));
    }

    @Override
    public void setDelegate (WeaponEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Node getInstanceAsNode () {
        return weaponDamageField;
    }

    public void updateWeaponDamage (String weaponDamage) {
        weaponDamageField.setText(weaponDamage);
    }

}
