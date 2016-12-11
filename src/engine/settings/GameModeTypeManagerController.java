package engine.settings;

import java.util.Collections;
import java.util.List;

import authoring.editorview.gamesettings.IGameSettingsUpdateView;
import engine.AbstractTypeManagerController;
import engine.ManagerMediator;
import engine.MethodObjectData;
import engine.effect.EffectManagerController;
import engine.effect.EffectTypeManagerController;


public class GameModeTypeManagerController 
	extends AbstractTypeManagerController<GameModeManager, GameModeBuilder, GameMode, IGameSettingsUpdateView> implements GameModeManagerController {

	private EffectManagerController gameModeEffectManagerController;
	
	public GameModeTypeManagerController(ManagerMediator managerMediator) {
		super(new GameModeTypeManager(), new GameModeTypeBuilder(), managerMediator);
		this.gameModeEffectManagerController = new EffectTypeManagerController(managerMediator, getTypeManager().getGameModeEffectManager());
	}

	@Override
	public void setNumberofLives(int gameModeID, int lives) {
		getTypeManager().getEntity(gameModeID).setInitialLives(lives);
	}

	@Override
	public int getNumberofLives(int gameModeID) {
		return getTypeManager().getEntity(gameModeID).getInitalLives();
	}

	@Override
	public void setMoney(int gameModeID, int money) {
		getTypeManager().getEntity(gameModeID).setInitialMoney(money);
	}

	@Override
	public int getMoney(int gameModeID) {
		return getTypeManager().getEntity(gameModeID).getInitialMoney();
	}

	@Override
	public void addWinningCondition(int gameModeID, String winningCondition) {
		getTypeManager().getEntity(gameModeID).setWinningCondition(winningCondition);
	}

	@Override
	public void addLosingCondition(int gameModeID, String losingCondition) {
		getTypeManager().getEntity(gameModeID).setLosingCondition(losingCondition);
	}

	@Override
	public void removeWinningCondition(int gameModeID, String winningCondition) {
		getTypeManager().getEntity(gameModeID).removeWinningCondition(winningCondition);
	}

	@Override
	public void removeLosingCondition(int gameModeID, String losingCondition) {
		getTypeManager().getEntity(gameModeID).removeLosingCondition(losingCondition);
	}

	@Override
	public List<String> getWinningConditions(int gameModeID) {
		return getTypeManager().getEntity(gameModeID).getWinningConditions();
	}

	@Override
	public List<String> getLosingConditons(int gameModeID) {
		return getTypeManager().getEntity(gameModeID).getLosingConditions();
	}

	@Override
	protected GameModeBuilder constructTypeProperties(IGameSettingsUpdateView updateView, GameModeBuilder typeBuilder) {
		return typeBuilder //.addGameTypeListener( (oldValue, newValue) -> updateView.updateGameName(newValue))
				.addInitialMoneyListener((oldValue, newValue) -> updateView.updateInitialMoney(newValue))
				.addInitialLivesListener((oldValue, newValue) -> updateView.updateNumberofLives(newValue.intValue()))
				.addLosingConditionsListener((oldValue, newValue) -> updateView.updateLosingConditions(newValue))
				.addWinningConditionsListener((oldValue, newValue) -> updateView.updateLosingConditions(newValue))
				.addPathListener((oldValue, newValue) -> updateView.updatePathList(newValue))
				.addGridSizeListener((oldValue, newValue) -> updateView.updateGridSize(newValue))
				.addPathTypeListener((oldValue, newValue) -> updateView.updatePathType(newValue));	
	}

	@Override
	public void setPathType(int gameModeID, String pathType) {
		getTypeManager().getEntity(gameModeID).setPathType(pathType);
	}

	@Override
	public String getPathType(int gameModeID) {
		return getTypeManager().getEntity(gameModeID).getPathType();
	}

	@Override
	public void setGridSize(int gameModeID, int gridSize) {
		getTypeManager().notifyObservers(new MethodObjectData<Integer>("GridSize", gridSize) );
		getTypeManager().getEntity(gameModeID).setGridSize(gridSize);
	}

	@Override
	public int getGridSize(int gameModeID) {
		return getTypeManager().getEntity(gameModeID).getGridSize();
	}

	@Override
	public void addPath(int gameModeID, int pathID) {
		getTypeManager().notifyObservers(new MethodObjectData<Integer>("AddPath", pathID));
		getTypeManager().getEntity(gameModeID).addPath(pathID);
	}

	@Override
	public void removePath(int gameModeID, int pathID) {
		getTypeManager().notifyObservers(new MethodObjectData<Integer>("RemovePath", pathID));
		getTypeManager().getEntity(gameModeID).removePath(pathID);
	}

	@Override
	public List<Integer> getPaths(int gameModeID) {
		return Collections.unmodifiableList(getTypeManager().getEntity(gameModeID).getPaths());
	}

	@Override
	public EffectManagerController getEffectManagerController() {
		return gameModeEffectManagerController;
	}


}
