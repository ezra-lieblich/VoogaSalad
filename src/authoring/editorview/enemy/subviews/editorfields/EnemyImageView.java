package authoring.editorview.enemy.subviews.editorfields;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ResourceBundle;
import javax.imageio.ImageIO;
import authoring.editorview.enemy.EnemyEditorViewDelegate;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class EnemyImageView {

    private EnemyEditorViewDelegate delegate;
    private ResourceBundle labelsResource;
    private String imagePath;
    private ImageView enemyImage;

    // TODO: Make this enemy
    private final String WEAPON_EFFECT_RESOURCE_PATH = "resources/GameAuthoringWeapon";

    public EnemyImageView () throws IOException {
        labelsResource = ResourceBundle.getBundle(WEAPON_EFFECT_RESOURCE_PATH);
        enemyImage = loadEnemyImage();
    }

    public void updateEnemyImagePath (String imagePath) {
        this.imagePath = imagePath;
    }

    private ImageView loadEnemyImage () throws IOException {
        BufferedImage imageRead;
        ImageView myImageView = new ImageView();
        try {
            imageRead = ImageIO.read(getClass().getClassLoader().getResourceAsStream(imagePath));
            Image image2 = SwingFXUtils.toFXImage(imageRead, null);
            myImageView.setImage(image2);
            delegate.onUserEnteredEnemyImagePath(imagePath);
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

    public ImageView getEnemyImage () {
        return enemyImage;
    }

    public void setDelegate (EnemyEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

}
