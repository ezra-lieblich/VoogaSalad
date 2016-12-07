package engine.level;

import engine.Type;
import engine.level.wave.Wave;
import engine.level.wave.WaveType;

import java.util.List;
import java.util.Map;


/**
 * Created by ezra on 11/19/16.
 */
public interface Level extends Type {
	
    List<Wave> getWaves();


    double getRewardHealth ();

    void setRewardHealth (double rewardHealth);

    double getRewardMoney ();

    void setRewardMoney (double rewardMoney);

    double getRewardScore ();

    void setRewardScore (double rewardScore);

    double getDurationInSeconds ();

    void setDurationInSeconds (double durationInSeconds);
    
    double getLevelTime ();
    
    void setEnemyCounts (int enemy, WaveType wave);

    void removeEnemy (int enemy);
    
    int createWave (Wave wave);
    
    //List of Waves
    Wave getWave (int id);
    
}
