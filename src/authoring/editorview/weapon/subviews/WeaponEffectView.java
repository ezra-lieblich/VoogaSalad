package authoring.editorview.weapon.subviews;

import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;
import authoring.editorview.PhotoFileChooser;
import authoring.editorview.weapon.WeaponEditorViewDelegate;
import authoring.editorview.weapon.subviews.editorfields.WeaponCollisionEffectField;
import authoring.editorview.weapon.subviews.editorfields.WeaponDamageField;
import authoring.editorview.weapon.subviews.editorfields.WeaponFireRateField;
import authoring.editorview.weapon.subviews.editorfields.WeaponImageView;
import authoring.editorview.weapon.subviews.editorfields.WeaponNameField;
import authoring.editorview.weapon.subviews.editorfields.WeaponPathField;
import authoring.editorview.weapon.subviews.editorfields.WeaponRangeField;
import authoring.editorview.weapon.subviews.editorfields.WeaponSpeedField;
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
public class WeaponEffectView extends PhotoFileChooser {

    private VBox vboxView;
    private ScrollPane completeView;
    private WeaponEditorViewDelegate delegate;

    private ResourceBundle labelsResource;
    private File chosenFile;
    private WeaponNameField weaponName;
    private WeaponSpeedField weaponSpeed;
    private WeaponFireRateField weaponFireRate;
    private WeaponRangeField weaponRange;
    private WeaponDamageField weaponDamage;
    private WeaponCollisionEffectField weaponCollision;
    private WeaponPathField weaponPath;
    private WeaponImageView weaponImage;

    private final String WEAPON_EFFECT_RESOURCE_PATH = "resources/GameAuthoringWeapon";

    public WeaponEffectView (WeaponNameField weaponName,
                             WeaponSpeedField weaponSpeed,
                             WeaponFireRateField weaponFireRate,
                             WeaponRangeField weaponRange,
                             WeaponDamageField weaponDamage,
                             WeaponCollisionEffectField weaponCollision,
                             WeaponPathField weaponPath,
                             WeaponImageView weaponImage)
        throws IOException {
        this.weaponName = weaponName;
        this.weaponSpeed = weaponSpeed;
        this.weaponFireRate = weaponFireRate;
        this.weaponRange = weaponRange;
        this.weaponDamage = weaponDamage;
        this.weaponCollision = weaponCollision;
        this.weaponPath = weaponPath;
        this.weaponImage = weaponImage;
        labelsResource = ResourceBundle.getBundle(WEAPON_EFFECT_RESOURCE_PATH);
        vboxView = new VBox(10);
        completeView = new ScrollPane();
        completeView.setContent(vboxView);

        buildViewComponents();
    }

    public void setDelegate (WeaponEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    private void buildViewComponents () throws IOException {
        Node myImageView = weaponImage.getInstanceAsNode();
        vboxView.getChildren().add(myImageView);
        vboxView.getChildren().add(ButtonFactory.makeButton(labelsResource.getString("Image"),
                                                            e -> {
                                                                try {
                                                                    selectFile("Select new weapon image",
                                                                               "Photos: ");
                                                                }
                                                                catch (IOException e1) {
                                                                    // TODO Fix this for better user
                                                                    // output
                                                                    e1.printStackTrace();
                                                                }
                                                            }));
        vboxView.getChildren()
                .add(BoxFactory.createHBoxWithLabelandNode(labelsResource.getString("Name"),
                                                        weaponName.getInstanceAsNode()));
        vboxView.getChildren()
                .add(BoxFactory.createHBoxWithLabelandNode(labelsResource.getString("Rate"),
                                                        weaponFireRate.getInstanceAsNode()));
        vboxView.getChildren()
                .add(BoxFactory.createHBoxWithLabelandNode(labelsResource.getString("Speed"),
                                                        weaponSpeed.getInstanceAsNode()));
        vboxView.getChildren()
                .add(BoxFactory.createHBoxWithLabelandNode(labelsResource.getString("Range"),
                                                        weaponRange.getInstanceAsNode()));
        vboxView.getChildren()
                .add(BoxFactory.createHBoxWithLabelandNode(labelsResource.getString("Damage"),
                                                        weaponDamage.getInstanceAsNode()));
        vboxView.getChildren().add(weaponCollision.getInstanceAsNode());
        vboxView.getChildren().add(weaponPath.getInstanceAsNode());
    }

    public ScrollPane getInstanceAsNode () {
        return completeView;
    }

    /**
     * Update fields methods
     */

    public void createNewWeapon () {
        // Call all of the other update methods to get the default values
    }

    @Override
    public void openFileChooser (FileChooser chooseFile) {
        chosenFile = chooseFile.showOpenDialog(new Stage());
        // if not null -> get imageFilePath and update the instance variable
        // then loadImage through the created method above
    }

}
