package engine.settings;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

import engine.AbstractTypeBuilder;

import engine.observer.ObservableList;
import engine.observer.ObservableListProperty;
import engine.observer.ObservableObjectProperty;
import engine.observer.ObservableProperty;

public class GameModeTypeBuilder extends AbstractTypeBuilder<GameMode, GameModeBuilder> implements GameModeBuilder, GameModeInitializer {

	public static final String DEFAULT_NAME = "New Game";
    public static final String DEFAULT_IMAGE_PATH = "Images/blacksquare.jpg";
    public static final double DEFAULT_SIZE = 1;
    public static final String[] DEFAULT_WINNING_CONDITIONS = new String[]{};
    public static final String[] DEFAULT_LOSING_CONDITIONS = new String[]{};
    public static final String DEFAULT_GAME_TYPE = "Normal";
    public static final double DEFAULT_INITIAL_LIVES = 100;
    public static final double DEFAULT_INITIAL_MONEY = 500;
    
    private ObservableProperty<String> gameType;
    private ObservableList<String> winningConditions;
    private ObservableList<String> losingConditions;
    private ObservableProperty<Double> initialLives;
    private ObservableProperty<Double> initialMoney;
	
	public GameModeTypeBuilder() {
		super(DEFAULT_NAME, DEFAULT_IMAGE_PATH, DEFAULT_SIZE);
	}

	@Override
	public GameModeBuilder addWinningConditionsListener(BiConsumer<List<String>, List<String>> listener) {
		winningConditions.addListener(listener);
		return this;
	}

	@Override
	public GameModeBuilder addLosingConditionsListener(BiConsumer<List<String>, List<String>> listener) {
		losingConditions.addListener(listener);
		return this;
	}

	@Override
	public GameModeBuilder addGameTypeListener(BiConsumer<String, String> listener) {
		gameType.addListener(listener);
		return this;
	}

	@Override
	public GameModeBuilder addInitialLivesListener(BiConsumer<Double, Double> listener) {
		initialLives.addListener(listener);
		return this;
	}

	@Override
	public GameModeBuilder addInitialMoneyListener(BiConsumer<Double, Double> listener) {
		initialMoney.addListener(listener);
		return this;
	}

	@Override
	public ObservableList<String> getWinningConditions() {
		return winningConditions;
	}

	@Override
	public ObservableList<String> getLosingConditions() {
		return losingConditions;
	}

	@Override
	public ObservableProperty<Double> getInitalLives() {
		return initialLives;
	}

	@Override
	public ObservableProperty<Double> getInitialMoney() {
		return initialMoney;
	}

	@Override
	public ObservableProperty<String> getGameType() {
		return gameType;
	}

	@Override
	public GameModeBuilder buildWinningConditions(List<String> winningConditions) {
		this.winningConditions.setProperty(winningConditions);
		return this;
	}

	@Override
	public GameModeBuilder buildLosingConditions(List<String> losingConditions) {
		this.losingConditions.setProperty(losingConditions);
		return this;
	}

	@Override
	public GameModeBuilder buildGameType(String gameType) {
		this.gameType.setProperty(gameType);
		return this;
	}

	@Override
	public GameModeBuilder buildInitialLives(double lives) {
		this.initialLives.setProperty(lives);
		return this;
	}

	@Override
	public GameModeBuilder buildInitialMoney(double money) {
		this.initialMoney.setProperty(money);
		return this;
	}

	@Override
	protected GameMode create() {
		return new GameModeType(this);
	}

	@Override
	protected void restoreTypeDefaults() {
		this.winningConditions = new ObservableListProperty<String>(Arrays.stream(DEFAULT_WINNING_CONDITIONS).collect(Collectors.toList()));
		this.losingConditions = new ObservableListProperty<String>(Arrays.stream(DEFAULT_LOSING_CONDITIONS).collect(Collectors.toList()));
		this.gameType = new ObservableObjectProperty<String>(DEFAULT_GAME_TYPE);
		this.initialLives = new ObservableObjectProperty<Double>(DEFAULT_INITIAL_LIVES);
		this.initialMoney = new ObservableObjectProperty<Double>(DEFAULT_INITIAL_MONEY);
	}

	@Override
	protected GameModeBuilder getThis() {
		return this;
	}

}
