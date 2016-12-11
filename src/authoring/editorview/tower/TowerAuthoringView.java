package authoring.editorview.tower;

import java.util.List;
import java.util.ResourceBundle;
import authoring.editorview.ListDataSource;
import authoring.editorview.tower.subviews.TowerEditorView;
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
public class TowerAuthoringView implements ITowerUpdateView {
    @SuppressWarnings("unused")
    private TowerAuthoringViewDelegate delegate;
    private BorderPane towerEditorView;
    private TowerImageBank towerBank;
    private TowerNameField towerName;
    private TowerEditorView towerEffectView;
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

    public TowerAuthoringView () {
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
                new TowerEditorView(towerName, towerImage, towerBuyPrice, towerSellPrice,
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
    public void setDelegate (TowerAuthoringViewDelegate delegate) {
        this.delegate = delegate;
        towerEffectView.setDelegate(delegate);
        towerBank.setDelegate(delegate);
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
        // TODO Actually do this
    }

    @Override
    public void updateTowerBank (List<Integer> createdTowers) {
        towerBank.updateTowerBank(createdTowers);
    }

    @Override
    public void updateNameDisplay (String name) {
        this.towerName.updateName(name);
    }

    @Override
    public void updateImagePathDisplay (String imagePath) {
        this.towerImage.updateTowerImagePath(imagePath);
        this.towerBank.updateBank();
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

    @Override
    public void updateBank (List<Integer> ids) {
        this.towerBank.updateBank(ids);
    }

    @Override
    public void setTowerListDataSource (ListDataSource source) {
        this.towerBank.setListDataSource(source);
    }

    @Override
    public void updateDeleteEntity (String entityID) {
        // TODO Auto-generated method stub
        
    }
}
