package engine.settings;

import java.util.List;

import engine.Type;


/**
 * Created by ezra on 11/20/16.
 */
public interface Game extends Type{
	

    List<String> getWinningConditions();

    void setWinningConditions(String winningConditions);

    List<String> getLosingConditions();

    void setLosingConditions(String losingConditions);

    String getGameType();

    void setGameType(String gameType);
    
    double getInitalLives();
    
    void setInitialLives(double lives);
    
    double getInitialMoney();
    
    void  setInitialMoney(double money);
}
