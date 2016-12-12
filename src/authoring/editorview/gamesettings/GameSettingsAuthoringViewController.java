package authoring.editorview.gamesettings;

import authoring.editorview.EditorViewController;
import engine.path.PathManagerController;
import engine.settings.GameModeManagerController;


public class GameSettingsAuthoringViewController extends EditorViewController
        implements GameSettingsAuthoringViewDelegate {

    private GameSettingsUpdateView gameView;
    private GameModeManagerController gameSettingsDataSource;
    private PathManagerController pathDataSource;
    private int activeID = 0;

    public GameSettingsAuthoringViewController (int editorWidth, int editorHeight) {
        gameView = GameSettingsAuthoringViewFactory.build(editorWidth, editorHeight);
        gameView.setDelegate(this);
        this.view = gameView;
    }

    public void setGameSettingsDataSource (GameModeManagerController source, 
									       PathManagerController pathSource) {
        this.gameSettingsDataSource = source;
        this.pathDataSource = pathSource;
        this.gameSettingsDataSource.addTypeBankListener(this.gameView);
        createNewGame();
    }

	private void createNewGame() {
		gameSettingsDataSource.createType(this.gameView);
		gameView.updateNameDisplay(gameSettingsDataSource.getName(activeID));
		gameView.updateImagePathDisplay(gameSettingsDataSource.getImagePath(activeID));
		gameView.updateNumberofLives(gameSettingsDataSource.getNumberofLives(activeID));
		gameView.updateInitialMoney(gameSettingsDataSource.getMoney(activeID));
		gameView.updateGridSize(gameSettingsDataSource.getGridSize(activeID));
		gameView.updateLosingConditions(gameSettingsDataSource.getLosingConditons(activeID));
		gameView.updateWinningConditions(gameSettingsDataSource.getWinningConditions(activeID));
		gameView.updatePathType(gameSettingsDataSource.getPathType(activeID));		
	}

    @Override
    public void onUserEnteredGameLives (int lives) {
        this.gameSettingsDataSource.setNumberofLives(activeID, lives);
    }
    
    

    @Override
    public void onUserEnteredGameName (String name) {
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
    public void onUserEnteredWinningConditions (String winConditions) {
        this.gameSettingsDataSource.addWinningCondition(activeID, winConditions);

    }

    @Override
    public void onUserEnteredLosingConditions (String loseConditions) {
        this.gameSettingsDataSource.addLosingCondition(activeID, loseConditions);

    }

	@Override
	public String getPathName(int pathID) {
		return this.pathDataSource.getName(pathID);
		
	}

	@Override
	public void onUserEnteredGameGridSize(int size) {
		this.gameSettingsDataSource.setGridSize(activeID, size);
		
	}

	@Override
	public void onUserEnteredGamePathType(String type) {
		this.gameSettingsDataSource.setPathType(activeID, type);
		
	}

	@Override
	public void onUserEnteredPath(int pathID) {
		this.gameSettingsDataSource.addPath(activeID, pathID);
		
	}

    
}
