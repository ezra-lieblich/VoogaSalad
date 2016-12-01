package engine.level;

import java.util.Collections;
import java.util.Map;
import engine.AbstractType;
import engine.observer.ObservableMap;
import engine.observer.ObservableProperty;


public class LevelType extends AbstractType implements Level {
    private ObservableMap<Integer, Integer> enemyCounts;
    private ObservableProperty<Double> rewardHealth;
    private ObservableProperty<Double> rewardMoney;
    private ObservableProperty<Double> rewardScore;
    private ObservableProperty<Double> durationInSeconds;

    protected LevelType (LevelInitializer levelInitializer) {
        super(levelInitializer);
        this.enemyCounts = levelInitializer.getEnemyCounts();
        this.rewardHealth = levelInitializer.getRewardHealth();
        this.rewardMoney = levelInitializer.getRewardMoney();
        this.rewardScore = levelInitializer.getRewardScore();
        this.durationInSeconds = levelInitializer.getDurationInSeconds();
    }

    @Override
    public Map<Integer, Integer> getEnemyCounts () {
        return Collections.unmodifiableMap(enemyCounts.getProperty());
    }

    @Override
    public void setEnemyCounts (int enemy, int enemyCount) {
        enemyCounts.put(enemy, enemyCount);
    }

    @Override
    public void removeEnemy (int enemy) {
        enemyCounts.remove(enemy);
    }

    @Override
    public double getRewardHealth () {
        return rewardHealth.getProperty();
    }

    @Override
    public void setRewardHealth (double rewardHealth) {
        this.rewardHealth.setProperty(rewardHealth);
    }

    @Override
    public double getRewardMoney () {
        return rewardMoney.getProperty();
    }

    @Override
    public void setRewardMoney (double rewardMoney) {
        this.rewardMoney.setProperty(rewardMoney);
    }

    @Override
    public double getRewardScore () {
        return rewardScore.getProperty();
    }

    @Override
    public void setRewardScore (double rewardPoints) {
        this.rewardScore.setProperty(rewardPoints);
    }

    @Override
    public double getDurationInSeconds () {
        return durationInSeconds.getProperty();
    }

    @Override
    public void setDurationInSeconds (double durationInSeconds) {
        this.durationInSeconds.setProperty(durationInSeconds);
    }

}