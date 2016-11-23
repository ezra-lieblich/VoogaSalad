package authoring.editorview.tower.subviews.editorfields;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ResourceBundle;
import javax.imageio.ImageIO;
import authoring.editorview.tower.TowerEditorViewDelegate;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 * 
 * @author Kayla Schulz
 * @author Diane Hadley
 *
 */

public class TowerImageView {

    private TowerEditorViewDelegate delegate;
    private String imagePath;
    private ImageView towerImage;

    private static final String RESOURCE_FILE_NAME = "resources/GameAuthoringTower";
    private ResourceBundle towerResources = ResourceBundle.getBundle(RESOURCE_FILE_NAME);

    public TowerImageView () throws IOException {
        towerImage = loadTowerImage();
    }

    public void updateTowerImagePath (String imagePath) {
        this.imagePath = imagePath;
    }

    public void setDelegate (TowerEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    private ImageView loadTowerImage () throws IOException {
        BufferedImage imageRead;
        ImageView myImageView = new ImageView();
        try {
            imageRead = ImageIO.read(getClass().getClassLoader().getResourceAsStream(imagePath));
            Image image2 = SwingFXUtils.toFXImage(imageRead, null);
            myImageView.setImage(image2);
            delegate.onUserEnteredTowerImagePath(imagePath);
        }
        catch (Exception e) {
            imageRead =
                    ImageIO.read(getClass().getClassLoader()
                            .getResourceAsStream(towerResources.getString("DefaultImagePath")));
            Image image2 = SwingFXUtils.toFXImage(imageRead, null);
            myImageView.setImage(image2);
            System.out.println("Unable to find picture in files");
        }
        return myImageView;
    }

    public ImageView getTowerImage () {
        return towerImage;
    }

}
