package authoring.editorview.weapon;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;
import authoring.editorview.weapon.subviews.WeaponEffectView;
import authoring.editorview.weapon.subviews.WeaponImageBank;
import authoring.editorview.weapon.subviews.editorfields.WeaponCollisionEffectField;
import authoring.editorview.weapon.subviews.editorfields.WeaponDamageField;
import authoring.editorview.weapon.subviews.editorfields.WeaponFireRateField;
import authoring.editorview.weapon.subviews.editorfields.WeaponImageView;
import authoring.editorview.weapon.subviews.editorfields.WeaponNameField;
import authoring.editorview.weapon.subviews.editorfields.WeaponPathField;
import authoring.editorview.weapon.subviews.editorfields.WeaponRangeField;
import authoring.editorview.weapon.subviews.editorfields.WeaponSpeedField;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class WeaponEditorView implements IWeaponUpdateView {
    private WeaponEditorViewDelegate delegate;
    private BorderPane weaponEditorView;
    private WeaponImageBank weaponBank;
    private WeaponEffectView weaponEffectsView;
    private WeaponNameField weaponNameView;
    private WeaponSpeedField weaponSpeedView;
    private WeaponFireRateField weaponFireRateView;
    private WeaponRangeField weaponRangeView;
    private WeaponDamageField weaponDamageView;
    private WeaponCollisionEffectField weaponCollisionView;
    private WeaponPathField weaponPathView;
    private WeaponImageView weaponImageView;

    private int width;
    private int height;

    public WeaponEditorView (int width, int height) throws IOException {
        ResourceBundle labelsResource = ResourceBundle.getBundle("resources/GameAuthoringWeapon");
        ResourceBundle dialogueBoxResource = ResourceBundle.getBundle("resources/DialogueBox");

        this.width = width;
        this.height = height;

        weaponEditorView = new BorderPane();
        weaponEditorView.setPrefSize(width, height);
        weaponEditorView.setMaxSize(width, height);
        weaponEditorView.setMinSize(width, height);

        weaponBank = new WeaponImageBank(labelsResource);
        weaponNameView = new WeaponNameField(labelsResource);
        weaponSpeedView = new WeaponSpeedField(labelsResource);
        weaponRangeView = new WeaponRangeField(labelsResource);
        weaponFireRateView = new WeaponFireRateField(labelsResource);
        weaponDamageView = new WeaponDamageField(labelsResource);
        weaponCollisionView = new WeaponCollisionEffectField(labelsResource);
        weaponPathView = new WeaponPathField(labelsResource);
        weaponImageView = new WeaponImageView(labelsResource);
        weaponEffectsView =
                new WeaponEffectView(weaponNameView, weaponSpeedView, weaponFireRateView,
                                     weaponRangeView, weaponDamageView, weaponCollisionView,
                                     weaponPathView, weaponImageView, labelsResource,
                                     dialogueBoxResource);
        setBorderPane();
    }

    private void setBorderPane () {
        weaponBank.setPaneSize(width / 4, height);
        weaponEffectsView.setPaneSize(width * 3 / 4, height);
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
        weaponNameView.setDelegate(delegate);
        weaponSpeedView.setDelegate(delegate);
        weaponFireRateView.setDelegate(delegate);
        weaponRangeView.setDelegate(delegate);
        weaponDamageView.setDelegate(delegate);
        weaponCollisionView.setDelegate(delegate);
        weaponEffectsView.setDelegate(delegate);
        weaponPathView.setDelegate(delegate);
    }

    @Override
    public void updateFireRateDisplay (int rate) {
        weaponFireRateView.updateWeaponFireRate(Integer.toString(rate));
    }

    @Override
    public void updateSpeedDisplay (int speed) {
        weaponSpeedView.updateWeaponSpeed(Integer.toString(speed));
    }

    @Override
    public void updateCollisionEffectDisplay (String collisionEffect) {
        weaponCollisionView.updateWeaponCollisionEffect(collisionEffect);
    }

    @Override
    public void updateRangeDisplay (int range) {
        weaponRangeView.updateWeaponRange(Integer.toString(range));
    }

    @Override
    public void updateWeaponImagePath (String imagePath) {
        weaponImageView.updateWeaponImagePath(imagePath);

    }

    @Override
    public void updateDamageDisplay (int damage) {
        weaponDamageView.updateWeaponDamage(Integer.toString(damage));
    }

    @Override
    public void updateWeaponBank (List<Integer> activeWeapons) {
        // weaponBank.

    }

    @Override
    public void updateWeaponName (String weaponName) {
        this.weaponNameView.updateWeaponName(weaponName);
    }

    @Override
    public void updateWeaponPath (String path) {
        weaponPathView.updateWeaponPath(path);
    }

    @Override
    public void createNewWeapon () {
        // TODO Auto-generated method stub
        // This will set all default values for the weapon

    }

}
