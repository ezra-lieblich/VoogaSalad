package engine.settings;

import java.util.List;

import engine.TypeBuilder;


public interface GameModeBuilder extends TypeBuilder<GameMode, GameModeBuilder>, BindableGameMode { //TODO - Add bindable interface 
	GameModeBuilder buildWinningConditions(List<String> winningConditions);
	GameModeBuilder buildLosingConditions(List<String> losingConditions);
	GameModeBuilder buildGameType(String gameType);
	GameModeBuilder buildInitialLives(double lives);
	GameModeBuilder buildInitialMoney(double money);

}
