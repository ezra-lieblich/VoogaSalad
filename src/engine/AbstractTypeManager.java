package engine;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.function.Consumer;
import java.util.function.Supplier;


public abstract class AbstractTypeManager<E extends Type> extends Observable implements Manager {
    Map<Integer, E> data;
    int nextId;

    private void addEntry (E entry) {
        data.put(nextId, entry);
        nextId++;
    }

    @Override
    public void removeEntry (int id) {
        notifyObservers(data.remove(id));
    }

    protected int getNextId () {
        return nextId;
    }
    

    @Override
    public int create () {
        addEntry(createInstance());
        return nextId - 1;
    }
    
    protected <U> U getFromActiveEntity(Supplier<U> getter) {
        return getter.get();
    }

    protected <U> void setForActiveEntity(Consumer<U> setter, U newValue) {
        setter.accept(newValue);
        //notifyObservers(activeId);
    }

    private E getEntity (int index) {
        return data.get(index);
    }

    protected abstract E createInstance ();

    
    /*
     * public void activate(int ... ids) {
     * activeEntities.clear();
     * Arrays.asList(ids).stream().map(data::get).forEach(activeEntities::add);
     * }
     * 
     * protected void applyToActive(Consumer<E> function) {
     * activeEntities.stream().forEach(function);
     * }
     */

}
