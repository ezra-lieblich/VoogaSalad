package authoring.editorview.tower.subviews.editorfields;

import java.io.File;
import java.util.ResourceBundle;
import authoring.editorview.tower.ITowerSetView;
import authoring.editorview.tower.TowerAuthoringViewDelegate;
import authoring.utilityfactories.DialogueBoxFactory;
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

    @SuppressWarnings("unused")
    private TowerAuthoringViewDelegate delegate;
    private String imagePath;
    private ImageView towerImage;
    // private ResourceBundle labelsResource;

    private final int CHARACTER_SIZE = 250;

    public TowerImageView (ResourceBundle labelsResource) {
        // this.labelsResource = labelsResource;
        towerImage = new ImageView();
        towerImage.setFitHeight(CHARACTER_SIZE);
        towerImage.setFitWidth(CHARACTER_SIZE);
    }

    public void updateTowerImagePath (String imagePath) {
        this.imagePath = imagePath;
        loadTowerImage();
    }

    @Override
    public void setDelegate (TowerAuthoringViewDelegate delegate) {
        this.delegate = delegate;
    }

    private void loadTowerImage () {
        try {
            File file = new File(imagePath);
            Image image = new Image(file.toURI().toString());
            towerImage.setImage(image);
        }
        catch (Exception e) {
            Image image2 =
                    new Image(getClass().getClassLoader().getResourceAsStream("questionmark.png"));
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
