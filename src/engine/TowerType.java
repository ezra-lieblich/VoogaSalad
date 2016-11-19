package engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TowerType extends Entity {
    private List<TowerType> upgrades;
    private List<WeaponType> weapons;
    private List<EnemyType> targets;
    private List<AbilityType> abilities;
    private String name; 
    private String imageLocation; 
    private String attackPreference;
    private double cost;
    private double sellAmount;
    private int unlockLevel;
    private int fireRate; 
    

    public TowerType (String name, String imageLocation, double cost, double sellAmount, int fireRate, int unlockLevel) {
        this.upgrades = new ArrayList<TowerType>();
        this.targets = new ArrayList<EnemyType>();
        this.weapons = new ArrayList<WeaponType>();
        this.abilities = new ArrayList<AbilityType>();
        this.attackPreference = "large";
        this.cost = 100;
        this.sellAmount = 1000;
        this.unlockLevel = 3;
    }
	
    public void addUpgrade(TowerType upgrade) {
        upgrades.add(upgrade);
    }
    
    public void removeUpgrade(TowerType upgrade) {
        upgrades.remove(upgrade);
    }
    
    public List<TowerType> getUpgrades() {
        return Collections.unmodifiableList(upgrades);
    }

    public void addWeapon (WeaponType weapon) {
        weapons.add(weapon);
    }

    public void removeWeapon (WeaponType weapon) {
        weapons.remove(weapon);
    }
    
    public List<WeaponType> getWeapon() {
        return Collections.unmodifiableList(weapons);
    }

    public void removeTarget (EnemyType target) {
        targets.remove(target);
    }

    public void addTarget (EnemyType target) {
        targets.add(target);
    }
    
    public List<EnemyType> getTargets() {
        return Collections.unmodifiableList(targets);
    }

    public void removeAbility (AbilityType ability) {
        abilities.remove(ability);
    }

    public void addAbility (AbilityType ability) {
        abilities.add(ability);
    }
    
    public List<AbilityType> getAbility() {
        return Collections.unmodifiableList(abilities);
    }
    
    public double getCost () {
        return cost;
    }

    public void setCost (double cost) {
        this.cost = cost;
    }

    public String getAttackPreference () {
        return attackPreference;
    }

    public void setAttackPreference (String attackPreference) {
        this.attackPreference = attackPreference;
    }

    public double getSellAmount () {
        return sellAmount;
    }

    public void setSellAmount (double sellAmount) {
        this.sellAmount = sellAmount;
    }

    public int getUnlockLevel () {
        return unlockLevel;
    }

    public void setUnlockLevel (int unlockLevel) {
        this.unlockLevel = unlockLevel;
    }
}
