package engine.tower;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import engine.AbstractTypeBuilder;
import engine.ability.Ability;
import engine.enemy.Enemy;
import engine.observer.ObservableList;
import engine.observer.ObservableListProperty;
import engine.observer.ObservableObjectProperty;
import engine.observer.ObservableProperty;
import engine.tower.Tower;
import engine.tower.TowerType;
import engine.weapon.Weapon;

public class TowerTypeBuilder extends AbstractTypeBuilder<Tower, TowerBuilder> implements TowerBuilder, TowerInitializer {
    
     public static final String DEFAULT_NAME = "New Tower";
     public static final String DEFAULT_IMAGE_PATH = "Images/penguin.jpg";
     public static final double DEFAULT_SIZE = 1;
     public static final List<Integer> DEFAULT_WEAPONS = Arrays.asList(new Integer[]{});
     public static final List<Integer> DEFAULT_TARGETS = Arrays.asList(new Integer[]{});
     public static final List<Integer> DEFAULT_ABILITIES = Arrays.asList(new Integer[]{});
     public static final List<Integer> DEFAULT_UPGRADES = Arrays.asList(new Integer[]{});
     public static final double DEFAULT_COST = 100;
     public static final double DEFAULT_SELL_AMOUNT = DEFAULT_COST / 2;
     public static final int DEFAULT_UNLOCK_LEVEL = 0;
     
     private ObservableList<Integer> weapons;
     private ObservableList<Integer> targets;
     private ObservableList<Integer> abilities;
     private ObservableList<Integer> upgrades;
     private ObservableProperty<Double> cost;
     private ObservableProperty<Double> sellAmount;
     private ObservableProperty<Integer> unlockLevel;
     
     public TowerTypeBuilder() {
         super(DEFAULT_NAME, DEFAULT_IMAGE_PATH, DEFAULT_SIZE);
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
    public TowerBuilder buildUpgrades(Integer... upgrades) {
        return buildWeapons(Arrays.asList(upgrades));
    }
    
    @Override
    public TowerBuilder buildUpgrades(List<Integer> upgrades) {
        this.upgrades.setProperty(upgrades);
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
    public ObservableList<Integer> getWeapons () {
        return weapons;
    }

    @Override
    public ObservableList<Integer> getTargets () {
        return targets;
    }

    @Override
    public ObservableList<Integer> getAbilities () {
        return abilities;
    }
    
    @Override
    public ObservableList<Integer> getUpgrades () {
        return upgrades;
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
        this.weapons = new ObservableListProperty<Integer>(DEFAULT_WEAPONS);
        this.targets = new ObservableListProperty<Integer>(DEFAULT_TARGETS);
        this.abilities = new ObservableListProperty<Integer>(DEFAULT_ABILITIES);
        this.upgrades = new ObservableListProperty<Integer>(DEFAULT_UPGRADES);
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

    @Override
    public TowerBuilder addWeaponsListener (BiConsumer<List<Integer>, List<Integer>> listener) {
        weapons.addListener(listener);
        return this;
    }

    @Override
    public TowerBuilder addAbilitiesListener (BiConsumer<List<Integer>, List<Integer>> listener) {
        abilities.addListener(listener);
        return this;
    }

    @Override
    public TowerBuilder addUpgradesListener (BiConsumer<List<Integer>, List<Integer>> listener) {
        upgrades.addListener(listener);
        return this;
    }
    

    
}
