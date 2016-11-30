package authoring.editorview.enemy.subviews.editorfields;

import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;
import authoring.editorview.enemy.EnemyEditorViewDelegate;
import authoring.editorview.enemy.IEnemySetView;
import authoring.utilityfactories.DialogueBoxFactory;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class EnemyImageView implements IEnemySetView {

    private EnemyEditorViewDelegate delegate;
    private String imagePath;
    private ImageView enemyImage;
    private ResourceBundle labelsResource;
    
    private final int CHARACTER_SIZE = 250;

    public EnemyImageView (ResourceBundle labelsResource) throws IOException {
        this.labelsResource = labelsResource;
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
    public void setDelegate (EnemyEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

}
