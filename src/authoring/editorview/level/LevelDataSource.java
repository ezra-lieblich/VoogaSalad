package authoring.editorview.level;

import java.util.List;
import java.util.Map;


/**
 * 
 * Interface to communicate with the game engine about changes in the level settings
 * 
 * @author Andrew Bihl, Diane Hadley
 */
public interface LevelDataSource {

    /**
     * Sets creeps in the game engine
     * 
     * @param levelIndex
     * @param map of creeps, key = enemyID, value = number of that enemy
     */
    public void setEnemies (int levelIndex, Map<Integer, Integer> enemyMap);

    public void setRewardPoints (int levelIndex, int winPoints);

    public void setRewardMoney (int levelIndex, int winMoney);

    public void setRewardHealth (int levelIndex, int winHealth);
    
    public void setPath (int levelIndex, int pathID);
    
    public void setTowers (int levelIndex, List<Integer> towerIDList);
    
    public void getEnemies (int levelIndex);
    
    public void getRewardPoints (int levelIndex);
    
    public void getRewardMoney (int levelIndex);
    
    public void getRewardHealth (int levelIndex);
    
    public void getPath (int levelIndex);
    
    public void getTowers (int levelIndex);
    
    

}
