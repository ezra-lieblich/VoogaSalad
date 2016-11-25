package authoring.editorview.weapon.subviews.editorfields;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ResourceBundle;
import javax.imageio.ImageIO;
import authoring.editorview.weapon.IWeaponEditorView;
import authoring.editorview.weapon.WeaponEditorViewDelegate;
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

    private final String WEAPON_EFFECT_RESOURCE_PATH = "resources/GameAuthoringWeapon";

    public WeaponImageView () throws IOException {
        labelsResource = ResourceBundle.getBundle(WEAPON_EFFECT_RESOURCE_PATH);
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
            System.out.println("Unable to find picture in files");
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
