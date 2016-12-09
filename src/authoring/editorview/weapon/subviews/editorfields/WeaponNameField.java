package authoring.editorview.weapon.subviews.editorfields;

import java.util.ResourceBundle;
import authoring.editorview.NameView;
import authoring.editorview.weapon.IWeaponSetView;
import authoring.editorview.weapon.WeaponEditorViewDelegate;
import authoring.utilityfactories.BoxFactory;
import authoring.utilityfactories.TextFieldFactory;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class WeaponNameField extends NameView implements IWeaponSetView {

    private WeaponEditorViewDelegate delegate;

    public WeaponNameField (ResourceBundle labelsResource) {
        super(labelsResource);
    }

    @Override
    public void setDelegate (WeaponEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    protected void makeNameTextField () {
        nameTextField =
                TextFieldFactory.makeTextField(resource.getString("EnterString"),
                                               e -> delegate.onUserEnteredWeaponName(nameTextField
                                                       .getText()));
        root = BoxFactory.createHBoxWithLabelandNode(resource.getString("NameTextField"),
                                                     nameTextField);
    }

}
