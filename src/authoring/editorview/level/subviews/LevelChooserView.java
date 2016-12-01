package authoring.editorview.level.subviews;

import java.util.ResourceBundle;
import authoring.editorview.level.ILevelSetView;
import authoring.editorview.level.LevelEditorViewDelegate;
import authoring.utilityfactories.ComboBoxFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;


public class LevelChooserView implements ILevelSetView {

    private ComboBox<Object> levelChooser;
    private LevelEditorViewDelegate delegate;

    public LevelChooserView (ResourceBundle levelsResource) {
        ObservableList<Object> effectOptions = setList();
        buildLevelComboBox(effectOptions);
    }

    @Override
    public Node getInstanceAsNode () {
        return levelChooser;
    }

    private ObservableList<Object> setList () {
        ObservableList<Object> effectOptions =
                FXCollections.observableArrayList("1", "2");
        return effectOptions;
    }

    private void buildLevelComboBox (ObservableList<Object> effectOptions) {
        levelChooser = ComboBoxFactory.makeComboBox("Select level to edit", e -> delegate
                .onUserEnteredEditLevel((String) levelChooser
                        .getValue()), effectOptions);
    }

    @Override
    public void setDelegate (LevelEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

}
