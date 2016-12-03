package authoring.editorview.weapon.subviews;

import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;
import authoring.editorview.PhotoFileChooser;
import authoring.editorview.weapon.WeaponEditorViewDelegate;
import authoring.editorview.weapon.subviews.editorfields.WeaponCollisionEffectField;
import authoring.editorview.weapon.subviews.editorfields.WeaponFireRateField;
import authoring.editorview.weapon.subviews.editorfields.WeaponImageView;
import authoring.editorview.weapon.subviews.editorfields.WeaponNameField;
import authoring.editorview.weapon.subviews.editorfields.WeaponPathField;
import authoring.editorview.weapon.subviews.editorfields.WeaponRangeField;
import authoring.editorview.weapon.subviews.editorfields.WeaponSizeField;
import authoring.editorview.weapon.subviews.editorfields.WeaponSpeedField;
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
    private WeaponCollisionEffectField weaponCollision;
    private WeaponPathField weaponPath;
    private WeaponImageView weaponImage;
    private WeaponSizeField weaponSize;

    private ResourceBundle dialogueBoxResource;

    public WeaponEffectView (WeaponNameField weaponName,
                             WeaponSpeedField weaponSpeed,
                             WeaponFireRateField weaponFireRate,
                             WeaponRangeField weaponRange,
                             WeaponCollisionEffectField weaponCollision,
                             WeaponPathField weaponPath,
                             WeaponImageView weaponImage,
                             WeaponSizeField weaponSize,
                             ResourceBundle labelsResource,
                             ResourceBundle dialogueBoxResource)
        throws IOException {
        this.labelsResource = labelsResource;
        this.dialogueBoxResource = dialogueBoxResource;
        this.weaponImage = weaponImage;
        this.weaponName = weaponName;
        this.weaponSpeed = weaponSpeed;
        this.weaponFireRate = weaponFireRate;
        this.weaponRange = weaponRange;
        this.weaponCollision = weaponCollision;
        this.weaponPath = weaponPath;

        this.weaponSize = weaponSize;

        vboxView = new VBox(10);
        completeView = new ScrollPane();
        completeView.setContent(vboxView);

        buildViewComponents();
    }

    public void setPaneSize (int width, int height) {
        completeView.setMaxSize(width, height);
        completeView.setMinSize(width, height);
        completeView.setPrefSize(width, height);
    }

    public void setDelegate (WeaponEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    private void buildViewComponents () throws IOException {
        vboxView.getChildren().add(weaponImage.getInstanceAsNode());
        vboxView.getChildren().add(ButtonFactory.makeButton(labelsResource.getString("Image"),
                                                            e -> {
                                                                try {
                                                                    selectFile(labelsResource
                                                                            .getString("Photos"),
                                                                               labelsResource
                                                                                       .getString("NewWeapon"));
                                                                }
                                                                catch (IOException e1) {
                                                                    DialogueBoxFactory
                                                                            .createErrorDialogueBox(dialogueBoxResource
                                                                                    .getString("UnableToOpen"),
                                                                                                    dialogueBoxResource
                                                                                                            .getString("TryAgain"));
                                                                }
                                                            }));
        vboxView.getChildren()
                .add(BoxFactory.createHBoxWithLabelandNode(labelsResource.getString("Name"),
                                                           weaponName.getInstanceAsNode()));
        vboxView.getChildren()
        .add(BoxFactory.createHBoxWithLabelandNode(labelsResource.getString("Size"),
                                                   weaponSize.getInstanceAsNode()));
        vboxView.getChildren()
                .add(BoxFactory.createHBoxWithLabelandNode(labelsResource.getString("FireRate"),
                                                           weaponFireRate.getInstanceAsNode()));
        vboxView.getChildren()
                .add(BoxFactory.createHBoxWithLabelandNode(labelsResource.getString("Speed"),
                                                           weaponSpeed.getInstanceAsNode()));
        vboxView.getChildren()
                .add(BoxFactory.createHBoxWithLabelandNode(labelsResource.getString("Range"),
                                                           weaponRange.getInstanceAsNode()));

        vboxView.getChildren().add(weaponCollision.getInstanceAsNode());
        vboxView.getChildren().add(weaponPath.getInstanceAsNode());
    }

    public ScrollPane getInstanceAsNode () {
        return completeView;
    }

    public void createNewWeapon () {
        // Call all of the other update methods to get the default values
    }

    @Override
    public void openFileChooser (FileChooser chooseFile) {
        chosenFile = chooseFile.showOpenDialog(new Stage());
        if (chosenFile != null) {
            delegate.onUserEnteredWeaponImagePath(chosenFile.toURI().getPath());
        }
        // if not null -> get imageFilePath and update the instance variable
        // then loadImage through the created method above
    }

}
