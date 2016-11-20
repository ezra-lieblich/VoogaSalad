package authoring.editorview.gamesettings;

import authoring.editorview.EditorViewController;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;


public class GameSettingsEditorView extends EditorViewController implements IGameSettingsEditorView {

    private Pane gameConditionsPane;

    public GameSettingsEditorView (int aWidth, int aHeight) {
        this.gameConditionsPane = new Pane();
        makeTextField("Number of Columns: ");
    }

    private void makeTextField (String label) {
        HBox hbox = new HBox();
        Label labelBox = new Label(label);
        TextField textField = new TextField();
        hbox.getChildren().addAll(labelBox, textField);
        gameConditionsPane.getChildren().add(hbox);
    }

    @Override
    public Node getInstanceAsNode () {
        return gameConditionsPane;
    }

}
