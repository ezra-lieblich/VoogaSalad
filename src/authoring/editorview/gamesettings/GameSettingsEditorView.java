package authoring.editorview.gamesettings;

import authoring.editorview.EditorViewController;
import javafx.scene.Node;
import javafx.scene.layout.Pane;


public class GameSettingsEditorView extends EditorViewController
        implements IGameSettingsEditorView {

    private GameSettingsEditorViewDelegate delegate;
    private Pane gameConditionsPane;

    public GameSettingsEditorView (int aWidth, int aHeight) {
        this.gameConditionsPane = new Pane();
    }

    @Override
    public Node getInstanceAsNode () {
        return gameConditionsPane;
    }

    @Override
    public void setDelegate (GameSettingsEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

}
