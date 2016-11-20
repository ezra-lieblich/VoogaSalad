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
        this.name = name; 
        this.imageLocation = imageLocation; 
        this.cost = cost; 
        this.sellAmount = sellAmount; 
        this.fireRate = fireRate; 
        this.unlockLevel = unlockLevel;
    }
    
    public String getImageLocation(){
    	return imageLocation; 
    }
    
    public String getName(){
    	return name; 
    }
    
    public double getSellAmount(){
    	return sellAmount; 
    }
    
    public int getUnlockLevel(){
    	return unlockLevel;
    }
    
    public int getFireRate(){
    	return fireRate; 
    }
	
    public void addUpgrade(TowerType upgrade) {
        upgrades.add(upgrade);
    }
    
    public void removeUpgrade(TowerType upgrade) {
        upgrades.remove(upgrade);
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
}
