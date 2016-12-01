package authoring.editorview.weapon.subviews.editorfields;

import java.util.ResourceBundle;
import authoring.editorview.weapon.IWeaponSetView;
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
public class WeaponCollisionEffectField implements IWeaponSetView {

    private ComboBox<Object> weaponCollisionEffectBox;
    private WeaponEditorViewDelegate delegate;
    private ResourceBundle labelsResource;

    public WeaponCollisionEffectField (ResourceBundle labelsResource) {
        this.labelsResource = labelsResource;
        ObservableList<Object> effectOptions = setList();
        createComboBox(effectOptions);
    }

    private ObservableList<Object> setList () {
        ObservableList<Object> effectOptions =
                FXCollections.observableArrayList("Maximum Damage - Immediate Kill", "Medium Damage - Loss of half health");
        return effectOptions;
    }

    private void createComboBox (ObservableList<Object> effectOptions) {
        weaponCollisionEffectBox =
                ComboBoxFactory.makeComboBox(labelsResource.getString("CollisionEffect"),
                                             e -> delegate
                                                     .onUserEnteredWeaponEffect((String) weaponCollisionEffectBox
                                                             .getValue()),
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