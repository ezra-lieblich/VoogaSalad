package authoring.editorview.weapon;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;
import authoring.editorview.ListDataSource;
import authoring.editorview.weapon.subviews.WeaponEditorView;
import authoring.editorview.weapon.subviews.WeaponImageBank;
import authoring.editorview.weapon.subviews.editorfields.WeaponFireRateField;
import authoring.editorview.weapon.subviews.editorfields.WeaponImageView;
import authoring.editorview.weapon.subviews.editorfields.WeaponNameField;
import authoring.editorview.weapon.subviews.editorfields.WeaponPathField;
import authoring.editorview.weapon.subviews.editorfields.WeaponRangeField;
import authoring.editorview.weapon.subviews.editorfields.WeaponSizeField;
import authoring.editorview.weapon.subviews.editorfields.WeaponSpeedField;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class WeaponAuthoringView implements IWeaponUpdateView {
    private WeaponAuthoringViewDelegate delegate;
    private BorderPane weaponEditorView;
    private WeaponImageBank weaponBank;
    private WeaponEditorView weaponEffectsView;
    private WeaponNameField weaponNameView;
    private WeaponSpeedField weaponSpeedView;
    private WeaponFireRateField weaponFireRateView;
    private WeaponRangeField weaponRangeView;
    private WeaponPathField weaponPathView;
    private WeaponImageView weaponImageView;
    private WeaponSizeField weaponSizeView;

    private int width;
    private int height;

    public WeaponAuthoringView (int width, int height) throws IOException {
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
        weaponPathView = new WeaponPathField(labelsResource);
        weaponImageView = new WeaponImageView(labelsResource);
        weaponSizeView = new WeaponSizeField(labelsResource);
        weaponEffectsView =
                new WeaponEditorView(weaponNameView, weaponSpeedView, weaponFireRateView,
                                     weaponRangeView,
                                     weaponPathView, weaponImageView, weaponSizeView,
                                     labelsResource,
                                     dialogueBoxResource);
        setBorderPane();
    }

    private void setBorderPane () {
        weaponEffectsView.setPaneSize(width * 3 / 4, height);
        weaponEditorView.setLeft(weaponBank.getInstanceAsNode());
        weaponEditorView.setCenter(weaponEffectsView.getInstanceAsNode());
    }

    @Override
    public Node getInstanceAsNode () {
        return weaponEditorView;
    }

    @Override
    public void setDelegate (WeaponAuthoringViewDelegate delegate) {
        this.delegate = delegate;
        weaponBank.setDelegate(delegate);
        weaponNameView.setDelegate(delegate);
        weaponSpeedView.setDelegate(delegate);
        weaponFireRateView.setDelegate(delegate);
        weaponRangeView.setDelegate(delegate);
        weaponEffectsView.setDelegate(delegate);
        weaponPathView.setDelegate(delegate);
        weaponSizeView.setDelegate(delegate);
    }

    @Override
    public void updateFireRateDisplay (double fireRate) {
        this.weaponFireRateView.updateWeaponFireRate(Double.toString(fireRate));
    }

    @Override
    public void updateSpeedDisplay (double speed) {
        this.weaponSpeedView.updateWeaponSpeed(Double.toString(speed));
    }

    @Override
    public void updateRangeDisplay (double range) {
        this.weaponRangeView.updateWeaponRange(Double.toString(range));
    }

    @Override
    public void updateWeaponBank (List<Integer> activeWeapons) {
        this.weaponBank.updateWeaponBank(activeWeapons);
    }

    @Override
    public void updateWeaponTrajectory (String path) {
        this.weaponPathView.updateWeaponPath(path);
    }

    @Override
    public void createNewWeapon () {
        // TODO Auto-generated method stub
        // This will set all default values for the weapon

    }

    @Override
    public void updateTargetEnemies (List<Integer> targetEnemies) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateNameDisplay (String name) {
        this.weaponNameView.updateName(name);

    }

    @Override
    public void updateImagePathDisplay (String imagePath) {
    	this.weaponBank.updateBank();
        this.weaponImageView.updateWeaponImagePath(imagePath);
        this.weaponBank.updateSelectedCell();
    }

    @Override
    public void updateSizeDisplay (double size) {
        this.weaponSizeView.updateWeaponSize(Double.toString(size));
    }

    @Override
    public void deleteWeapon () {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateBank (List<Integer> ids) {
        this.weaponBank.updateBank(ids);
    }

    @Override
    public void setWeaponListDataSource (ListDataSource source) {
        // TODO Auto-generated method stub
        this.weaponBank.setListDataSource(source);
    }

    @Override
    public void updateDeleteEntity (String entityID) {
        // TODO Auto-generated method stub

    }

}
