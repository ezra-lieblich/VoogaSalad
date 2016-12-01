package authoring.editorview.gamesettings;

import authoring.editorview.EditorViewController;
import authoring.editorview.gamesettings.subviews.GameNameView;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


public class GameSettingsEditorView extends EditorViewController
        implements IGameSettingsEditorView {

    
    private VBox gameConditionsRoot;
    private GameNameView gameNameView;

    public GameSettingsEditorView (int aWidth, int aHeight) {
        this.gameConditionsRoot = new VBox(10);
        this.gameNameView = new GameNameView();
    }

    @Override
    public Node getInstanceAsNode () {
        return gameConditionsRoot;
    }

    @Override
    public void setDelegate (GameSettingsEditorViewDelegate delegate) {
        gameNameView.setDelegate(delegate);;
    }
    
    private void addViewComponents(){
    	gameConditionsRoot.getChildren().add(gameNameView.getInstanceAsNode());
    }

}
