package authoring.editorview.enemy.subviews;

import java.util.List;
import authoring.editorview.PhotoFileChooser;
import authoring.editorview.enemy.EnemyEditorViewDelegate;
import authoring.utilityfactories.ButtonFactory;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.stage.FileChooser;


public class EnemyImageBank extends PhotoFileChooser {

    private EnemyEditorViewDelegate delegate;
    private ScrollPane enemyBank;

    public EnemyImageBank () {
        enemyBank = new ScrollPane();
        Button createNewEnemy =
                ButtonFactory.makeButton("Create New Enemy",
                                         e -> selectFile("Photos: ", "Select new enemy image"));
        enemyBank.setContent(createNewEnemy);
    }

    public void setDelegate (EnemyEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    public Node getInstanceAsNode () {
        return enemyBank;
    }

    public void updateEnemyBank (List<Integer> activeEnemies) {
        // update each weapon in bank
    }

    @Override
    public void openFileChooser (FileChooser chooseFile) {
        // TODO Auto-generated method stub

    }

}
