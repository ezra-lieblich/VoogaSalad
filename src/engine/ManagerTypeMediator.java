package engine;

import java.util.HashMap;
import java.util.Map;
import engine.observer.Observable;

/**
 * This class handles the dependencies between the managers
 * 
 * @author seanhudson
 *
 */
public class ManagerTypeMediator implements ManagerMediator{
    
    private Map<Class<?>, Manager<? extends Type>> allManagers;
   
    public ManagerTypeMediator() {
        allManagers = new HashMap<Class<?>, Manager<? extends Type>>();
    }
    
    
    @SuppressWarnings("unchecked")
    @Override
    public <R extends Observable<MethodData<Object>>> void update (R observable,
                                                                   MethodData<Object> value) {
        allManagers.values().forEach(a -> a.visitManager((VisitableManager<MethodData<Object>>) observable, value));        
    }

    @Override
    public void addManager(Manager<? extends Type> manager) {
        allManagers.put(manager.getClass().getInterfaces()[0], manager);
    }
    
    @Override
    public void removeManager(Manager<? extends Type> manager) {
        allManagers.remove(manager.getClass());
    }

    @Override
    public <R> R getManager(Class<R> key) {
        return key.cast(allManagers.get(key));
    }

}
