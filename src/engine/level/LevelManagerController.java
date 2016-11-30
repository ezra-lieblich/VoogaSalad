package engine.level;

import java.util.Map;

import authoring.editorview.level.ILevelUpdateView;
import engine.ManagerController;


public interface LevelManagerController  extends ManagerController<LevelManager, LevelBuilder, Level, ILevelUpdateView>{
	
	public void setEnemy (int levelID, int enemyID, int numEnemies);

    public void setRewardScore (int levelID, double winScore);

    public void setRewardMoney (int levelID, double winMoney);

    public void setRewardHealth (int levelID, double winHealth);
    
    public void setPath (int levelID, int pathID);
    
    public void setTransitionTime (int levelID, double time);
      
    public Map<Integer, Integer> getEnemies (int levelID);
    
    public double getRewardScore (int levelID);
    
    public double getRewardMoney (int levelID);
    
    public double getRewardHealth (int levelID);
    
    public int getPath (int levelID);
        
    public double getTransitionTime (int levelID);

    public void setEnemyFrequency (int levelID, int enemyID, double enemyFrequency);
    
    public double getEnemyFrequency (int levelID, int enemyID);
}
