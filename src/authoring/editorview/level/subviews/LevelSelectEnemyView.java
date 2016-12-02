package authoring.editorview.level.subviews;

import java.util.List;
import authoring.editorview.level.ILevelSetView;
import authoring.editorview.level.LevelEditorViewDelegate;
import authoring.utilityfactories.ComboBoxFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;


public class LevelSelectEnemyView implements ILevelSetView {

    private LevelEditorViewDelegate delegate;
    private ComboBox<Object> enemyChooser;

    public LevelSelectEnemyView () {
        ObservableList<Object> enemyOptions = setList();
        enemyChooser = setComboBox(enemyOptions);
    }

    private ObservableList<Object> setList () {
        ObservableList<Object> enemyOptions = FXCollections.observableArrayList();
        return enemyOptions;
    }

    private ComboBox<Object> setComboBox (ObservableList<Object> enemyOptions) {
        ComboBoxFactory.makeComboBox("Add enemy", e -> getEnemyID((String) enemyChooser.getValue()),
                                     enemyOptions);
        return null;
    }

    private void getEnemyID (String enemyName) {
        // Name ID pair area
        // delegate.onUserEnteredAddEnemy();
    }

    @Override
    public Node getInstanceAsNode () {
        return enemyChooser;
    }

    @Override
    public void setDelegate (LevelEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    public void updateEnemyList (List<String> fullEnemyList) {
        enemyChooser.getItems().add(fullEnemyList);
    }

}
