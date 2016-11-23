package authoring.editorview.enemy.subviews;

import java.util.ResourceBundle;
import authoring.editorview.enemy.subviews.editorfields.EnemyFrequencyField;
import authoring.editorview.enemy.subviews.editorfields.EnemyImageView;
import authoring.editorview.enemy.subviews.editorfields.EnemyNameField;
import authoring.editorview.enemy.subviews.editorfields.EnemyReactionsView;
import authoring.editorview.enemy.subviews.editorfields.EnemySpeedField;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;


/**
 * 
 * @author Diane Hadley
 *
 */

public class EnemyEffectView {

    private ScrollPane enemyEffectView;

    private static final String RESOURCE_FILE_NAME = "resources/GameAuthoringEnemy";
    private ResourceBundle enemyResources = ResourceBundle.getBundle(RESOURCE_FILE_NAME);
    
    private EnemyFrequencyField enemyFrequency;
    private EnemyImageView enemyImage;
    private EnemyNameField enemyName;
    private EnemyReactionsView enemyReactions;
    private EnemySpeedField enemySpeed;

    public EnemyEffectView (EnemyFrequencyField enemyFrequency,
                            EnemyImageView enemyImage,
                            EnemyNameField enemyName,
                            EnemyReactionsView enemyReactions,
                            EnemySpeedField enemySpeed) {
        enemyEffectView = new ScrollPane();

    }

    public Node getInstanceAsNode () {
        return enemyEffectView;
    }

}
