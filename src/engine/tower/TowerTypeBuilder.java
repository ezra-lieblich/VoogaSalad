package engine.tower;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import engine.AbstractTypeBuilder;
import engine.ability.Ability;
import engine.enemy.Enemy;
import engine.observer.ObservableObjectProperty;
import engine.observer.ObservableProperty;
import engine.tower.Tower;
import engine.tower.TowerType;
import engine.weapon.Weapon;

public class TowerTypeBuilder extends AbstractTypeBuilder<Tower, TowerBuilder> implements TowerBuilder {
    
     public static final String DEFAULT_NAME = "New Tower";
     public static final String DEFAULT_IMAGE_PATH = "Images.penguin.jpg";
     public static final double DEFAULT_SIZE = 1;
     public static final List<Integer> DEFAULT_WEAPONS = Arrays.asList(new Integer[]{});
     public static final List<Integer> DEFAULT_TARGETS = Arrays.asList(new Integer[]{});
     public static final List<Integer> DEFAULT_ABILITIES = Arrays.asList(new Integer[]{});
     public static final int DEFAULT_UPGRADE = -1;
     public static final double DEFAULT_COST = 100;
     public static final double DEFAULT_SELL_AMOUNT = DEFAULT_COST / 2;
     public static final int DEFAULT_UNLOCK_LEVEL = 0;
     
     private ObservableProperty<List<Integer>> weapons;
     private ObservableProperty<List<Integer>> targets;
     private ObservableProperty<List<Integer>> abilities;
     private ObservableProperty<Integer> upgrade;
     private ObservableProperty<Double> cost;
     private ObservableProperty<Double> sellAmount;
     private ObservableProperty<Integer> unlockLevel;
     
     public TowerTypeBuilder() {
         super(DEFAULT_NAME, DEFAULT_IMAGE_PATH, DEFAULT_SIZE);
     }
    
    @Override
    public TowerBuilder buildUpgrade(Integer upgrade) {
        this.upgrade.setProperty(upgrade);
        return this;
    }
    
    @Override
    public TowerBuilder buildWeapons(Integer... weapons) {
        return buildWeapons(Arrays.asList(weapons));
    }
    
    @Override
    public TowerBuilder buildWeapons(List<Integer> weapons) {
        this.weapons.setProperty(weapons);
        return this;
    }
    
    @Override
    public TowerBuilder buildTargets(Integer... targets) {
        return buildTargets(Arrays.asList(targets));
    }
    
    @Override
    public TowerBuilder buildTargets(List<Integer> targets) {
        this.targets.setProperty(targets);
        return this;
    }
    
    @Override
    public TowerBuilder buildAbilities(Integer... abilities) {
        return buildAbilities(Arrays.asList(abilities));
    }
    
    @Override
    public TowerBuilder buildAbilities(List<Integer> abilities) {
        this.abilities.setProperty(abilities);
        return this;
    }
    
    @Override
    public TowerBuilder buildCost(double cost) {
        this.cost.setProperty(cost);
        return this;
    }
    
    @Override
    public TowerBuilder buildSellAmount(double sellAmount) {
        this.sellAmount.setProperty(sellAmount);
        return this;
    }
    
    @Override
    public TowerBuilder buildUnlockLevel(int unlockLevel) {
        this.unlockLevel.setProperty(unlockLevel);
        return this;
    }

    @Override
    protected Tower create () {
        return new TowerType(this);
    }

    @Override
    public ObservableProperty<List<Integer>> getWeapons () {
        return weapons;
    }

    @Override
    public ObservableProperty<List<Integer>> getTargets () {
        return targets;
    }

    @Override
    public ObservableProperty<List<Integer>> getAbilities () {
        return abilities;
    }
    
    @Override
    public ObservableProperty<Integer> getUpgrade () {
        return upgrade;
    }

    @Override
    public ObservableProperty<Double> getCost () {
        return cost;
    }

    @Override
    public ObservableProperty<Double> getSellAmount () {
        return sellAmount;
    }

    @Override
    public ObservableProperty<Integer> getUnlockLevel () {
        return unlockLevel;
    }

    @Override
    protected void restoreTypeDefaults () {
        this.weapons = new ObservableObjectProperty<List<Integer>>(DEFAULT_WEAPONS);
        this.targets = new ObservableObjectProperty<List<Integer>>(DEFAULT_TARGETS);
        this.abilities = new ObservableObjectProperty<List<Integer>>(DEFAULT_ABILITIES);
        this.upgrade = new ObservableObjectProperty<Integer>(DEFAULT_UNLOCK_LEVEL);
        this.cost = new ObservableObjectProperty<Double>(DEFAULT_COST);
        this.sellAmount = new ObservableObjectProperty<Double>(DEFAULT_SELL_AMOUNT);
        this.unlockLevel = new ObservableObjectProperty<Integer>(DEFAULT_UNLOCK_LEVEL);
    }

    @Override
    protected TowerBuilder getThis () {
        return this;
    }
    
    @Override
    public TowerBuilder addCostListener(BiConsumer<Double, Double> listener) {
        cost.addListener(listener);
        return this;
    }
    
    @Override
    public TowerBuilder addSellAmountListener(BiConsumer<Double, Double> listener) {
        sellAmount.addListener(listener);
        return this;
    }
    
    @Override
    public TowerBuilder addUnlockLevelListener(BiConsumer<Integer, Integer> listener) {
        unlockLevel.addListener(listener);
        return this;
    }

    
}
