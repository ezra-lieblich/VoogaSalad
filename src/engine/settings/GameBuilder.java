package engine.settings;

import java.util.List;

import engine.TypeBuilder;


public interface GameBuilder extends TypeBuilder<Game, GameBuilder>, BindableGame { //TODO - Add bindable interface 
	GameBuilder buildWinningConditions(List<String> winningConditions);
	GameBuilder buildLosingConditions(List<String> losingConditions);
	GameBuilder buildGameType(String gameType);
	GameBuilder buildInitialLives(double lives);
	GameBuilder buildInitialMoney(double money);

}
