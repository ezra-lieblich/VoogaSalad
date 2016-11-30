package authoring.editorview.tower.subviews.editorfields;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ResourceBundle;
import javax.imageio.ImageIO;
import authoring.editorview.tower.ITowerSetView;
import authoring.editorview.tower.TowerEditorViewDelegate;
import authoring.utilityfactories.DialogueBoxFactory;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 * 
 * @author Kayla Schulz
 * @author Diane Hadley
 *
 */

public class TowerImageView implements ITowerSetView {

    private TowerEditorViewDelegate delegate;
    private String imagePath;
    private ImageView towerImage;
    private ResourceBundle labelsResource;

    public TowerImageView (ResourceBundle labelsResource) throws IOException {
        this.labelsResource = labelsResource;
        towerImage = loadTowerImage();
    }

    public void updateTowerImagePath (String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
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
        return towerImage;
    }

}
