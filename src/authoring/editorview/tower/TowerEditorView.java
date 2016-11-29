package authoring.editorview.tower;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;
import authoring.editorview.tower.subviews.TowerEffectView;
import authoring.editorview.tower.subviews.TowerImageBank;
import authoring.editorview.tower.subviews.editorfields.TowerAbilityField;
import authoring.editorview.tower.subviews.editorfields.TowerBuyPriceField;
import authoring.editorview.tower.subviews.editorfields.TowerChooseWeaponField;
import authoring.editorview.tower.subviews.editorfields.TowerImageView;
import authoring.editorview.tower.subviews.editorfields.TowerNameField;
import authoring.editorview.tower.subviews.editorfields.TowerSellPriceField;
import authoring.editorview.tower.subviews.editorfields.TowerUnlockLevelField;
import authoring.editorview.tower.subviews.editorfields.TowerUpgradeField;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;


/**
 * @author Kayla Schulz
 * @author Diane Hadley
 *
 */
public class TowerEditorView implements ITowerUpdateView {
    private TowerEditorViewDelegate delegate;
    private BorderPane towerEditorView;
    private TowerImageBank towerBank;
    private TowerNameField towerName;
    private TowerEffectView towerEffectView;
    private TowerImageView towerImage;
    private TowerBuyPriceField towerBuyPrice;
    private TowerSellPriceField towerSellPrice;
    private TowerUnlockLevelField towerUnlockLevel;
    private TowerAbilityField towerAbility;
    private TowerChooseWeaponField towerChooseWeapon;
    private TowerUpgradeField towerUpgrade;

    public TowerEditorView () throws IOException {
        towerEditorView = new BorderPane();

        ResourceBundle labelsResource = ResourceBundle.getBundle("resources/GameAuthoringTower");
        ResourceBundle dialogueBoxResource = ResourceBundle.getBundle("resources/DialogueBox");

        towerName = new TowerNameField(labelsResource);
        towerImage = new TowerImageView(labelsResource);
        towerBuyPrice = new TowerBuyPriceField(labelsResource);
        towerSellPrice = new TowerSellPriceField(labelsResource);
        towerUnlockLevel = new TowerUnlockLevelField(labelsResource);
        towerAbility = new TowerAbilityField(labelsResource);
        towerChooseWeapon = new TowerChooseWeaponField(labelsResource);
        towerUpgrade = new TowerUpgradeField(labelsResource);

        towerBank = new TowerImageBank(labelsResource, dialogueBoxResource);
        towerEffectView =
                new TowerEffectView(towerName, towerImage, towerBuyPrice, towerSellPrice,
                                    towerUnlockLevel, towerAbility, towerChooseWeapon, towerUpgrade,
                                    labelsResource, dialogueBoxResource);
        setBorderPane();
    }

    private void setBorderPane () {
        towerEditorView.setLeft(towerBank.getInstanceAsNode());
        towerEditorView.setCenter(towerEffectView.getInstanceAsNode());
    }

    @Override
    public Node getInstanceAsNode () {
        return towerEditorView;
    }

    @Override
    public void setDelegate (TowerEditorViewDelegate delegate) {
        this.delegate = delegate;
        towerBank.setDelegate(delegate);
        towerEffectView.setDelegate(delegate);
        towerName.setDelegate(delegate);
        towerImage.setDelegate(delegate);
        towerBuyPrice.setDelegate(delegate);
        towerSellPrice.setDelegate(delegate);
        towerUnlockLevel.setDelegate(delegate);
        towerAbility.setDelegate(delegate);
        towerChooseWeapon.setDelegate(delegate);
        towerUpgrade.setDelegate(delegate);
    }

    @Override
    public void updateFireRateDisplay (double towerFireRate) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateUnlockLevelDisplay (int towerUnlockLevel) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateRangeDisplay (double towerRange) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateTowerImagePath (String towerImagePath) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateTowerName (String towerName) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateTowerBuyPriceDisplay (double towerBuyPrice) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateTowerSellPriceDisplay (double towerSellPrice) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateTowerAbility (List<Integer> towerAbility) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateTowerUpgradeBank (List<Integer> towerUpgrades) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateTowerBank (List<Integer> createdTowers) {
        // TODO Auto-generated method stub

    }

    @Override
    public void createNewTower () {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateNameDisplay (String name) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateImagePathDisplay (String imagePath) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateSizeDisplay (double size) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateTowerChosenWeapon (List<Integer> newValue) {
        // TODO Auto-generated method stub

    }
}
