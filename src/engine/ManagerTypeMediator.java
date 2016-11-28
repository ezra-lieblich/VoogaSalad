package engine;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import engine.ability.Ability;
import engine.enemy.Enemy;
import engine.level.Level;
import engine.path.Path;
import engine.tower.Tower;
import engine.weapon.Weapon;
//TODO - maybe implement observer pattern with each manager as both observer/observable
//TODO - use generics
public class ManagerTypeMediator implements ManagerMediator {
    
    private List<Manager<?>> enemyReferences;
    private List<Manager<?>> weaponReferences;
    
    private List<Manager<? extends Type>> allManagers;
    
    private Manager<Enemy> enemyManager;
    private Manager<Tower> towerManager;
    private Manager<Weapon> weaponManager;
    private Manager<Level> levelManager;
    private Manager<Path> pathManager;
    private Manager<Ability> abilityManager;
    
    ManagerTypeMediator(Manager<Enemy> enemyManager, Manager<Tower> towerManager, Manager<Weapon> weaponManager, Manager<Level> levelManager, Manager<Path> pathManager, Manager<Ability> abilityManager) {
        this.enemyManager = enemyManager;
        this.towerManager = towerManager;
        this.weaponManager = weaponManager;
        this.levelManager = levelManager;
        this.pathManager = pathManager;
        this.abilityManager = abilityManager;
    }
    
    @Override
    public void removeEntryReferences(Enemy enemy) {
        towerManager.applyToAllEntities(a -> a.removeEnemy(enemy));
        //levelManager.applyToAllEntities(a -> a.removeEnemy(enemy));
    }
    
    @Override
    public void removeEntryReferences(Tower tower) {

    }
    
    @Override
    public void removeEntryReferences(Weapon enemy) {
        towerManager.applyToAllEntities(a -> a.removeWeapon(enemy));
    }
    
    @Override
    public void removeEntryReferences(Level level) {

    }
    
    @Override
    public void removeEntryReferences(Path path) {

    }
    
    //@Override
    public <E extends Type> void removeEntryReferences(E entry) {
        //TODO - Is this bad?/ does this even get called?
    }
    
    
    @Override
    public void removeEntryReferences(Ability ability) {
        towerManager.applyToAllEntities(a -> a.removeAbility(ability));
    }
    
    @Override
    public Enemy getEnemy(int id) {
        //BiFunction<Manager<Enemy>, Integer, Enemy> test = (a, b) -> a.getEntity(b);
        //allManagers.forEach(a -> getter.get());
        return enemyManager.getEntity(id);
    }
    
    @Override
    public Tower getTower(int id) {
        return towerManager.getEntity(id);
    }
    
    @Override
    public Weapon getWeapon(int id) {
        return weaponManager.getEntity(id);
    }
    
    @Override
    public Level getLevel(int id) {
        return levelManager.getEntity(id);
    }
    
    @Override
    public Path getPath(int id) {
        return pathManager.getEntity(id);
    }
    
    @Override
    public Ability getAbility(int id) {
        return abilityManager.getEntity(id);
    }
    
    
    //E getEntity(int index)
    
    /*public <? super Type> void getEntityReference(Function<Integer, ?> getter, int index) {
        
    }*/
    
    
    
}
