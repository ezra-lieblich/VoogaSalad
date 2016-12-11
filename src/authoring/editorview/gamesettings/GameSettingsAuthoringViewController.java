package authoring.editorview.gamesettings;

import authoring.editorview.EditorViewController;
import engine.settings.GameModeManagerController;


public class GameSettingsAuthoringViewController extends EditorViewController
        implements GameSettingsAuthoringViewDelegate {

    private IGameSettingsUpdateView gameView;
    private GameModeManagerController gameSettingsDataSource;
    private int activeID = 0;

    public GameSettingsAuthoringViewController (int editorWidth, int editorHeight) {
        gameView = GameSettingsAuthoringViewFactory.build(editorWidth, editorHeight);
        gameView.setDelegate(this);
        this.view = gameView;
    }

    public void setGameSettingsDataSource (GameModeManagerController source) {
        this.gameSettingsDataSource = source;
        this.gameSettingsDataSource.addTypeBankListener(this.gameView);
        gameSettingsDataSource.createType(this.gameView);
    }

    @Override
    public void onUserEnteredGameLives (int lives) {
        this.gameSettingsDataSource.setNumberofLives(activeID, lives);
    }
    
    

    @Override
    public void onUserEnteredGameNames (String name) {
        this.gameSettingsDataSource.setName(activeID, name);

    }

    @Override
    public void onUserEnteredGameImage (String imagePath) {
        this.gameSettingsDataSource.setImagePath(activeID, imagePath);

    }
    
    @Override
    public void onUserEnteredGameMoney (int money) {
        this.gameSettingsDataSource.setMoney(activeID, money);

    }

    @Override
	public void onUserEnteredGridSize(int size) {
		// TODO Auto-generated method stub
		
	}

    @Override
    public void onUserEnteredWinningConditions (String winConditions) {
        //TODO

    }

    @Override
    public void onUserEnteredLosingConditions (String loseConditions) {
        // TODO Auto-generated method stub

    }

	

    
}
