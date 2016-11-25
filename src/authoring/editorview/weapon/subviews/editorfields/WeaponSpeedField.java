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
public class WeaponSpeedField implements IWeaponEditorView {

    private TextField weaponSpeedField;
    private WeaponEditorViewDelegate delegate;

    public WeaponSpeedField () {
        createField();
    }

    private void createField () {
        weaponSpeedField =
                TextFieldFactory.makeTextField("Set weapon speed: ", e -> delegate
                        .onUserEnteredWeaponSpeed(weaponSpeedField.getText()));
    }

    @Override
    public void setDelegate (WeaponEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Node getInstanceAsNode () {
        return weaponSpeedField;
    }

    public void updateWeaponSpeed (String weaponSpeed) {
        weaponSpeedField.setText(weaponSpeed);
    }

}
