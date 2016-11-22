package authoring.editorview.weapon;

import java.io.IOException;
import authoring.editorview.weapon.subviews.WeaponEffectView;
import authoring.editorview.weapon.subviews.WeaponImageBank;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;


public class WeaponEditorView implements IWeaponEditorView {
    private WeaponEditorViewDelegate delegate;
    private BorderPane weaponEditorView;
    private WeaponImageBank weaponBank;
    private WeaponEffectView weaponEffects;

    public WeaponEditorView () throws IOException {
        weaponEditorView = new BorderPane();
        weaponBank = new WeaponImageBank(delegate);
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

    @Override
    public void setDelegate (WeaponEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

}
