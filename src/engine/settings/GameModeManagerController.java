package engine.settings;

import java.util.List;

import authoring.editorview.gamesettings.IGameUpdateView;
import engine.ManagerController;

public interface GameModeManagerController extends ManagerController<GameModeManager, GameModeBuilder, GameMode, IGameUpdateView>{
		
	public void setNumberofLives (int gameModeID, double lives);
	
	public double getNumberofLives (int gameModeID);
	
	public void setMoney (int gameModeID, double money);
	
	public double getMoney(int gameModeID);
	
	public void addWinningCondition (int gameModeID, String winningCondition);
    
    public void addLosingCondition (int gameModeID, String losingCondition);
    
    public void removeWinningCondition (int gameModeID, String winningCondition);
    
    public void removeLosingCondition (int gameModeID, String losingCondition);
    
    public List<String> getWinningConditions (int gameModeID);
    
    public List<String> getLosingConditons (int gameModeID);
}
