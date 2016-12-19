package engine;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import engine.effect.ReflectionException;
import engine.observer.AbstractObservable;
import engine.observer.ObservableMap;
import engine.observer.ObservableMapProperty;


/**
 * This class implements the abstract behavior for the Manager classes
 * 
 * @author seanhudson
 *
 * @param <E> Type subclass
 */
public abstract class AbstractTypeManager<E extends Type> extends AbstractObservable<MethodData<Object>>
        implements Manager<E> {
    private static final String INVALID_REFLECTION_CALL = "Invalid reflection call";
    
    private ObservableMap<Integer, E> data;

    protected AbstractTypeManager () {
        this.data = new ObservableMapProperty<Integer, E>(new HashMap<Integer, E>());
    }

    @Override
    public int addEntry (E entry) {
        data.put(entry.getId(), entry);
        return entry.getId();
    }

    @Override
    public void removeEntry (int id) {
        data.remove(id);
        notifyObservers(new MethodObjectData<Object>("RemoveEntry", id));
    }

    @Override
    public void applyToAllEntities (Consumer<E> entry) {
        data.getProperty().values().stream().forEach(entry);
    }

    @Override
    public void addEntitiesListener (BiConsumer<Map<Integer, E>, Map<Integer, E>> listener) {
        data.addListener(listener);
    }

    @Override
    public List<Integer> getEntityIds () {
        return Collections.unmodifiableList(new ArrayList<Integer>(data.getProperty().keySet()));
    }
    
    @Override
    public void setEntities(Map<Integer, E> entities) {
    	this.data.setProperty(entities);
    }
    
    @Override
    public int getMaxId() {
        return getEntityIds().isEmpty() ? -1 : Collections.max(getEntityIds());
    }

    @Override // TODO - hide in interface
    public E getEntity (int index) {
        return data.getProperty().get(index);
    }

    @Override
    public <U extends VisitableManager<MethodData<Object>>> void visitManager (U visitableManager,
                                                                          MethodData<Object> dataMethod) throws ReflectionException {
        try {
            Method visitMethod =
                    this.getClass().getMethod("visit" + dataMethod.getMethod(),
                                              new Class[] { visitableManager.getClass().getInterfaces()[0], Integer.class });
            visitMethod.invoke(this, new Object[] { visitableManager, dataMethod.getValue() });
        }
        catch (NoSuchMethodException | IllegalArgumentException  | InvocationTargetException e) {
            // This means that the class does not depend on the visitor and so does not have the subsequent handling methods (Not an Error)
            // This allows for the class to dynamically handle additional visitable objects, without having to make a method for each one in very visitor
        	return;
        }
        catch (SecurityException | IllegalAccessException e) {
                throw new ReflectionException(e, INVALID_REFLECTION_CALL);
        }
    }

    @Override
    public <U extends VisitorManager<MethodData<Object>>> void accept (U visitor,
                                                                  MethodData<Object> methodData) {
        visitor.visitManager(this, methodData);
    }
    
    @Override
    public Map<Integer, E> getEntities() {
        return data.getProperty();
    }

}
