package authoring.editorview.enemy.subviews.editorfields;

import java.io.File;
import java.util.ResourceBundle;
import authoring.editorview.enemy.EnemyAuthoringViewDelegate;
import authoring.editorview.enemy.EnemySetView;
import authoring.utilityfactories.DialogueBoxFactory;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class EnemyImageView implements EnemySetView {

    @SuppressWarnings("unused")
    private EnemyAuthoringViewDelegate delegate;
    private String imagePath;
    private ImageView enemyImage;

    private final int CHARACTER_SIZE = 250;

    public EnemyImageView (ResourceBundle labelsResource) {
        enemyImage = new ImageView();
        enemyImage.setFitHeight(CHARACTER_SIZE);
        enemyImage.setFitWidth(CHARACTER_SIZE);
    }

    public void updateEnemyImagePath (String imagePath) {
        this.imagePath = imagePath;
        loadEnemyImage();
    }

    private void loadEnemyImage () {
        try {
            File file = new File(imagePath);
            Image image = new Image(file.toURI().toString());
            enemyImage.setImage(image);
        }
        catch (Exception e) {
            Image image2 =
                    new Image(getClass().getClassLoader().getResourceAsStream("questionmark.png"));
            enemyImage.setImage(image2);
            DialogueBoxFactory.createErrorDialogueBox("Could not load file",
                                                      "Try new photo");
        }
    }

    @Override
    public Node getInstanceAsNode () {
        return enemyImage;
    }

    @Override
    public void setDelegate (EnemyAuthoringViewDelegate delegate) {
        this.delegate = delegate;
    }

}
