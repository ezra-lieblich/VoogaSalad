package engine;

import java.util.List;

public abstract class DataManager <E> {
    List<E> data;
    int nextId;
    
    
    public void addEntry(E entry) {
        data.add(entry);
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
