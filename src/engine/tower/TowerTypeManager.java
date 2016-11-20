package engine.tower;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import engine.AbstractTypeManager;
import engine.enemy.EnemyType;
import engine.weapon.Weapon;
import engine.weapon.WeaponType;

public class TowerTypeManager extends AbstractTypeManager<Tower> implements TowerManager {

    //private Map<WeaponType, List<TowerType>> weaponMappings = new HashMap<WeaponType, List<TowerType>>();

    @Override
    protected Tower createInstance () {
        return new TowerType();
    }

    @Override
    public void addUpgrade () {
        //add active prototype to Tower list
        getActiveEntity().addUpgrade(upgrade);
        notifyObservers(getActiveId());
    }

    @Override
    public void removeUpgrade (Tower upgrade) {
        getActiveEntity().removeUpgrade(upgrade);
        notifyObservers(getActiveId());
    }

    @Override
    public List<TowerType> getUpgrades () {
        return getActiveEntity().getUpgrades();
    }

    @Override
    public void addWeapon (WeaponType weapon) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void removeWeapon (Weapon weapon) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<WeaponType> getWeapon () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void removeTarget (EnemyType target) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void addTarget (EnemyType target) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<EnemyType> getTargets () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void removeAbility (Ability ability) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void addAbility (AbilityType ability) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<AbilityType> getAbility () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public double getCost () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setCost (double cost) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public double getSellAmount () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setSellAmount (double sellAmount) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int getUnlockLevel () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setUnlockLevel (int unlockLevel) {
        // TODO Auto-generated method stub
        
    }

    
//    public void removeWeaponMapping(Weapon weapon) {
//        //Can do a dope stream here
//        for (Tower tower : weaponMappings.get(weapon)) {
//            tower.removeWeapon(weapon);
//        }
//        weaponMappings.remove(weapon);
//    }

}
