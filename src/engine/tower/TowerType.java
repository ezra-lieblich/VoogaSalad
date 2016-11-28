package engine.tower;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import engine.AbstractType;
import engine.ability.Ability;
import engine.enemy.Enemy;
import engine.enemy.EnemyType;
import engine.weapon.Weapon;
import engine.weapon.WeaponType;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;


public class TowerType extends AbstractType implements Tower {

    private List<Tower> upgrades;
    private List<Weapon> weapons;
    private List<Enemy> targets;
    private List<Ability> abilities;
    private double cost;
    private double sellAmount;
    private int unlockLevel;

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
    public void addUpgrade (Tower upgrade) {
        upgrades.add(upgrade);
    }

    @Override
    public void removeUpgrade (Tower upgrade) {
        upgrades.removeIf(a -> a.equals(upgrade));
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
        weapons.removeIf(a -> a.equals(weapon));
    }

    @Override
    public List<Weapon> getWeapon () {
        return Collections.unmodifiableList(weapons);
    }

    @Override
    public void removeEnemy (Enemy target) {
        targets.removeIf(a -> a.equals(target));
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
        abilities.removeIf(a -> a.equals(ability));
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
