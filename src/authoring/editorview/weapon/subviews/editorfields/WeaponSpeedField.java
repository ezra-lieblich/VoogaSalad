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
public class WeaponSpeedField implements IWeaponEditorView {

    private TextField weaponSpeedField;
    private WeaponEditorViewDelegate delegate;

    public WeaponSpeedField (ResourceBundle labelsResource) {
        createField(labelsResource);
    }

    private void createField (ResourceBundle labelsResource) {
        weaponSpeedField =
                TextFieldFactory.makeTextField(labelsResource.getString("EnterInt"), e -> delegate
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
