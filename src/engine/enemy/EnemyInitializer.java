package engine.enemy;

import engine.TypeInitializer;
import engine.observer.ObservableProperty;

public interface EnemyInitializer extends TypeInitializer{
    ObservableProperty<Double> getSpeed();
    ObservableProperty<Double> getHealth();
    ObservableProperty<Double> getDamage();
    ObservableProperty<Double> getPoints();
    ObservableProperty<Double> getMoney();
    ObservableProperty<String> getCollisionEffect();
}
