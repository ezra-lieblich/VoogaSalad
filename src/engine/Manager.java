package engine;

public interface Manager{

    void removeEntry (int id);

    /**
     * Creates a new entity and activates it
     * 
     * @return This returns the ID of the most recently added Entity
     */
    int create ();
    
}
