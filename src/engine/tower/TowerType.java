package engine.tower;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import engine.AbstractType;
import engine.enemy.EnemyType;
import engine.weapon.Weapon;
import engine.weapon.WeaponType;


public class TowerType extends AbstractType implements Tower {
    /*
     * public static final String DEFAULT_NAME = "New Tower";
     * public static final String DEFAULT_IMAGE_LOCATION = "Images.penguin.jpg";
     * public static final String DEFAULT_ATTACK_PREFERENCE = "all";
     * public static final double DEFAULT_COST = 100;
     * public static final double DEFAULT_SELL_AMOUNT = DEFAULT_COST / 2;
     * public static final int DEFAULT_UNLOCK_LEVEL = 0;
     */
    private List<TowerType> upgrades;
    private List<WeaponType> weapons;
    private List<EnemyType> targets;
    private List<AbilityType> abilities;
    private double cost;
    private double sellAmount;
    private int unlockLevel;

    public TowerType () {
        this.upgrades = new ArrayList<TowerType>();
        this.targets = new ArrayList<EnemyType>();
        this.weapons = new ArrayList<WeaponType>();
        this.abilities = new ArrayList<AbilityType>();
        this.cost = Double.parseDouble(getResources("TowerTypeCost"));
        this.sellAmount = Double.parseDouble(getResources("TowerTypeSellAmount"));
        this.unlockLevel = Integer.parseInt(getResources("TowerTypeUnlockLevel"));
    }

    @Override
    public void addUpgrade (TowerType upgrade) {
        upgrades.add(upgrade);
    }

    @Override
    public void removeUpgrade (Tower upgrade) {
        upgrades.remove(upgrade);
    }

    @Override
    public List<TowerType> getUpgrades () {
        return Collections.unmodifiableList(upgrades);
    }

    @Override
    public void addWeapon (WeaponType weapon) {
        weapons.add(weapon);
    }

    @Override
    public void removeWeapon (Weapon weapon) {
        weapons.remove(weapon);
    }

    @Override
    public List<WeaponType> getWeapon () {
        return Collections.unmodifiableList(weapons);
    }

    @Override
    public void removeTarget (EnemyType target) {
        targets.remove(target);
    }

    @Override
    public void addTarget (EnemyType target) {
        targets.add(target);
    }

    @Override
    public List<EnemyType> getTargets () {
        return Collections.unmodifiableList(targets);
    }

    @Override
    public void removeAbility (Ability ability) {
        abilities.remove(ability);
    }

    @Override
    public void addAbility (AbilityType ability) {
        abilities.add(ability);
    }

    @Override
    public List<AbilityType> getAbility () {
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
