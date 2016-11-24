package engine.tower;

import java.util.Arrays;
import java.util.List;
import engine.AbstractTypeBuilder;
import engine.ability.Ability;
import engine.enemy.Enemy;
import engine.tower.Tower;
import engine.tower.TowerType;
import engine.weapon.Weapon;

public class TowerTypeBuilder extends AbstractTypeBuilder<Tower> implements TowerBuilder {
    
     public static final String DEFAULT_NAME = "New Tower";
     public static final String DEFAULT_IMAGE_PATH = "Images.penguin.jpg";
     public static final int DEFAULT_SIZE = 1;
     public static final List<Tower> DEFAULT_UPGRADES = Arrays.asList(new Tower[]{});
     public static final List<Weapon> DEFAULT_WEAPONS = Arrays.asList(new Weapon[]{});
     public static final List<Enemy> DEFAULT_TARGETS = Arrays.asList(new Enemy[]{});
     public static final List<Ability> DEFAULT_ABILITIES= Arrays.asList(new Ability[]{});
     public static final double DEFAULT_COST = 100;
     public static final double DEFAULT_SELL_AMOUNT = DEFAULT_COST / 2;
     public static final int DEFAULT_UNLOCK_LEVEL = 0;
     
     private List<Tower> upgrades;
     private List<Weapon> weapons;
     private List<Enemy> targets;
     private List<Ability> abilities;
     private double cost;
     private double sellAmount;
     private int unlockLevel;
     
     public TowerTypeBuilder() {
         super(DEFAULT_NAME, DEFAULT_IMAGE_PATH, DEFAULT_SIZE);
         this.upgrades = DEFAULT_UPGRADES;
         this.weapons = DEFAULT_WEAPONS;
         this.targets = DEFAULT_TARGETS;
         this.abilities = DEFAULT_ABILITIES;
         this.cost = DEFAULT_COST;
         this.sellAmount = DEFAULT_SELL_AMOUNT;
         this.unlockLevel = DEFAULT_UNLOCK_LEVEL;
     }
    
    @Override
    public TowerBuilder buildUpgrades(Tower... upgrades) {
        this.upgrades = Arrays.asList(upgrades);
        return this;
    }

    @Override
    public TowerBuilder buildWeapons(Weapon... weapons) {
        this.weapons = Arrays.asList(weapons);
        return this;
    }
    
    @Override
    public TowerBuilder buildTargets(Enemy... targets) {
        this.targets = Arrays.asList(targets);
        return this;
    }
    
    @Override
    public TowerBuilder buildAbilities(Ability... abilities) {
        this.abilities = Arrays.asList(abilities);
        return this;
    }
    
    @Override
    public TowerBuilder buildCost(double cost) {
        this.cost = cost;
        return this;
    }
    
    @Override
    public TowerBuilder buildSellAmount(double sellAmount) {
        this.sellAmount = sellAmount;
        return this;
    }
    
    @Override
    public TowerBuilder buildUnlockLevel(int unlockLevel) {
        this.unlockLevel = unlockLevel;
        return this;
    }

    @Override
    protected Tower create () {
        return new TowerType(this);
    }

    @Override
    public List<Tower> getUpgrades () {
        return upgrades;
    }

    @Override
    public List<Weapon> getWeapons () {
        return weapons;
    }

    @Override
    public List<Enemy> getTargets () {
        return targets;
    }

    @Override
    public List<Ability> getAbilities () {
        return abilities;
    }

    @Override
    public double getCost () {
        return cost;
    }

    @Override
    public double getSellAmount () {
        return sellAmount;
    }

    @Override
    public int getUnlockLevel () {
        return unlockLevel;
    }

    @Override
    protected void restoreDefaults () {
        buildName(DEFAULT_NAME);
        buildImagePath(DEFAULT_IMAGE_PATH);
        buildSize(DEFAULT_SIZE);
        this.weapons = DEFAULT_WEAPONS;
        this.targets = DEFAULT_TARGETS;
        this.abilities = DEFAULT_ABILITIES;
        this.cost = DEFAULT_COST;
        this.sellAmount = DEFAULT_SELL_AMOUNT;
        this.unlockLevel = DEFAULT_UNLOCK_LEVEL;
    }

    
}
