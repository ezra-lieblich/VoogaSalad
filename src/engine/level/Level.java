package engine.level;

import engine.Type;
import engine.enemy.EnemyType;

import java.util.Map;

/**
 * Created by ezra on 11/19/16.
 */
public interface Level extends Type{
    Map<EnemyType, Integer> getEnemyCounts();

    void setEnemyCounts(EnemyType enemy, int enemyCount);

    int getRewardHealth();

    void setRewardHealth(int rewardHealth);

    int getRewardMoney();

    void setRewardMoney(int rewardMoney);

    int getRewardPoints();

    void setRewardPoints(int rewardPoints);

    double getDurationInSeconds();

    void setDurationInSeconds(double durationInSeconds);
}
