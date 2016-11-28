package authoring.editorview.weapon.subviews.editorfields;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ResourceBundle;
import javax.imageio.ImageIO;
import authoring.editorview.weapon.IWeaponEditorView;
import authoring.editorview.weapon.WeaponEditorViewDelegate;
import authoring.utilityfactories.DialogueBoxFactory;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class WeaponImageView implements IWeaponEditorView {

    private WeaponEditorViewDelegate delegate;
    private ResourceBundle labelsResource;
    private String imagePath;
    private ImageView weaponImage;

    public WeaponImageView (ResourceBundle labelsResource) throws IOException {
        this.labelsResource = labelsResource;
        weaponImage = loadWeaponImage();
    }

    public void updateWeaponImagePath (String imagePath) {
        this.imagePath = imagePath;
    }

    private ImageView loadWeaponImage () throws IOException {
        BufferedImage imageRead;
        ImageView myImageView = new ImageView();
        try {
            imageRead = ImageIO.read(getClass().getClassLoader().getResourceAsStream(imagePath));
            Image image2 = SwingFXUtils.toFXImage(imageRead, null);
            myImageView.setImage(image2);
            delegate.onUserEnteredWeaponImage(imagePath);
        }
        catch (Exception e) {
            imageRead =
                    ImageIO.read(getClass().getClassLoader()
                            .getResourceAsStream(labelsResource.getString("DefaultImagePath")));
            Image image2 = SwingFXUtils.toFXImage(imageRead, null);
            myImageView.setImage(image2);
            // TODO: Undo comment on this when model and view are connected
            // DialogueBoxFactory.createErrorDialogueBox("Could not load file",
            // "Try new photo");
        }
        return myImageView;
    }

    @Override
    public Node getInstanceAsNode () {
        return weaponImage;
    }

    @Override
    public void setDelegate (WeaponEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

}
