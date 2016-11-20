package authoring.editorview.weapon;

import authoring.editorview.weapon.subviews.WeaponEffectView;
import authoring.editorview.weapon.subviews.WeaponImageBank;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;


public class WeaponEditorView implements IWeaponEditorView {

    private BorderPane weaponEditorView;
    private WeaponImageBank weaponBank;
    private WeaponEffectView weaponEffects;

    public WeaponEditorView () {
        weaponEditorView = new BorderPane();
        weaponBank = new WeaponImageBank();
        weaponEffects = new WeaponEffectView();
        setBorderPane();
    }

    private void setBorderPane () {
        weaponEditorView.setLeft(weaponBank.getInstanceAsNode());
        weaponEditorView.setCenter(weaponEffects.getCompleteView());
    }

    @Override
    public Node getInstanceAsNode () {
        return weaponEditorView;
    }

}
