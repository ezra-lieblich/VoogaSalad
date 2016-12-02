package authoring.editorview.level.subviews;

import authoring.editorview.level.ILevelSetView;
import authoring.editorview.level.LevelEditorViewDelegate;
import authoring.utilityfactories.ComboBoxFactory;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;


public class LevelSelectEnemyView implements ILevelSetView {

    private LevelEditorViewDelegate delegate;
    private ComboBox<Object> enemyChooser;

    public LevelSelectEnemyView () {
        enemyChooser = setComboBox();
    }

    private ComboBox<Object> setComboBox () {
        //ComboBoxFactory.makeComboBox("Add enemy", e -> delegate.onUserEnteredAddEnemy(enemyID, numEnemies), options);
        return null;
    }

    @Override
    public Node getInstanceAsNode () {
        return enemyChooser;
    }

    @Override
    public void setDelegate (LevelEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

}
