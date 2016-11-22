package authoring.editorview.weapon;

import java.io.IOException;
import java.util.List;
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
        weaponBank = new WeaponImageBank();
        weaponEffectsView = new WeaponEffectView();
        setBorderPane();
    }

    private void setBorderPane () {
        weaponEditorView.setLeft(weaponBank.getInstanceAsNode());
        weaponEditorView.setCenter(weaponEffectsView.getInstanceAsNode());
    }

    @Override
    public Node getInstanceAsNode () {
        return weaponEditorView;
    }

    @Override
    public void setDelegate (WeaponEditorViewDelegate delegate) {
        this.delegate = delegate;
        weaponBank.setDelegate(delegate);
        weaponEffectsView.setDelegate(delegate);
    }

    @Override
    public void updateFireRateDisplay (int rate) {
        weaponEffectsView.updateFireRateDisplay(rate);
    }

    @Override
    public void updateSpeedDisplay (int speed) {
        weaponEffectsView.updateSpeedDisplay(speed);
    }

    @Override
    public void updateCollisionEffectDisplay (String collisionEffect) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateRangeDisplay (int range) {
        weaponEffectsView.updateRangeDisplay(range);
    }

    @Override
    public void updateImagePath (String imagePath) {
        weaponEffectsView.updateWeaponImagePath(imagePath);

    }

    @Override
    public void updateWeaponID (int weaponID) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateDamageDisplay (int damage) {
        weaponEffectsView.updateWeaponDamage(damage);
    }

    @Override
    public void onUserPressedCreate () {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateWeaponBank (List<Integer> activeWeapons) {
        // TODO Auto-generated method stub
        
    }

}
