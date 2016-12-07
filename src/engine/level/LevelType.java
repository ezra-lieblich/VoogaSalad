package engine.level;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import engine.AbstractType;
import engine.level.wave.Wave;
import engine.level.wave.WaveType;
import engine.observer.ObservableMap;
import engine.observer.ObservableProperty;


public class LevelType extends AbstractType implements Level {
    private ObservableMap<Integer, Wave> enemyCounts;
    private ObservableProperty<Double> rewardHealth;
    private ObservableProperty<Double> rewardMoney;
    private ObservableProperty<Double> rewardScore;
    private ObservableProperty<Double> durationInSeconds;
    private ObservableProperty<Double> time;

    protected LevelType (LevelInitializer levelInitializer) {
        super(levelInitializer);
        this.enemyCounts = levelInitializer.getWaves();
        this.rewardHealth = levelInitializer.getRewardHealth();
        this.rewardMoney = levelInitializer.getRewardMoney();
        this.rewardScore = levelInitializer.getRewardScore();
        this.durationInSeconds = levelInitializer.getDurationInSeconds();
        this.time = levelInitializer.getLevelTime();
    }

    @Override
    public List<Wave> getWaves () {
    	List<Wave> a = new ArrayList<Wave>(enemyCounts.getProperty().values()); 
        return Collections.unmodifiableList(a);
    }

    @Override
    public void setEnemyCounts (int enemy, WaveType wave) {
        enemyCounts.put(enemy, wave);
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

	@Override
	public double getLevelTime() {
		return time.getProperty();
	}

	@Override
	public int createWave(Wave wave) {
		enemyCounts.put(wave.getId(), wave);
		return wave.getId();
	}

	@Override
	public Wave getWave(int id) {
		return enemyCounts.getProperty().get(id);
	}

}
