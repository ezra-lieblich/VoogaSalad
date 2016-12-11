package authoring.editorview.gamesettings;

import authoring.editorview.EditorViewController;
import engine.settings.GameModeManagerController;


public class GameSettingsAuthoringViewController extends EditorViewController
        implements GameSettingsAuthoringViewDelegate {

    private IGameSettingsUpdateView gameView;
    private GameModeManagerController gameSettingsDataSource;

    public GameSettingsAuthoringViewController (int editorWidth, int editorHeight) {
        IGameSettingsSetView myView =
                GameSettingsAuthoringViewFactory.build(editorWidth, editorHeight);
        myView.setDelegate(this);
        this.view = myView;
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

    @Override
    public void onUserEnteredGameImage (String imagePath) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUserEnteredImageSize (String imageSize) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUserEnteredWinningConditions (String winConditions) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUserEnteredLosingConditions (String loseConditions) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onUserEnteredGameMoney (String money) {
        // TODO Auto-generated method stub

    }
}
