package authoring.editorview.weapon.subviews.editorfields;

import authoring.editorview.weapon.IWeaponEditorView;
import authoring.editorview.weapon.WeaponEditorViewDelegate;
import authoring.utilityfactories.ComboBoxFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class WeaponCollisionEffectField implements IWeaponEditorView {

    private ComboBox<Object> weaponCollisionEffectBox;
    private WeaponEditorViewDelegate delegate;

    public WeaponCollisionEffectField () {
        ObservableList<Object> effectOptions = setList();
        createComboBox(effectOptions);
    }

    private ObservableList<Object> setList () {
        ObservableList<Object> effectOptions =
                FXCollections.observableArrayList("IDK", "Sorry");
        return effectOptions;
    }

    private void createComboBox (ObservableList<Object> effectOptions) {
        weaponCollisionEffectBox =
                ComboBoxFactory.makeComboBox("Set collision effect: ", e -> delegate
                        .onUserEnteredWeaponEffect((String) weaponCollisionEffectBox.getValue()),
                                             effectOptions);
    }

    @Override
    public void setDelegate (WeaponEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Node getInstanceAsNode () {
        return weaponCollisionEffectBox;
    }

    public void updateWeaponCollisionEffect (String weaponCollisionEffect) {
        weaponCollisionEffectBox.setValue(weaponCollisionEffect);
    }

}
