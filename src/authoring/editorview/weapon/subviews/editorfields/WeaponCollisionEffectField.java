package authoring.editorview.weapon.subviews.editorfields;

import authoring.editorview.weapon.WeaponEditorViewDelegate;
import authoring.utilityfactories.ComboBoxFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

/**
 * 
 * @author Kayla Schulz
 *
 */
public class WeaponCollisionEffectField {

    private ComboBox<Object> weaponCollisionEffectBox;
    private WeaponEditorViewDelegate delegate;

    public WeaponCollisionEffectField () {
        ObservableList<Object> effectOptions =
                FXCollections.observableArrayList("IDK", "Sorry");
        weaponCollisionEffectBox =
                ComboBoxFactory.makeComboBox("Set collision effect: ",
                                             e -> delegate
                                                     .onUserEnteredWeaponEffect((String) weaponCollisionEffectBox
                                                             .getValue()),
                                             effectOptions);
    }

    public void setDelegate (WeaponEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    public ComboBox<Object> getWeaponCollisionEffectField () {
        return weaponCollisionEffectBox;
    }

    public void updateWeaponCollisionEffect (String weaponCollisionEffect) {
        weaponCollisionEffectBox.setValue(weaponCollisionEffect);
    }

}
