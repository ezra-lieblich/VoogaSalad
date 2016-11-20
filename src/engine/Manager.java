package engine;

public interface Manager extends Type{

    void removeEntry (int id);

    /**
     * Creates a new entity and activates it
     * 
     * @return This returns the ID of the most recently added Entity
     */
    int create ();

    void setActiveEntity (int id);

}
