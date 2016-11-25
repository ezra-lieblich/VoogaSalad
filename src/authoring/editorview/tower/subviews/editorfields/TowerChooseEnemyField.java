package authoring.editorview.tower.subviews.editorfields;

import authoring.editorview.tower.ITowerEditorView;
import authoring.editorview.tower.TowerEditorViewDelegate;
import authoring.utilityfactories.ComboBoxFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;


public class TowerChooseEnemyField implements ITowerEditorView {

    private ComboBox<Object> towerChooseEnemyBox;
    private TowerEditorViewDelegate delegate;

    public TowerChooseEnemyField () {
        ObservableList<Object> enemyOptions = setList();
        createComboBox(enemyOptions);
    }

    private ObservableList<Object> setList () {
        ObservableList<Object> enemyOptions =
                FXCollections.observableArrayList("IDK", "Sorry");
        return enemyOptions;
    }

    private void createComboBox (ObservableList<Object> enemyOptions) {
        towerChooseEnemyBox =
                ComboBoxFactory.makeComboBox("Set tower enemy: ", e -> delegate
                        .onUserEnteredTowerChosenEnemy((String) towerChooseEnemyBox.getValue()),
                                             enemyOptions);
    }

    @Override
    public void setDelegate (TowerEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public Node getInstanceAsNode () {
        return towerChooseEnemyBox;
    }

    public void updateTowerChosenEnemy (String chosenEnemy) {
        towerChooseEnemyBox.setValue(chosenEnemy);
    }

}
