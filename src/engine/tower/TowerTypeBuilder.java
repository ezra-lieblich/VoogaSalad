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
     public static final List<Integer> DEFAULT_UPGRADES = Arrays.asList(new Integer[]{});
     public static final List<Integer> DEFAULT_WEAPONS = Arrays.asList(new Integer[]{});
     public static final List<Integer> DEFAULT_TARGETS = Arrays.asList(new Integer[]{});
     public static final List<Integer> DEFAULT_ABILITIES= Arrays.asList(new Integer[]{});
     public static final double DEFAULT_COST = 100;
     public static final double DEFAULT_SELL_AMOUNT = DEFAULT_COST / 2;
     public static final int DEFAULT_UNLOCK_LEVEL = 0;
     
     private List<Integer> upgrades;
     private List<Integer> weapons;
     private List<Integer> targets;
     private List<Integer> abilities;
     private ObservableProperty<Double> cost;
     private ObservableProperty<Double> sellAmount;
     private ObservableProperty<Integer> unlockLevel;
     
     public TowerTypeBuilder() {
         super(DEFAULT_NAME, DEFAULT_IMAGE_PATH, DEFAULT_SIZE);
         this.upgrades = DEFAULT_UPGRADES;
         this.weapons = DEFAULT_WEAPONS;
         this.targets = DEFAULT_TARGETS;
         this.abilities = DEFAULT_ABILITIES;
         this.cost = new ObservableObjectProperty<Double>(DEFAULT_COST);
         this.sellAmount = new ObservableObjectProperty<Double>(DEFAULT_SELL_AMOUNT);
         this.unlockLevel = new ObservableObjectProperty<Integer>(DEFAULT_UNLOCK_LEVEL);
     }
    
    @Override
    public TowerBuilder buildUpgrades(Integer... upgrades) {
        return buildUpgrades(Arrays.asList(upgrades));
    }

    @Override
    public TowerBuilder buildUpgrades(List<Integer> upgrades) {
        this.upgrades = upgrades;
        return this;
    }
    
    @Override
    public TowerBuilder buildWeapons(Integer... weapons) {
        return buildWeapons(Arrays.asList(weapons));
    }
    
    @Override
    public TowerBuilder buildWeapons(List<Integer> weapons) {
        this.weapons = weapons;
        return this;
    }
    
    @Override
    public TowerBuilder buildTargets(Integer... targets) {
        return buildTargets(Arrays.asList(targets));
    }
    
    @Override
    public TowerBuilder buildTargets(List<Integer> targets) {
        this.targets = targets;
        return this;
    }
    
    @Override
    public TowerBuilder buildAbilities(Integer... abilities) {
        return buildAbilities(Arrays.asList(abilities));
    }
    
    @Override
    public TowerBuilder buildAbilities(List<Integer> abilities) {
        this.abilities = abilities;
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
    public List<Integer> getUpgrades () {
        return Collections.unmodifiableList(upgrades);
    }

    @Override
    public List<Integer> getWeapons () {
        return Collections.unmodifiableList(weapons);
    }

    @Override
    public List<Integer> getTargets () {
        return Collections.unmodifiableList(targets);
    }

    @Override
    public List<Integer> getAbilities () {
        return Collections.unmodifiableList(abilities);
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

    //Is this too inconsistant?
    @Override
    protected void restoreDefaults () {
        setName(new ObservableObjectProperty<String>(DEFAULT_NAME));
        setImagePath(new ObservableObjectProperty<String>(DEFAULT_IMAGE_PATH));
        setSize(new ObservableObjectProperty<Double>(DEFAULT_SIZE));
        buildWeapons(DEFAULT_WEAPONS);
        buildTargets(DEFAULT_TARGETS);
        buildAbilities(DEFAULT_ABILITIES);
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
