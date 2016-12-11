package engine.settings;

import java.util.List;

import authoring.editorview.gamesettings.IGameSettingsUpdateView;
import engine.AbstractTypeManagerController;
import engine.ManagerMediator;


public class GameModeTypeManagerController 
	extends AbstractTypeManagerController<GameModeManager, GameModeBuilder, GameMode, IGameSettingsUpdateView> implements GameModeManagerController {

	public GameModeTypeManagerController(ManagerMediator managerMediator) {
		super(new GameModeTypeManager(), new GameModeTypeBuilder(), managerMediator);
	}

	@Override
	public void setNumberofLives(int gameModeID, double lives) {
		getTypeManager().getEntity(gameModeID).setInitialLives(lives);
	}

	@Override
	public double getNumberofLives(int gameModeID) {
		return getTypeManager().getEntity(gameModeID).getInitalLives();
	}

	@Override
	public void setMoney(int gameModeID, double money) {
		getTypeManager().getEntity(gameModeID).setInitialMoney(money);
	}

	@Override
	public double getMoney(int gameModeID) {
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
		// TODO NEED methods in IGAMEUPDATEVIEW
		return null;
	}


}
