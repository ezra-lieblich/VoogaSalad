package engine.settings;

import java.util.Collections;
import java.util.List;

import engine.AbstractType;
import engine.TypeInitializer;
import engine.observer.ObservableList;
import engine.observer.ObservableProperty;

public class GameSettings extends AbstractType implements Game {


    private ObservableProperty<String> gameType;
    private ObservableList<String> winningConditions;
    private ObservableList<String> losingConditions;
    private ObservableProperty<Double> initialLives;
    private ObservableProperty<Double> initialMoney;

	protected GameSettings(TypeInitializer typeBuilder) {
		super(typeBuilder);
		// TODO Auto-generated constructor stub
	}
	


    public List<String> getWinningConditions() {
        return Collections.unmodifiableList(winningConditions.getProperty());
    }

    public void setWinningConditions(String winningCondition) {
        winningConditions.add(winningCondition);
    }

    public List<String> getLosingConditions() {
        return Collections.unmodifiableList(losingConditions.getProperty());
    }

    public void setLosingConditions(String losingCondition) {
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
}
