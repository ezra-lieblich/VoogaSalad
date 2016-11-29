package authoring.editorview.level;

import java.util.Map;


/**
 * 
 * Interface to communicate with the game engine about changes in the level settings
 * 
 * @author Andrew Bihl, Diane Hadley
 */
public interface LevelDataSource {

	
	public int createNewLevel ();
	
	public void removeLevel (int levelID);
   	
	public void setLevelName (int levelID, String levelName);
	
	public void setEnemy (int levelID, int enemyID, int numEnemies);

    public void setRewardPoints (int levelID, double winPoints);

    public void setRewardMoney (int levelID, double winMoney);

    public void setRewardHealth (int levelID, double winHealth);
    
    public void setPath (int levelID, int pathID);
    
    public void setTransitionTime (int levelID, double time);
      
    public Map<Integer, Integer> getEnemies (int levelID);
    
    public double getRewardPoints (int levelID);
    
    public double getRewardMoney (int levelID);
    
    public double getRewardHealth (int levelID);
    
    public int getPath (int levelID);
    
    public String getLevelName (int levelID);
    
    public double getTransitionTime (int levelID);

    public void setEnemyFrequency (int enemyID, double enemyFrequency);

}
