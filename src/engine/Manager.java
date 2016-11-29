package engine;

import java.util.function.Consumer;
import engine.observer.Observable;

public interface Manager<E extends Type> extends VisitorManager<MethodData<?>>, VisitableManager<MethodData<?>>, Observable<MethodData<?>>, BindableManager<E> {

    int addEntry (E entry);

    void removeEntry (int id);
    
    E getEntity(int id);

    void applyToAllEntities (Consumer<E> entry);
}
