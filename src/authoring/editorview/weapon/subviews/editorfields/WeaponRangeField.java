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
public class WeaponRangeField implements WeaponSetView {

    private TextField weaponRangeField;
    private WeaponAuthoringViewDelegate delegate;

    public WeaponRangeField (ResourceBundle labelsResource) {
        createField(labelsResource);
    }

    private void createField (ResourceBundle labelsResource) {
        weaponRangeField =
                TextFieldFactory.makeTextField(labelsResource.getString("EnterInt"), e -> delegate
                        .onUserEnteredWeaponRange(weaponRangeField.getText()));
    }

    @Override
    public void setDelegate (WeaponAuthoringViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Node getInstanceAsNode () {
        return weaponRangeField;
    }

    public void updateWeaponRange (String weaponRange) {
        weaponRangeField.setText(weaponRange);
    }

}
