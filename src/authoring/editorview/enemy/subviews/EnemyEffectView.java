package authoring.editorview.enemy.subviews;

import java.util.ResourceBundle;
import javafx.scene.Node;
import javafx.scene.control.Button;
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

    public EnemyEffectView () {
        enemyEffectView = new ScrollPane();
        initRoot();

    }

    public Node getInstanceAsNode () {
        return enemyEffectView;
    }

    private void initRoot () {
        Button newEnemy = new Button();
        newEnemy.setText(enemyResources.getString("NewEnemy"));
        // newEnemy.setOnAction( (event) -> {
        // enemyView.getEnemySetter();
        // });
        enemyEffectView.setContent(newEnemy);

    }

}
