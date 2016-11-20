package engine;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.function.Consumer;

public abstract class AbstractTypeManager <E extends Type> extends Observable{
    Map<Integer, E> data;
    //List<E> activeEntities;
    E activeEntity;
    int nextId;
    
    
    private void addEntry(E entry) {
        data.put(nextId, entry);
        //activeEntities.clear();
        //activeEntities.add(entry);
        nextId++;
    }
    
    public void removeEntry(int id) {
        data.remove(id);
    }
    
    public int getNextId() {
        return nextId;
    }
    
    /**
     * Creates a new entity and activates it
     * 
     * @return This returns the ID of the most recently added Entity
     */
    public int create() {
        addEntry(createInstance());
        return nextId - 1;
    }
    
    
    
    /*public void activate(int ... ids) {
        activeEntities.clear();
        Arrays.asList(ids).stream().map(data::get).forEach(activeEntities::add);
    }
    
    protected void applyToActive(Consumer<E> function) {
        activeEntities.stream().forEach(function);
    }*/
    
    private E getEntity(int index) {
        return data.get(index);
    }
    
    public E getActiveEntity() {
        return activeEntity;
    }
    
    public void setActiveEntity(int id) {
        activeEntity = getEntity(id);
    }
    
    protected abstract E createInstance();
    
    
}
