package engine.tower;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import engine.AbstractType;
import engine.ability.Ability;
import engine.enemy.Enemy;
import engine.enemy.EnemyType;
import engine.observer.ObservableProperty;
import engine.weapon.Weapon;
import engine.weapon.WeaponType;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;


public class TowerType extends AbstractType implements Tower {

    private List<Integer> upgrades;
    private List<Integer> weapons;
    private List<Integer> targets;
    private List<Integer> abilities;
    private ObservableProperty<Double> cost;
    private ObservableProperty<Double> sellAmount;
    private ObservableProperty<Integer> unlockLevel;

    protected TowerType (TowerInitializer towerInitializer) {
        super(towerInitializer);
        this.upgrades = towerInitializer.getUpgrades();
        this.targets = towerInitializer.getTargets();
        this.weapons = towerInitializer.getWeapons();
        this.abilities = towerInitializer.getAbilities();
        this.cost = towerInitializer.getCost();
        this.sellAmount = towerInitializer.getSellAmount();
        this.unlockLevel = towerInitializer.getUnlockLevel();
    }

    @Override
    public void addUpgrade (Integer upgrade) {
        upgrades.add(upgrade);
    }

    @Override
    public void removeUpgrade (Integer upgrade) {
        upgrades.removeIf(a -> a.equals(upgrade));
    }

    @Override
    public List<Integer> getUpgrades () {
        return Collections.unmodifiableList(upgrades);
    }

    @Override
    public void addWeapon (Integer weapon) {
        weapons.add(weapon);
    }

    @Override
    public void removeWeapon (Integer weapon) {
        weapons.removeIf(a -> a.equals(weapon));
    }

    @Override
    public List<Integer> getWeapons () {
        return Collections.unmodifiableList(weapons);
    }

    @Override
    public void removeEnemy (Integer target) {
        targets.removeIf(a -> a.equals(target));
    }

    @Override
    public void addTarget (Integer target) {
        targets.add(target);
    }

    @Override
    public List<Integer> getTargets () {
        return Collections.unmodifiableList(targets);
    }

    @Override
    public void removeAbility (Integer ability) {
        abilities.removeIf(a -> a.equals(ability));
    }

    @Override
    public void addAbility (Integer ability) {
        abilities.add(ability);
    }

    @Override
    public List<Integer> getAbilities () {
        return Collections.unmodifiableList(abilities);
    }

    @Override
    public double getCost () {
        return cost.getProperty();
    }

    @Override
    public void setCost (double cost) {
        this.cost.setProperty(cost);;
    }

    @Override
    public double getSellAmount () {
        return sellAmount.getProperty();
    }

    @Override
    public void setSellAmount (double sellAmount) {
        this.sellAmount.setProperty(sellAmount);;
    }

    @Override
    public int getUnlockLevel () {
        return unlockLevel.getProperty();
    }

    @Override
    public void setUnlockLevel (int unlockLevel) {
        this.unlockLevel.setProperty(unlockLevel);;
    }
}
