package engine.tower;

import java.util.List;
import engine.Type;
import engine.ability.Ability;
import engine.weapon.Weapon;
import gameplayer.model.Enemy;


public interface Tower extends Type {

    void addUpgrade (Tower upgrade);

    void removeUpgrade (Tower upgrade);

    List<Tower> getUpgrades ();

    void addWeapon (Weapon weapon);

    void removeWeapon (Weapon weapon);

    List<Weapon> getWeapon ();

    void removeTarget (Enemy target);

    void addTarget (Enemy target);

    List<Enemy> getTargets ();

    void removeAbility (Ability ability);

    void addAbility (Ability ability);

    List<Ability> getAbility ();

    double getCost ();

    void setCost (double cost);

    double getSellAmount ();

    void setSellAmount (double sellAmount);

    int getUnlockLevel ();

    void setUnlockLevel (int unlockLevel);

}
