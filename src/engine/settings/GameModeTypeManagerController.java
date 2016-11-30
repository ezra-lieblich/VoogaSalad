package engine.settings;

import java.util.List;

import authoring.editorview.gamesettings.IGameUpdateView;
import engine.AbstractTypeManagerController;


public class GameModeTypeManagerController 
	extends AbstractTypeManagerController<GameModeManager, GameModeBuilder, GameMode, IGameUpdateView> implements GameModeManagerController {

	public GameModeTypeManagerController(GameModeManager typeManager) {
		super(typeManager, new GameModeTypeBuilder());
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
	protected GameModeBuilder constructTypeProperties(IGameUpdateView updateView, GameModeBuilder typeBuilder) {
		// TODO NEED methods in IGAMEUPDATEVIEW
		return null;
	}


}
