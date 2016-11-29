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
    public void setEnemies (Map<Integer, Integer> enemyMap);

    public void setRewardPoints (int winPoints);

    public void setRewardMoney (int winMoney);

    public void setRewardHealth (int winHealth);
    
    public void setPath (int pathID);
    
    public void setTowers (List<Integer> towerIDList);
    
    public void getEnemies ();
    
    public void getRewardPoints ();
    
    public void getRewardMoney ();
    
    public void getRewardHealth ();
    
    public void getPath ();
    
    public void getTowers ();
    
    public void setActiveLevels (List<Integer> levelIDList);
    
    public List<Integer> getActiveLevels ();
    
    

}
