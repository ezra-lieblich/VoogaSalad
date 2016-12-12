package engine.settings;

import java.util.List;

import engine.Type;


/**
 * Created by ezra on 11/20/16.
 */
public interface GameMode extends Type{
	
    List<String> getWinningConditions();

    void setWinningCondition(String winningCondition);
    
    void removeWinningCondition(String winningCondition);

    List<String> getLosingConditions();

    void setLosingCondition(String losingCondition);
    
    void removeLosingCondition(String losingCondition);

    String getGameType();

    void setGameType(String gameType);
    
    int getInitalLives();
    
    void setInitialLives(int lives);
    
    int getInitialMoney();
    
    void  setInitialMoney(int money);
    
    void setPathType(String pathType);
    
    String getPathType();
    
    void setGridSize(int gridSize);
    
    int getGridSize();
    
    void addPath(int pathID);
    
    void removePath(int pathID);
    
    List<Integer> getPaths();
    
}
