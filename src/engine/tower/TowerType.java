package engine.tower;

import java.util.List;
import engine.AbstractType;
import engine.observer.ObservableList;
import engine.observer.ObservableProperty;

/**
 * 
 * 
 * @author seanhudson
 *
 */
public class TowerType extends AbstractType implements Tower {

    private ObservableList<Integer> weapons;
    private ObservableList<Integer> abilities;
    private ObservableList<Integer> upgrades;
    private ObservableProperty<Double> cost;
    private ObservableProperty<Double> sellAmount;
    private ObservableProperty<Integer> unlockLevel;

    protected TowerType (TowerInitializer towerInitializer) {
        super(towerInitializer);
        this.upgrades = towerInitializer.getUpgrades();
        this.weapons = towerInitializer.getWeapons();
        this.abilities = towerInitializer.getAbilities();
        this.cost = towerInitializer.getCost();
        this.sellAmount = towerInitializer.getSellAmount();
        this.unlockLevel = towerInitializer.getUnlockLevel();
    }

    @Override
    public void addUpgrade (int upgrade) {
        upgrades.add(upgrade);
    }
    
    @Override
    public void removeUpgrade (int upgrade) {
        upgrades.remove(upgrade);
    }

    @Override
    public List<Integer> getUpgrades () {
        return upgrades.getProperty();
    }
    
    @Override
    public void addWeapon (int weapon) {
        weapons.add(weapon);
    }

    @Override
    public void removeWeapon (int weapon) {
        weapons.remove(weapon);
    }

    @Override
    public List<Integer> getWeapons () {
        return weapons.getProperty();
    }

    @Override
    public void removeAbility (int ability) {
        abilities.remove(ability);
    }

    @Override
    public void addAbility (int ability) {
        abilities.add(ability);
    }

    @Override
    public List<Integer> getAbilities () {
        return abilities.getProperty();
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
