package authoringview.level;

import java.util.Map;


/**
 * 
 * Interface to communicate with the game engine about changes in the level settings
 * 
 * @author Andrew Bihl
 */
public interface ILevelToEngine {

    /**
     * Sets creeps in the game engine
     * 
     * @param levelIndex
     * @param map of creeps
     */
    // TODO: Create Creeps
    // public void setCreeps (int levelIndex, Map<Creep, Integer> creeps);

    public void setRewardPoints (int levelIndex, int winPoints);

    public void setRewardMoney (int levelIndex, int winMoney);

    public void setRewardHealth (int levelIndex, int winHealth);

}
