package engine.tower;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import engine.AbstractType;
import engine.enemy.EnemyType;
import engine.weapon.WeaponType;

public class TowerType extends AbstractType {
    /*public static final String DEFAULT_NAME = "New Tower";
    public static final String DEFAULT_IMAGE_LOCATION = "Images.penguin.jpg";
    public static final String DEFAULT_ATTACK_PREFERENCE = "all";
    public static final double DEFAULT_COST = 100;
    public static final double DEFAULT_SELL_AMOUNT = DEFAULT_COST / 2;
    public static final int DEFAULT_UNLOCK_LEVEL = 0;
    */
    private List<TowerType> upgrades;
    private List<WeaponType> weapons;
    private List<EnemyType> targets;
    private List<AbilityType> abilities;
    private String attackPreference;
    private double cost;
    private double sellAmount;
    private int unlockLevel;    

    public TowerType () {
        this.upgrades = new ArrayList<TowerType>();
        this.targets = new ArrayList<EnemyType>();
        this.weapons = new ArrayList<WeaponType>();
        this.abilities = new ArrayList<AbilityType>();
        this.attackPreference = getResources("TowerTypeAttackPreference");
        this.cost = Double.parseDouble(getResources("TowerTypeCost"));
        this.sellAmount = Double.parseDouble(getResources("TowerTypeSellAmount"));
        this.unlockLevel = Integer.parseInt(getResources("TowerTypeUnlockLevel"));
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
