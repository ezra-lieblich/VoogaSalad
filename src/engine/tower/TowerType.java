package engine.tower;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import engine.AbstractType;
import engine.ability.Ability;
import engine.enemy.EnemyType;
import engine.weapon.Weapon;
import engine.weapon.WeaponType;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;


public class TowerType extends AbstractType implements Tower {
    /*
     * public static final String DEFAULT_NAME = "New Tower";
     * public static final String DEFAULT_IMAGE_LOCATION = "Images.penguin.jpg";
     * public static final String DEFAULT_ATTACK_PREFERENCE = "all";
     * public static final double DEFAULT_COST = 100;
     * public static final double DEFAULT_SELL_AMOUNT = DEFAULT_COST / 2;
     * public static final int DEFAULT_UNLOCK_LEVEL = 0;
     */
    private List<Tower> upgrades;
    private List<Weapon> weapons;
    private List<Enemy> targets;
    private List<Ability> abilities;
    private double cost;
    private double sellAmount;
    private int unlockLevel;

    public TowerType (int id) {
        super(id);
        this.upgrades = new ArrayList<Tower>();
        this.targets = new ArrayList<Enemy>();
        this.weapons = new ArrayList<Weapon>();
        this.abilities = new ArrayList<Ability>();
        this.cost = Double.parseDouble(getResources("TowerTypeCost"));
        this.sellAmount = Double.parseDouble(getResources("TowerTypeSellAmount"));
        this.unlockLevel = Integer.parseInt(getResources("TowerTypeUnlockLevel"));
        //DoubleProperty blah = new SimpleDoubleProperty();
        //blah.addListener((observable, oldValue, newValue) -> view.getTowerView().setHealth(newValue));
        
    }

    @Override
    public void addUpgrade (Tower upgrade) {
        upgrades.add(upgrade);
    }

    @Override
    public void removeUpgrade (Tower upgrade) {
        upgrades.remove(upgrade);
    }

    @Override
    public List<Tower> getUpgrades () {
        return Collections.unmodifiableList(upgrades);
    }

    @Override
    public void addWeapon (Weapon weapon) {
        weapons.add(weapon);
    }

    @Override
    public void removeWeapon (Weapon weapon) {
        weapons.remove(weapon);
    }

    @Override
    public List<Weapon> getWeapon () {
        return Collections.unmodifiableList(weapons);
    }

    @Override
    public void removeTarget (Enemy target) {
        targets.remove(target);
    }

    @Override
    public void addTarget (Enemy target) {
        targets.add(target);
    }

    @Override
    public List<Enemy> getTargets () {
        return Collections.unmodifiableList(targets);
    }

    @Override
    public void removeAbility (Ability ability) {
        abilities.remove(ability);
    }

    @Override
    public void addAbility (Ability ability) {
        abilities.add(ability);
    }

    @Override
    public List<Ability> getAbility () {
        return Collections.unmodifiableList(abilities);
    }

    @Override
    public double getCost () {
        return cost;
    }

    @Override
    public void setCost (double cost) {
        this.cost = cost;
    }

    @Override
    public double getSellAmount () {
        return sellAmount;
    }

    @Override
    public void setSellAmount (double sellAmount) {
        this.sellAmount = sellAmount;
    }

    @Override
    public int getUnlockLevel () {
        return unlockLevel;
    }

    @Override
    public void setUnlockLevel (int unlockLevel) {
        this.unlockLevel = unlockLevel;
    }
}
