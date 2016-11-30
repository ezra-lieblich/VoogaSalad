package authoring.editorview.level.subviews;

import javafx.scene.Node;
import javafx.scene.layout.HBox;


public class LevelChooserView {

    private HBox hbox;

    public LevelChooserView () {
        hbox = new HBox();
        buildLevelComboBox();
    }

    public Node getInstanceAsNode () {
        return hbox;
    }

    private void buildLevelComboBox () {

    }

    private void displayLevelToUpdate () {

    }

}
