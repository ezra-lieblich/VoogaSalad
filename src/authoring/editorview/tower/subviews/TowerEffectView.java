package authoring.editorview.tower.subviews;

import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;
import authoring.editorview.PhotoFileChooser;
import authoring.editorview.tower.ITowerEditorView;
import authoring.editorview.tower.TowerEditorViewDelegate;
import authoring.editorview.tower.subviews.editorfields.TowerAbilityBank;
import authoring.editorview.tower.subviews.editorfields.TowerBuyPriceField;
import authoring.editorview.tower.subviews.editorfields.TowerWeaponBank;
import authoring.editorview.tower.subviews.editorfields.TowerImageView;
import authoring.editorview.tower.subviews.editorfields.TowerNameField;
import authoring.editorview.tower.subviews.editorfields.TowerSellPriceField;
import authoring.editorview.tower.subviews.editorfields.TowerSizeField;
import authoring.editorview.tower.subviews.editorfields.TowerUnlockLevelField;
import authoring.editorview.tower.subviews.editorfields.TowerUpgradeBank;
import authoring.utilityfactories.BoxFactory;
import authoring.utilityfactories.ButtonFactory;
import authoring.utilityfactories.DialogueBoxFactory;
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
    private TowerImageView towerImage;
    private TowerBuyPriceField towerBuyPrice;
    private TowerSellPriceField towerSellPrice;
    private TowerUnlockLevelField towerUnlockLevel;
    private TowerAbilityBank towerAbility;
    private TowerWeaponBank towerChooseWeapon;
    private TowerUpgradeBank towerUpgrade;
    private TowerSizeField towerSize;

    private VBox vbox;
    private ScrollPane completeView;
    private File chosenFile;

    private ResourceBundle labelsResource;
    private ResourceBundle dialogueBoxResource;

    public TowerEffectView (TowerNameField towerName,
                            TowerImageView towerImage,
                            TowerBuyPriceField towerBuyPrice,
                            TowerSellPriceField towerSellPrice,
                            TowerUnlockLevelField towerUnlockLevel,
                            TowerAbilityBank towerAbility,
                            TowerWeaponBank towerChooseWeapon,
                            TowerUpgradeBank towerUpgrade,
                            TowerSizeField towerSize,
                            ResourceBundle labelsResource,
                            ResourceBundle dialogueBoxResource) {

        this.labelsResource = labelsResource;
        this.dialogueBoxResource = dialogueBoxResource;

        this.towerName = towerName;
        this.towerImage = towerImage;
        this.towerBuyPrice = towerBuyPrice;
        this.towerSellPrice = towerSellPrice;
        this.towerUnlockLevel = towerUnlockLevel;
        this.towerAbility = towerAbility;
        this.towerChooseWeapon = towerChooseWeapon;
        this.towerUpgrade = towerUpgrade;
        this.towerSize = towerSize;

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
                                                                selectFile(labelsResource
                                                                        .getString("Image"),
                                                                           labelsResource
                                                                                   .getString("Photos"));
                                                            }
                                                            catch (IOException e1) {
                                                                DialogueBoxFactory
                                                                        .createErrorDialogueBox(dialogueBoxResource
                                                                                .getString("UnableToOpen"),
                                                                                                dialogueBoxResource
                                                                                                        .getString("TryAgain"));
                                                            }
                                                        }));
        vbox.getChildren()
                .add(BoxFactory.createHBoxWithLabelandNode(labelsResource.getString("Name"),
                                                           towerName.getInstanceAsNode()));
        vbox.getChildren()
        .add(BoxFactory.createHBoxWithLabelandNode(labelsResource.getString("Size"),
                                                   towerSize.getInstanceAsNode()));
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
        if (chosenFile != null) {

        }
    }

    @Override
    public Node getInstanceAsNode () {
        return completeView;
    }

}
