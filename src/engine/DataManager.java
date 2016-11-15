package engine;

import java.util.List;

public abstract class DataManager <E> {
    List<E> data;
    int id;
    
    public void addEntry(E entry) {
        data.add(entry);
        id++;
    }
    
    public void removeEntry(E entry) {
        data.remove(entry);
    }
        
}
