package authoring.editorview.tower;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;
import authoring.editorview.tower.subviews.TowerEffectView;
import authoring.editorview.tower.subviews.TowerImageBank;
import authoring.editorview.tower.subviews.editorfields.TowerAbilityBank;
import authoring.editorview.tower.subviews.editorfields.TowerBuyPriceField;
import authoring.editorview.tower.subviews.editorfields.TowerWeaponBank;
import authoring.editorview.tower.subviews.editorfields.TowerImageView;
import authoring.editorview.tower.subviews.editorfields.TowerNameField;
import authoring.editorview.tower.subviews.editorfields.TowerSellPriceField;
import authoring.editorview.tower.subviews.editorfields.TowerSizeField;
import authoring.editorview.tower.subviews.editorfields.TowerUnlockLevelField;
import authoring.editorview.tower.subviews.editorfields.TowerUpgradeBank;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;


/**
 * @author Kayla Schulz
 * @author Diane Hadley
 *
 */
public class TowerEditorView implements ITowerEditorView {
    private TowerEditorViewDelegate delegate;
    private BorderPane towerEditorView;
    private TowerImageBank towerBank;
    private TowerNameField towerName;
    private TowerEffectView towerEffectView;
    private TowerImageView towerImage;
    private TowerBuyPriceField towerBuyPrice;
    private TowerSellPriceField towerSellPrice;
    private TowerUnlockLevelField towerUnlockLevel;
    private TowerAbilityBank towerAbility;
    private TowerWeaponBank towerWeaponBank;
    private TowerUpgradeBank towerUpgradeBank;
    private TowerSizeField towerSize;
    private ResourceBundle labelsResource =
            ResourceBundle.getBundle("resources/GameAuthoringTower");
    private ResourceBundle dialogueBoxResource = ResourceBundle.getBundle("resources/DialogueBox");

    public TowerEditorView () throws IOException {
        towerEditorView = new BorderPane();

        towerName = new TowerNameField(labelsResource);
        towerImage = new TowerImageView(labelsResource);
        towerBuyPrice = new TowerBuyPriceField(labelsResource);
        towerSellPrice = new TowerSellPriceField(labelsResource);
        towerUnlockLevel = new TowerUnlockLevelField(labelsResource);
        towerAbility = new TowerAbilityBank(labelsResource);
        towerWeaponBank = new TowerWeaponBank(labelsResource);
        towerUpgradeBank = new TowerUpgradeBank(labelsResource);
        towerSize = new TowerSizeField(labelsResource);

        towerBank = new TowerImageBank();
        towerEffectView =
                new TowerEffectView(towerName, towerImage, towerBuyPrice, towerSellPrice,
                                    towerUnlockLevel, towerAbility, towerWeaponBank,
                                    towerUpgradeBank,
                                    towerSize,
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
        towerWeaponBank.setDelegate(delegate);
        towerUpgradeBank.setDelegate(delegate);
        towerSize.setDelegate(delegate);
    }

    @Override
    public void updateUnlockLevelDisplay (int towerLevel) {
        this.towerUnlockLevel.updateTowerUnlockLevel(Integer.toString(towerLevel));
    }

    @Override
    public void updateTowerBuyPriceDisplay (double towerBuyPrice) {
        this.towerBuyPrice.updateTowerBuyPrice(Double.toString(towerBuyPrice));
    }

    @Override
    public void updateTowerSellPriceDisplay (double towerSellPrice) {
        this.towerSellPrice.updateTowerSellPrice(Double.toString(towerSellPrice));
    }

    @Override
    public void updateTowerAbilityBank (List<Integer> towerAbility) {
        // TODO Auto-generated method stub

    }

    @Override
    public void updateTowerUpgradeBank (List<Integer> towerUpgrades) {

    }

    @Override
    public void updateTowerBank (List<Integer> createdTowers) {
        towerBank.updateTowerBank(createdTowers);
    }

    @Override
    public void createNewTower () {
        // towerName.updateTowerName(towerName);
    }

    @Override
    public void updateNameDisplay (String name) {
        this.towerName.updateTowerName(name);
    }

    @Override
    public void updateImagePathDisplay (String imagePath) {
        this.towerImage.updateTowerImagePath(imagePath);
    }

    @Override
    public void updateSizeDisplay (double size) {
        this.towerSize.updateTowerSize(Double.toString(size));

    }

    @Override
    public void updateTowerWeaponBank (List<Integer> newValue) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deleteTower () {
        // TODO Auto-generated method stub

    }
}
