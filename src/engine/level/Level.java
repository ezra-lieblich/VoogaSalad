package engine.level;

import engine.Type;

import java.util.Map;

/**
 * Created by ezra on 11/19/16.
 */
public interface Level extends Type{
    Map<Integer, Integer> getEnemyCounts();

    void setEnemyCounts(int enemy, int enemyCount);

    double getRewardHealth();

    void setRewardHealth(int rewardHealth);

    double getRewardMoney();

    void setRewardMoney(int rewardMoney);

    double getRewardPoints();

    void setRewardPoints(int rewardPoints);

    double getDurationInSeconds();

    void setDurationInSeconds(double durationInSeconds);
}
