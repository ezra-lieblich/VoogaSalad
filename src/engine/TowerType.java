package engine;

import java.util.ArrayList;
import java.util.List;

public class TowerType extends Entity {
    private List<TowerType> upgrades;
    private List<WeaponType> weapons;
    private List<EnemyType> targets;
    private List<String> abilities;
    private double cost;
    private String attackPreference;
    
    TowerType () {
        this.upgrades = new ArrayList<TowerType>();
        this.targets = new ArrayList<EnemyType>();
        this.weapons = new ArrayList<WeaponType>();
        this.abilities = new ArrayList<String>();
        setCost(0);
        setAttackPreference("");
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
