package engine;

import java.util.List;


/**
 * Created by ezra on 11/20/16.
 */
public interface Game {
	
    String getName();

    void setName(String name);
    
    String getBackgroundImage();

    List<String> getWinningConditions();

    void setWinningConditions(String winningConditions);

    List<String> getLosingConditions();

    void setLosingConditions(String losingConditions);

    String getGameType();

    void setGameType(String gameType);
}
