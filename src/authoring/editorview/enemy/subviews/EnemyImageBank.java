package authoring.editorview.enemy.subviews;

import java.util.ArrayList;
import java.util.List;
import authoring.editorview.ImageBank;
import authoring.editorview.ListCellData;
import authoring.editorview.ListDataSource;
import authoring.editorview.enemy.EnemyEditorViewDelegate;
import authoring.utilityfactories.ButtonFactory;
import javafx.scene.Node;
import javafx.scene.control.Button;


/**
 * 
 * @author Kayla Schulz, Andrew Bihl
 *
 */
public class EnemyImageBank extends ImageBank {
    private EnemyEditorViewDelegate delegate;

    // TODO: Keep mapping in array of enemy IDs to list indices in order to be able to delete and
    // maintain order

    public EnemyImageBank () {
        super();
        Button newEnemyButton = ButtonFactory.makeButton("New Enemy", e -> {
            delegate.onUserPressedCreateEnemy();
        });
        this.items.add(newEnemyButton);
    }

    public void setDelegate (EnemyEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    public void updateEnemyBank (List<Integer> activeEnemies) {
        super.updateBank(activeEnemies);
    }

    @Override
    protected void userSelectedRow (int index) {
        int selectedEnemy = this.itemIDs.get(index);
        this.delegate.onUserSelectedEnemy(selectedEnemy);
    }
}
