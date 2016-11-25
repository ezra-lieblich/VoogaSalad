package engine.observer;

import engine.MethodData;
import engine.Type;
import engine.VisitableManager;

public interface ObservableManager extends Observable<MethodData<Integer>>, VisitableManager<Type> {

}
