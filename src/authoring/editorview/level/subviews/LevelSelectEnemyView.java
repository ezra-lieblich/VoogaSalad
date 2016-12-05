package authoring.editorview.level.subviews;

import java.util.ArrayList;
import java.util.List;
import authoring.editorview.level.ILevelSetView;
import authoring.editorview.level.LevelEditorViewDelegate;
import authoring.editorview.path.NameIdPair;
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
        ComboBox<Object> enemyChooser =
                ComboBoxFactory.makeComboBox("Add enemy",
                                             e -> getEnemyID((String) this.enemyChooser.getValue()),
                                             enemyOptions);
        return enemyChooser;
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

    public void updateEnemyList (List<NameIdPair> fullEnemyList) {
        List<String> enemyNames = new ArrayList<>();
        for (NameIdPair n : fullEnemyList) {
            enemyNames.add(n.getName());
        }
        enemyChooser.getItems().add(enemyNames);
    }

}
