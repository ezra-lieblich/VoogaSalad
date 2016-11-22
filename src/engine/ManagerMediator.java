package engine;

import engine.ability.Ability;
import engine.enemy.Enemy;
import engine.level.Level;
import engine.path.Path;
import engine.tower.Tower;
import engine.weapon.Weapon;


public interface ManagerMediator {

    void removeEntryReferences (Enemy enemy);

    void removeEntryReferences (Tower tower);

    void removeEntryReferences (Weapon enemy);

    void removeEntryReferences (Level level);

    void removeEntryReferences (Path path);

    void removeEntryReferences (Ability ability);
    
    <E extends Type> void removeEntryReferences (E ability);

    Enemy getEnemy (int id);

    Tower getTower (int id);

    Weapon getWeapon (int id);

    Level getLevel (int id);

    Path getPath (int id);

    Ability getAbility (int id);

}
