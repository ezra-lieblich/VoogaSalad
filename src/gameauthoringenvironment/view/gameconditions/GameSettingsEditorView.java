package gameauthoringenvironment.view.gameconditions;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;


public class GameSettingsEditorView implements IGameSettingsEditorView {

    private Pane gameConditionsPane;

    public GameSettingsEditorView () {
        this.gameConditionsPane = new Pane();
        makeTextField("Enemy");
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
