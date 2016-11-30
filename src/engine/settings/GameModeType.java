package engine.settings;

import java.util.Collections;
import java.util.List;

import engine.AbstractType;
import engine.observer.ObservableList;
import engine.observer.ObservableProperty;

public class GameModeType extends AbstractType implements GameMode {


    private ObservableProperty<String> gameType;
    private ObservableList<String> winningConditions;
    private ObservableList<String> losingConditions;
    private ObservableProperty<Double> initialLives;
    private ObservableProperty<Double> initialMoney;

	protected GameModeType(GameModeInitializer gameInitializer) {
		super(gameInitializer);
		this.gameType = gameInitializer.getGameType();
		this.winningConditions = gameInitializer.getWinningConditions();
		this.losingConditions = gameInitializer.getLosingConditions();
		this.initialLives = gameInitializer.getInitalLives();
		this.initialMoney = gameInitializer.getInitialMoney();
	}
	


    public List<String> getWinningConditions() {
        return Collections.unmodifiableList(winningConditions.getProperty());
    }

    public void setWinningCondition(String winningCondition) {
        winningConditions.add(winningCondition);
    }

    public List<String> getLosingConditions() {
        return Collections.unmodifiableList(losingConditions.getProperty());
    }

    public void setLosingCondition(String losingCondition) {
        losingConditions.add(losingCondition);
    }

    public String getGameType() {
        return gameType.getProperty();
    }

    public void setGameType(String gameType) {
        this.gameType.setProperty(gameType); 
    }

	@Override
	public double getInitalLives() {
		return initialLives.getProperty();
	}

	@Override
	public void setInitialLives(double lives) {
		initialLives.setProperty(lives);
	}



	@Override
	public double getInitialMoney() {
		return initialMoney.getProperty();
	}



	@Override
	public void setInitialMoney(double money) {
		initialMoney.setProperty(money);
	}



	@Override
	public void removeWinningCondition(String winningCondition) {
		winningConditions.remove(winningCondition);
	}



	@Override
	public void removeLosingCondition(String losingCondition) {
		losingConditions.remove(losingCondition);
	}
}
