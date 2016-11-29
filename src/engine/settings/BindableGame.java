package engine.settings;
import java.util.List;
import java.util.function.BiConsumer;

import engine.BindableType;

public interface BindableGame extends BindableType<GameBuilder>{
	GameBuilder addWinningConditionsListener(BiConsumer<List<String>, List<String>> listener);
	GameBuilder addLosingConditionsListener(BiConsumer<List<String>, List<String>> listener);
	GameBuilder addGameTypeListener(BiConsumer<String, String> listener);
	GameBuilder addInitialLivesListener(BiConsumer<Double, Double> listener);
	GameBuilder addInitialMoneyListener(BiConsumer<Double, Double> listener);



}
