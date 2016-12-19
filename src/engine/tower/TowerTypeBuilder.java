// This entire file is part of my masterpiece.
// Sean Hudson
package engine.tower;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import engine.AbstractTypeBuilder;
import engine.observer.ObservableList;
import engine.observer.ObservableListProperty;
import engine.observer.ObservableObjectProperty;
import engine.observer.ObservableProperty;
import engine.tower.Tower;
import engine.tower.TowerType;

/**
 * This class provides a concrete implementation on how to extend the AbstractTypeBuiler class
 * I tried to make these builders as user friendly as possible. That is why I added the option to take
 * in a list of elements through a List or varargs (e.g. buildWeapons()).
 * 
 * 
 * This class allows clients to instruct the creation of Towers.
 * 
 * @author seanhudson
 *
 */
public class TowerTypeBuilder extends AbstractTypeBuilder<Tower, TowerBuilder> implements TowerBuilder, TowerInitializer {
    
     public static final String DEFAULT_NAME = "New Tower";
     public static final String DEFAULT_IMAGE_PATH = "Images/tower.png";
     public static final double DEFAULT_SIZE = 1;
     public static final String DEFAULT_SOUND_PATH = "Music/DopeBeats.mp3";

     public static final Integer[] DEFAULT_WEAPONS = new Integer[]{};
     public static final Integer[] DEFAULT_ABILITIES = new Integer[]{};
     public static final Integer[] DEFAULT_UPGRADES = new Integer[]{};
     public static final double DEFAULT_COST = 10;
     public static final double DEFAULT_SELL_AMOUNT = DEFAULT_COST / 2;
     public static final int DEFAULT_UNLOCK_LEVEL = 0;
     
     private ObservableList<Integer> weapons;
     private ObservableList<Integer> abilities;
     private ObservableList<Integer> upgrades;
     private ObservableProperty<Double> cost;
     private ObservableProperty<Double> sellAmount;
     private ObservableProperty<Integer> unlockLevel;
     
     public TowerTypeBuilder() {
         super(DEFAULT_NAME, DEFAULT_IMAGE_PATH, DEFAULT_SIZE, DEFAULT_SOUND_PATH);
         
     }
     
    @Override
    public TowerBuilder buildWeapons(Integer... weapons) {
        return buildWeapons(Arrays.stream(weapons).collect(Collectors.toList()));
    }
    
    @Override
    public TowerBuilder buildWeapons(List<Integer> weapons) {
        this.weapons.setProperty(weapons);
        return this;
    }
    
    @Override
    public TowerBuilder buildAbilities(Integer... abilities) {
        return buildWeapons(Arrays.stream(abilities).collect(Collectors.toList()));
    }
    
    @Override
    public TowerBuilder buildAbilities(List<Integer> abilities) {
        this.abilities.setProperty(abilities);
        return this;
    }
    
    @Override
    public TowerBuilder buildUpgrades(Integer... upgrades) {
        return buildWeapons(Arrays.stream(upgrades).collect(Collectors.toList()));
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
        this.weapons = new ObservableListProperty<Integer>(Arrays.stream(DEFAULT_WEAPONS).collect(Collectors.toList()));
        this.abilities = new ObservableListProperty<Integer>(Arrays.stream(DEFAULT_ABILITIES).collect(Collectors.toList()));
        this.upgrades = new ObservableListProperty<Integer>(Arrays.stream(DEFAULT_UPGRADES).collect(Collectors.toList()));
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

    @Override
    protected TowerBuilder copyType (Tower type) {
        return this
        .buildWeapons(type.getWeapons())
        .buildAbilities(type.getAbilities())
        .buildUpgrades(type.getUpgrades())
        .buildCost(type.getCost())
        .buildSellAmount(type.getSellAmount())
        .buildUnlockLevel(type.getUnlockLevel());
    }
    

    
}