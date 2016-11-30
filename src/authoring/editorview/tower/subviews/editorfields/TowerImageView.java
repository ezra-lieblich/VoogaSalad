package authoring.editorview.tower.subviews.editorfields;

import java.awt.image.BufferedImage;
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

    public TowerImageView (ResourceBundle labelsResource) {
        this.labelsResource = labelsResource;
        towerImage = new ImageView();
        loadTowerImage();
    }

    public void updateTowerImagePath (String imagePath) {
        this.imagePath = imagePath;
        loadTowerImage();
    }

    @Override
    public void setDelegate (TowerEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    private void loadTowerImage () {
        BufferedImage imageRead;
        try {
            imageRead = ImageIO.read(getClass().getClassLoader().getResourceAsStream(imagePath));
            Image image2 = SwingFXUtils.toFXImage(imageRead, null);
            towerImage.setImage(image2);
            //delegate.onUserEnteredTowerImagePath(imagePath);
        }
        catch (Exception e) {
            System.out.println("Here");
            Image image2 = new Image(getClass().getClassLoader().getResourceAsStream("questionmark.png"));
            towerImage.setImage(image2);
            DialogueBoxFactory.createErrorDialogueBox("Could not load file",
            "Try new photo");
        }
    }

    @Override
    public Node getInstanceAsNode () {
        return towerImage;
    }

}
