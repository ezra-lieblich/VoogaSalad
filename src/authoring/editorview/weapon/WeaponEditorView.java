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
    private WeaponEffectView weaponEffectsView;

    public WeaponEditorView () throws IOException {
        weaponEditorView = new BorderPane();
        weaponBank = new WeaponImageBank(delegate);
        weaponEffectsView = new WeaponEffectView();
        setBorderPane();
    }

    private void setBorderPane () {
        weaponEditorView.setLeft(weaponBank.getInstanceAsNode());
        weaponEditorView.setCenter(weaponEffectsView.getCompleteView());
    }

    @Override
    public Node getInstanceAsNode () {
        return weaponEditorView;
    }

    @Override
    public void setDelegate (WeaponEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public void updateFireRateDisplay (int rate) {
        weaponEffectsView.updateFireRateDisplay(rate);
    }

    @Override
    public void updateSpeedDisplay (int speed) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateCollisionEffectDisplay (String collisionEffect) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateRangeDisplay (int range) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateImagePath (String imagePath) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateImageID (int weaponImageID) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateDamageDisplay (int damage) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUserPressedCreate () {
        // TODO Auto-generated method stub

    }

}
