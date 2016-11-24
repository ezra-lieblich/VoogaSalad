package authoring.editorview.enemy.subviews;

import java.io.IOException;
import java.util.ResourceBundle;
import authoring.editorview.PhotoFileChooser;
import authoring.editorview.enemy.subviews.editorfields.EnemyFrequencyField;
import authoring.editorview.enemy.subviews.editorfields.EnemyImageView;
import authoring.editorview.enemy.subviews.editorfields.EnemyNameField;
import authoring.editorview.enemy.subviews.editorfields.EnemyReactionsView;
import authoring.editorview.enemy.subviews.editorfields.EnemySpeedField;
import authoring.utilityfactories.BoxFactory;
import authoring.utilityfactories.ButtonFactory;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;


/**
 * 
 * @author Kayla Schulz
 * @author Diane Hadley
 *
 */

public class EnemyEffectView extends PhotoFileChooser {

    private ScrollPane enemyEffectView;
    private VBox vbox;

    private EnemyFrequencyField enemyFrequency;
    private EnemyImageView enemyImage;
    private EnemyNameField enemyName;
    private EnemyReactionsView enemyReactions;
    private EnemySpeedField enemySpeed;
    
    private ResourceBundle labelsResource;
    private final String ENEMY_EFFECT_RESOURCE_PATH = "resources/GameAuthoringEnemy";

    public EnemyEffectView (EnemyFrequencyField enemyFrequency,
                            EnemyImageView enemyImage,
                            EnemyNameField enemyName,
                            EnemyReactionsView enemyReactions,
                            EnemySpeedField enemySpeed) {
        enemyEffectView = new ScrollPane();
        vbox = new VBox(10);
        enemyEffectView.setContent(vbox);
        
        this.enemyFrequency = enemyFrequency;
        this.enemyImage = enemyImage;
        this.enemyName = enemyName;
        this.enemyReactions = enemyReactions;
        this.enemySpeed = enemySpeed;
        
        labelsResource = ResourceBundle.getBundle(ENEMY_EFFECT_RESOURCE_PATH);
        
        buildViewComponents();
    }
    
    private void buildViewComponents () {
        ImageView myImageView = enemyImage.getEnemyImage();

        vbox.getChildren().add(myImageView);
        vbox.getChildren().add(ButtonFactory.makeButton(labelsResource.getString("Image"),
                                                        e -> {
                                                            try {
                                                                selectFile("Select new enemy image",
                                                                           "Photos: ");
                                                            }
                                                            catch (IOException e1) {
                                                                // TODO Fix this for better user
                                                                // output
                                                                e1.printStackTrace();
                                                            }
                                                        }));
        vbox.getChildren()
                .add(BoxFactory.createHBoxWithTextField(labelsResource.getString("Name"),
                                                        enemyName.getEnemyNameField()));
        vbox.getChildren()
                .add(BoxFactory.createHBoxWithTextField(labelsResource.getString("Frequency"),
                                                        enemyFrequency.getEnemyFrequencyField()));
        vbox.getChildren()
                .add(BoxFactory.createHBoxWithTextField(labelsResource.getString("Reaction"),
                                                        enemyReactions.getEnemyReactionField()));
        vbox.getChildren()
                .add(BoxFactory.createHBoxWithTextField(labelsResource.getString("Speed"),
                                                        enemySpeed.getEnemySpeedField()));
    }

    public Node getInstanceAsNode () {
        return enemyEffectView;
    }

    @Override
    public void openFileChooser (FileChooser chooseFile) throws IOException {
        // TODO Auto-generated method stub
        
    }

}
