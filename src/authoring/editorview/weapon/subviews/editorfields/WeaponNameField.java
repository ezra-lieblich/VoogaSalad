package authoring.editorview.weapon.subviews.editorfields;

import java.util.ResourceBundle;
import authoring.editorview.EditorNameView;
import authoring.editorview.weapon.IWeaponSetView;
import authoring.editorview.weapon.WeaponAuthoringViewDelegate;
import authoring.utilityfactories.BoxFactory;
import authoring.utilityfactories.TextFieldFactory;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class WeaponNameField extends EditorNameView implements IWeaponSetView {

    private WeaponAuthoringViewDelegate delegate;

    public WeaponNameField (ResourceBundle labelsResource) {
        super(labelsResource);
    }

    @Override
    public void setDelegate (WeaponAuthoringViewDelegate delegate) {
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
