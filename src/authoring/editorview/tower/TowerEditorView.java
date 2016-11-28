package authoring.editorview.tower;

import java.io.IOException;
import authoring.editorview.tower.subviews.TowerEffectView;
import authoring.editorview.tower.subviews.TowerImageBank;
import authoring.editorview.tower.subviews.editorfields.TowerAbilityField;
import authoring.editorview.tower.subviews.editorfields.TowerBuyPriceField;
import authoring.editorview.tower.subviews.editorfields.TowerChooseEnemyField;
import authoring.editorview.tower.subviews.editorfields.TowerChooseWeaponField;
import authoring.editorview.tower.subviews.editorfields.TowerFireRateField;
import authoring.editorview.tower.subviews.editorfields.TowerFrequencyField;
import authoring.editorview.tower.subviews.editorfields.TowerImageView;
import authoring.editorview.tower.subviews.editorfields.TowerNameField;
import authoring.editorview.tower.subviews.editorfields.TowerRangeField;
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
public class TowerEditorView implements ITowerEditorView {
    private TowerEditorViewDelegate delegate;
    private BorderPane towerEditorView;
    private TowerImageBank towerBank;
    private TowerNameField towerName;
    private TowerEffectView towerEffectView;
    private TowerFrequencyField towerFrequency;
    private TowerImageView towerImage;
    private TowerRangeField towerRange;
    private TowerBuyPriceField towerBuyPrice;
    private TowerFireRateField towerFireRate;
    private TowerSellPriceField towerSellPrice;
    private TowerUnlockLevelField towerUnlockLevel;
    private TowerAbilityField towerAbility;
    private TowerChooseEnemyField towerChooseEnemy;
    private TowerChooseWeaponField towerChooseWeapon;
    private TowerUpgradeField towerUpgrade;

    public TowerEditorView () throws IOException {
        towerEditorView = new BorderPane();

        towerName = new TowerNameField();
        towerFrequency = new TowerFrequencyField();
        towerImage = new TowerImageView();
        towerRange = new TowerRangeField();
        towerBuyPrice = new TowerBuyPriceField();
        towerFireRate = new TowerFireRateField();
        towerSellPrice = new TowerSellPriceField();
        towerUnlockLevel = new TowerUnlockLevelField();
        towerAbility = new TowerAbilityField();
        towerChooseEnemy = new TowerChooseEnemyField();
        towerChooseWeapon = new TowerChooseWeaponField();
        towerUpgrade = new TowerUpgradeField();

        towerBank = new TowerImageBank();
        towerEffectView =
                new TowerEffectView(towerName, towerFrequency, towerImage, towerRange,
                                    towerBuyPrice, towerFireRate, towerSellPrice, towerUnlockLevel,
                                    towerAbility, towerChooseEnemy, towerChooseWeapon,
                                    towerUpgrade);
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
        towerFrequency.setDelegate(delegate);
        towerRange.setDelegate(delegate);
        towerImage.setDelegate(delegate);
        towerBuyPrice.setDelegate(delegate);
        towerFireRate.setDelegate(delegate);
        towerSellPrice.setDelegate(delegate);
        towerUnlockLevel.setDelegate(delegate);
        towerAbility.setDelegate(delegate);
        towerChooseEnemy.setDelegate(delegate);
        towerChooseWeapon.setDelegate(delegate);
        towerUpgrade.setDelegate(delegate);
    }
}
