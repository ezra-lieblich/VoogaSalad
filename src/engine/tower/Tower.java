package engine.tower;

import java.util.List;
import engine.Type;
import engine.enemy.EnemyType;
import engine.weapon.Weapon;
import engine.weapon.WeaponType;


public interface Tower extends Type {

    void addUpgrade (TowerType upgrade);

    void removeUpgrade (Tower upgrade);

    List<TowerType> getUpgrades ();

    void addWeapon (WeaponType weapon);

    void removeWeapon (Weapon weapon);

    List<WeaponType> getWeapon ();

    void removeTarget (EnemyType target);

    void addTarget (EnemyType target);

    List<EnemyType> getTargets ();

    void removeAbility (Ability ability);

    void addAbility (AbilityType ability);

    List<AbilityType> getAbility ();

    double getCost ();

    void setCost (double cost);

    double getSellAmount ();

    void setSellAmount (double sellAmount);

    int getUnlockLevel ();

    void setUnlockLevel (int unlockLevel);

}
