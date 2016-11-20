package engine;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.function.Consumer;
import java.util.function.Supplier;


public abstract class AbstractTypeManager<E extends Type> extends Observable implements Manager<E> {
    Map<Integer, E> data;
    // List<E> activeEntities;
    int activeId;
    int nextId;

    private void addEntry (E entry) {
        data.put(nextId, entry);
        // activeEntities.clear();
        // activeEntities.add(entry);
        nextId++;
    }

    @Override
    public void removeEntry (int id) {
        data.remove(id);
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
        notifyObservers(activeId);
    }
    
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

    private E getEntity (int index) {
        return data.get(index);
    }

    protected E getActiveEntity () {
        return getEntity(activeId);
    }

    @Override
    public void setActiveEntity (int id) {
        activeId = id;
    }
    
    protected int getActiveId() {
        return activeId;
    }

    protected abstract E createInstance ();

    @Override
    public String getName () {
        return getFromActiveEntity(getActiveEntity()::getName);
    }

    @Override
    public void setName (String name) {
        setForActiveEntity(getActiveEntity()::setName, name);
    }

    @Override
    public String getImagePath () {
        return getFromActiveEntity(getActiveEntity()::getImagePath);
    }

    @Override
    public void setImagePath (String imagePath) {
        setForActiveEntity(getActiveEntity()::setImagePath, imagePath);
    }

    @Override
    public double getSize () {
        return getFromActiveEntity(getActiveEntity()::getSize);
    }

    @Override
    public void setSize (double size) {
        setForActiveEntity(getActiveEntity()::setSize, size);
    }
}
