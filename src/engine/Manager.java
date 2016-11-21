package engine;

public interface Manager<E extends Type> {

    int addEntry (E entry);

    void removeEntry (int id);

    //TODO - Make this private and just pass in a functional static interface
    E getActiveEntity ();

    int getActiveId ();

    void setActiveId (int activeId);

}
