package engine;

import java.util.Map;

public abstract class EntityManager <E extends Entity> {
    Map<Integer, E> data;
    int nextId;
    
    
    public void addEntry(E entry) {
        data.put(nextId, entry);
        nextId++;
    }
    
    public void removeEntry(E entry) {
        data.remove(entry);
    }
    
    public int getNextId() {
        return nextId;
    }
    
    public abstract E create();
    
}
