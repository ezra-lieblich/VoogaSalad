package engine;

import java.util.function.Consumer;
import engine.observer.Observable;

public interface Manager<E extends Type> extends VisitorManager, VisitableManager<Integer>, Observable<MethodData<Integer>> {

    int addEntry (E entry);

    void removeEntry (int id);
    
    public E getEntity (int index);

    //TODO - Make this private and just pass in a functional static interface
    E getActiveEntity ();

    int getActiveId ();

    void setActiveId (int activeId);

    void applyToAllEntities (Consumer<E> entry);
}
