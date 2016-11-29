package authoring.editorview.enemy.subviews.editorfields;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ResourceBundle;
import javax.imageio.ImageIO;
import authoring.editorview.enemy.EnemyEditorViewDelegate;
import authoring.editorview.enemy.IEnemyEditorView;
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
public class EnemyImageView implements IEnemyEditorView {

    private EnemyEditorViewDelegate delegate;
    private String imagePath;
    private ImageView enemyImage;
    private ResourceBundle labelsResource;

    public EnemyImageView (ResourceBundle labelsResource) throws IOException {
        this.labelsResource = labelsResource;
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
            // TODO: Undo comment on this when model and view are connected
            // DialogueBoxFactory.createErrorDialogueBox("Could not load file",
            // "Try new photo");
        }
        return myImageView;
    }

    @Override
    public Node getInstanceAsNode () {
        return enemyImage;
    }

    @Override
    public void setDelegate (EnemyEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

}
