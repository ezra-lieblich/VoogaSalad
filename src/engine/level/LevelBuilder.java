package engine.level;

import java.util.Map;
import engine.TypeBuilder;
import engine.level.wave.WaveType;


public interface LevelBuilder extends TypeBuilder<Level, LevelBuilder>, BindableLevel {

    LevelBuilder buildWaves (Map<Integer, WaveType> enemies);

    LevelBuilder buildRewardHealth (double rewardHealth);

    LevelBuilder buildRewardMoney (double rewardMoney);

    LevelBuilder buildRewardScore (double rewardScore);

    LevelBuilder buildDurationInSeconds (double durationInSeconds);
    
    LevelBuilder buildLevelTime (double time);

}
