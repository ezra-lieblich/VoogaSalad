package engine.level;

import java.util.List;
import java.util.Map;
import authoring.editorview.level.ILevelEditorView;
import engine.ManagerController;
import engine.level.wave.WaveType;


public interface LevelManagerController
        extends ManagerController<LevelManager, LevelBuilder, Level, ILevelEditorView> {

    public void setEnemy (int levelID, int enemyID, WaveType wave);

    public Map<Integer, WaveType> getEnemies (int levelID);

    public void setRewardScore (int levelID, double winScore);

    public double getRewardScore (int levelID);

    public void setRewardMoney (int levelID, double winMoney);

    public double getRewardMoney (int levelID);

    public void setRewardHealth (int levelID, double winHealth);

    public double getRewardHealth (int levelID);

    public void setPath (int levelID, int pathID);

    public int getPath (int levelID);

    public void setTransitionTime (int levelID, double time);

    public double getTransitionTime (int levelID);

    public void setEnemyFrequency (int levelID, int enemyID, double enemyFrequency);

    public double getEnemyFrequency (int levelID, int enemyID);

    public void setLevelNumber (int levelID, int levelNumber);

    public int getLevelNumber (int levelID);
    
    public List<Integer> getLevelOptions();
    
    public double getLevelTime (int levelID);
    
    public int createWave (int levelID, ILevelEditorView updateView);
    
    public void removeWave(int levelID, int waveID);
    
    public void setWaveEnemy(int levelID, int waveID, int enemyID);
    
    public int getWaveEnemy(int levelID, int waveID);
    
    public void setWaveCount(int levelID, int waveID, int count);
    
    public int getWaveCount(int levelID, int waveID);
    
    public void setWaveFrequency(int levelID, int waveID, double frequency);
    
    public double getWaveFrequency(int levelID, int waveID);
    
    public void setWavePath(int levelID, int waveID, int pathID);
    
    public int getWavePath(int levelID, int waveID);
    
    public void setWaveDelay(int levelID, int waveID, double delay);
    

}
