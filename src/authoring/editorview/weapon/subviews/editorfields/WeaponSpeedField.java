package authoring.editorview.weapon.subviews.editorfields;

import java.util.ResourceBundle;
import authoring.editorview.weapon.WeaponSetView;
import authoring.editorview.weapon.WeaponAuthoringViewDelegate;
import authoring.utilityfactories.TextFieldFactory;
import javafx.scene.Node;
import javafx.scene.control.TextField;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class WeaponSpeedField implements WeaponSetView {

    private TextField weaponSpeedField;
    private WeaponAuthoringViewDelegate delegate;

    public WeaponSpeedField (ResourceBundle labelsResource) {
        createField(labelsResource);
    }

    private void createField (ResourceBundle labelsResource) {
        weaponSpeedField =
                TextFieldFactory.makeTextField(labelsResource.getString("EnterInt"), e -> delegate
                        .onUserEnteredWeaponSpeed(weaponSpeedField.getText()));
    }

    @Override
    public void setDelegate (WeaponAuthoringViewDelegate delegate) {
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
