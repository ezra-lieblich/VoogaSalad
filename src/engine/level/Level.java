package engine.level;

import engine.Type;

import java.util.Map;

/**
 * Created by ezra on 11/19/16.
 */
public interface Level extends Type{
    Map<Integer, Integer> getEnemyCounts();

    void setEnemyCounts(int enemy, int enemyCount);
    
    void removeEnemy(int enemy);

    double getRewardHealth();

    void setRewardHealth(double rewardHealth);

    double getRewardMoney();

    void setRewardMoney(double rewardMoney);

    double getRewardPoints();

    void setRewardPoints(double rewardPoints);

    double getDurationInSeconds();

    void setDurationInSeconds(double durationInSeconds);
}
