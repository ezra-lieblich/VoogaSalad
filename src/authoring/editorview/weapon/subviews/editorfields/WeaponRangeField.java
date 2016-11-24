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
public class WeaponRangeField implements IWeaponEditorView {

    private TextField weaponRangeField;
    private WeaponEditorViewDelegate delegate;

    public WeaponRangeField () {
        weaponRangeField =
                TextFieldFactory.makeTextField("Set weapon range: ",
                                               e -> delegate
                                                       .onUserEnteredWeaponRange(weaponRangeField
                                                               .getText()));
    }

    @Override
    public void setDelegate (WeaponEditorViewDelegate delegate) {
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
