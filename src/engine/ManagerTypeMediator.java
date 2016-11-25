package engine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import engine.ability.Ability;
import engine.enemy.Enemy;
import engine.enemy.EnemyManager;
import engine.enemy.EnemyTypeManager;
import engine.level.Level;
import engine.observer.AbstractObservable;
import engine.observer.Observable;
import engine.observer.Observer;
import engine.path.Path;
import engine.tower.Tower;
import engine.tower.TowerTypeManager;
import engine.weapon.Weapon;
//TODO - maybe implement observer pattern with each manager as both observer/observable
//TODO - use generics
//TODO - override each manager's hashcode (to make it unique) or give managers an index (support multiple);
public class ManagerTypeMediator implements ManagerMediator, Observer<Manager<?>, MethodData<Integer>> {
    
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
        super();
        this.enemyManager = enemyManager;
        this.towerManager = towerManager;
        this.weaponManager = weaponManager;
        this.levelManager = levelManager;
        this.pathManager = pathManager;
        this.abilityManager = abilityManager;
    }
    
    ManagerTypeMediator() {
        
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
        ///Manager<Enemy> test = new EnemyTypeManager(null);
        //Function<? super Manager<? extends Type>> test;
        //Consumer<Integer> test = Manager<Enemy>::getEntity;
        //Function<? super Manager<? extends Type>, E>;
        //getEntry(Manager<Enemy>::getActiveEntity);
        //allManagers.stream().map(mapper)
        
        return enemyManager.getEntity(id);
    }
    
    //return E
    public <E> void getEntry(Function<Manager<? extends Type>, E> func) {
        //Function<? super Manager<? extends Type>, ?> getter = a -> a.getEntity(id);   //Manager<? extends Type>::getActiveId;
        //allManagers.forEach(getter);
        Consumer<? super Manager<? extends Type>> test = Manager::getActiveEntity;
        Function<Manager<?>, ?> testParams = a -> a.getEntity(10);
        //Consumer<? super Manager<? extends Type>> testParams = Manager::getEntity;
        //Consumer<? extends Manager<? extends Type>> test = EnemyManager::getActiveEntity;
        allManagers.add(new TowerTypeManager(null));
        List<Manager<Enemy>> listTest = new ArrayList<Manager<Enemy>>();
        listTest.add(new EnemyTypeManager(null));
        //List<Manager<Enemy>> listTest = new ArrayList<EnemyManager>();
        //List<Number> polyTest = new ArrayList<Integer>();
        allManagers.stream().forEach(test);
        allManagers.stream().forEach(test); //.map(Manager<Enemy>::getActiveEntity).reduce((a, b) -> b).get();
        
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
    
    //TODO - Ask Duvall how to get around this. Chain of command variation
    public <E extends Type, R> R applyToAll(Function<Manager<E>, R> func, Class<Manager<E>> receivingManager) {
        Iterator<Manager<? extends Type>> iter = allManagers.iterator();
        Manager<? extends Type> managerWildCard = null;
        while(iter.hasNext()) {
            if(iter.next().getClass().equals(receivingManager)) {
                Manager<E> manager = receivingManager.cast(managerWildCard);
                return func.apply(manager);
            }
           
//            try {
//               Manager<E> manager = clazz.cast(managerWildCard);
//               func.apply(manager);
//            }
//            catch (ClassCastException e) {
//                managerWildCard = iter.next();
//            }
        }
        return null;
    }
    
//    private <E extends Type> E testHelper(Manager<E> manager) {
//        return manager.getActiveEntity();
//    }
//    
//    private <E extends Manager<?>, R> R getEntityHelper(E manager, Function<E, R> func) {
//        manager.getClass();
//        return func.apply(manager);
//    }
    
    public static void main(String[] args) {
        ManagerMediator testManager = new ManagerTypeMediator();
        Manager<Enemy> testM = new EnemyTypeManager(null);
        Consumer<? super Manager<? extends Type>> test = Manager::getActiveEntity;
        Function<? super Manager<? extends Type>, ?> getter = a -> a.getEntity(10);
        System.out.println(test.toString());
        System.out.println(getter.toString());
        System.out.println(testM);
        VisitableManager<MethodData<Integer>> blah = new EnemyTypeManager(null);
        System.out.print(blah.getClass().getName());
        
    }

    @Override
    public <R extends Manager<?>> void update (R observable, MethodData<Integer> value) {
        allManagers.forEach(a -> a.visitManager(observable, value));
    }
    

    
}
