package engine.tower;

import java.util.function.BiConsumer;
import engine.BindableType;


public interface BindableTower extends BindableType<TowerBuilder> {

    TowerBuilder addCostListener (BiConsumer<Double, Double> listener);

    TowerBuilder addSellAmountListener (BiConsumer<Double, Double> listener);

    TowerBuilder addUnlockLevelListener (BiConsumer<Integer, Integer> listener);

}
