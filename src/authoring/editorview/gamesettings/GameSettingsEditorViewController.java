package authoring.editorview.gamesettings;

import authoring.editorview.EditorViewController;
import engine.settings.GameModeManagerController;


public class GameSettingsEditorViewController extends EditorViewController
        implements GameSettingsEditorViewDelegate {

    private IGameSettingsEditorView gameView;
    private GameModeManagerController gameSettingsDataSource;

    public GameSettingsEditorViewController (int editorWidth, int editorHeight) {
        gameView = GameSettingsEditorViewFactory.build(editorWidth, editorHeight);
        gameView.setDelegate(this);
        this.view = gameView;
    }

    public void setGameSettingsDataSource (GameModeManagerController source) {
        this.gameSettingsDataSource = source;
        this.gameSettingsDataSource.addTypeBankListener(this.gameView);
    }

    @Override
    public void onUserEnteredGameLives (String lives) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUserEnteredGameNames (String name) {
        // TODO Auto-generated method stub

    }
}
