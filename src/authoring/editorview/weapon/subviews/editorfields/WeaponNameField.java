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
public class WeaponNameField implements IWeaponEditorView {

    private TextField weaponNameField;
    private WeaponEditorViewDelegate delegate;

    public WeaponNameField (ResourceBundle labelsResource) {
        createField(labelsResource);
    }

    private void createField (ResourceBundle labelsResource) {
        weaponNameField =
                TextFieldFactory.makeTextField(labelsResource.getString("EnterString"),
                                               e -> delegate
                                                       .onUserEnteredWeaponName(weaponNameField
                                                               .getText()));
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
