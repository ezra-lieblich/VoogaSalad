package engine;

import engine.observer.Observable;
import engine.observer.Observer;

/**
 * This interface handles the methods of the mediator class which manages the dependencies between managers
 * 
 * @author seanhudson
 *
 */
public interface ManagerMediator extends Observer<Observable<MethodData<Object>>, MethodData<Object>> {//Observer<Manager<? extends Type>, MethodData<Object>> {

    void addManager(Manager<? extends Type> manager);

    void removeManager(Manager<? extends Type> manager);
    
    <R> R getManager (Class<R> key);

}
