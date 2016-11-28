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
public class WeaponNameField implements IWeaponEditorView {

    private TextField weaponNameField;
    private WeaponEditorViewDelegate delegate;

    public WeaponNameField () {
        createField();
    }

    private void createField () {
        weaponNameField =
                TextFieldFactory.makeTextField("Set weapon name: ", e -> delegate
                        .onUserEnteredWeaponName(weaponNameField.getText()));
    }

    @Override
    public void setDelegate (WeaponEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Node getInstanceAsNode () {
        return weaponNameField;
    }

    public void updateWeaponName (String weaponName) {
        weaponNameField.setText(weaponName);
    }

}
