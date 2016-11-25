package authoring.editorview.tower.subviews;

import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;
import authoring.editorview.PhotoFileChooser;
import authoring.editorview.tower.ITowerEditorView;
import authoring.editorview.tower.TowerEditorViewDelegate;
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
import authoring.utilityfactories.BoxFactory;
import authoring.utilityfactories.ButtonFactory;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class TowerEffectView extends PhotoFileChooser implements ITowerEditorView {

    private TowerEditorViewDelegate delegate;
    private TowerNameField towerName;
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

    private VBox vbox;
    private ScrollPane completeView;
    private File chosenFile;

    private ResourceBundle labelsResource;
    private final String TOWER_EFFECT_RESOURCE_PATH = "resources/GameAuthoringTower";

    public TowerEffectView (TowerNameField towerName,
                            TowerFrequencyField towerFrequency,
                            TowerImageView towerImage,
                            TowerRangeField towerRange,
                            TowerBuyPriceField towerBuyPrice,
                            TowerFireRateField towerFireRate,
                            TowerSellPriceField towerSellPrice,
                            TowerUnlockLevelField towerUnlockLevel,
                            TowerAbilityField towerAbility,
                            TowerChooseEnemyField towerChooseEnemy,
                            TowerChooseWeaponField towerChooseWeapon,
                            TowerUpgradeField towerUpgrade) {

        this.towerName = towerName;
        this.towerFrequency = towerFrequency;
        this.towerImage = towerImage;
        this.towerRange = towerRange;
        this.towerBuyPrice = towerBuyPrice;
        this.towerFireRate = towerFireRate;
        this.towerSellPrice = towerSellPrice;
        this.towerUnlockLevel = towerUnlockLevel;
        this.towerAbility = towerAbility;
        this.towerChooseEnemy = towerChooseEnemy;
        this.towerChooseWeapon = towerChooseWeapon;
        this.towerUpgrade = towerUpgrade;

        labelsResource = ResourceBundle.getBundle(TOWER_EFFECT_RESOURCE_PATH);
        vbox = new VBox(10);
        completeView = new ScrollPane();
        completeView.setContent(vbox);

        buildViewComponents();
    }

    private void buildViewComponents () {
        Node myImageView = towerImage.getInstanceAsNode();

        vbox.getChildren().add(myImageView);
        vbox.getChildren().add(ButtonFactory.makeButton(labelsResource.getString("Image"),
                                                        e -> {
                                                            try {
                                                                selectFile("Select new tower image",
                                                                           "Photos: ");
                                                            }
                                                            catch (IOException e1) {
                                                                // TODO Fix this for better user
                                                                // output
                                                                e1.printStackTrace();
                                                            }
                                                        }));
        vbox.getChildren()
                .add(BoxFactory.createHBoxWithLabelandNode(labelsResource.getString("Name"),
                                                           towerName.getInstanceAsNode()));
        vbox.getChildren()
                .add(BoxFactory.createHBoxWithLabelandNode(labelsResource.getString("Rate"),
                                                           towerFireRate.getInstanceAsNode()));
        vbox.getChildren()
                .add(BoxFactory.createHBoxWithLabelandNode(labelsResource.getString("Frequency"),
                                                           towerFrequency.getInstanceAsNode()));
        vbox.getChildren()
                .add(BoxFactory.createHBoxWithLabelandNode(labelsResource.getString("Range"),
                                                           towerRange.getInstanceAsNode()));
        vbox.getChildren()
                .add(BoxFactory.createHBoxWithLabelandNode(labelsResource.getString("BuyPrice"),
                                                           towerBuyPrice.getInstanceAsNode()));
        vbox.getChildren()
                .add(BoxFactory.createHBoxWithLabelandNode(labelsResource.getString("SellPrice"),
                                                           towerSellPrice.getInstanceAsNode()));
        vbox.getChildren()
                .add(BoxFactory.createHBoxWithLabelandNode(labelsResource.getString("UnlockLevel"),
                                                           towerUnlockLevel.getInstanceAsNode()));
        vbox.getChildren().add(towerAbility.getInstanceAsNode());
        vbox.getChildren().add(towerChooseEnemy.getInstanceAsNode());
        vbox.getChildren().add(towerChooseWeapon.getInstanceAsNode());
        vbox.getChildren().add(towerUpgrade.getInstanceAsNode());
    }

    @Override
    public void setDelegate (TowerEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public void openFileChooser (FileChooser chooseFile) throws IOException {
        chosenFile = chooseFile.showOpenDialog(new Stage());
    }

    @Override
    public Node getInstanceAsNode () {
        return completeView;
    }

}
