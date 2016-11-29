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
    public void setEnemies (int levelID, Map<Integer, Integer> enemyMap);

    public void setRewardPoints (int levelID, int winPoints);

    public void setRewardMoney (int levelID, int winMoney);

    public void setRewardHealth (int levelID, int winHealth);
    
    public void setPath (int levelID, int pathID);
    
    public void setTowers (int levelID, List<Integer> towerIDList);
    
    public void getEnemies (int levelID);
    
    public void getRewardPoints (int levelID);
    
    public void getRewardMoney (int levelID);
    
    public void getRewardHealth (int levelID);
    
    public void getPath (int levelID);
    
    public void getTowers (int levelID);
    
    

}
