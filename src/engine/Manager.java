package engine;

import java.util.function.Consumer;
import engine.observer.Observable;

public interface Manager<E extends Type> extends VisitorManager<MethodData<?>>, VisitableManager<MethodData<?>>, Observable<MethodData<?>> {

    int addEntry (E entry);

    void removeEntry (int id);
    
    //TODO - Make this private and just pass in a functional static interface
    E getActiveEntity ();

    int getActiveId ();

    void setActiveId (int activeId);

    void applyToAllEntities (Consumer<E> entry);
}
