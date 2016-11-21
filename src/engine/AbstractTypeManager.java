package engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.function.Consumer;
import java.util.function.Supplier;


public abstract class AbstractTypeManager<E extends Type> extends Observable implements Manager<E> {
    Map<Integer, E> data;
    int activeId;

    @Override
    public int addEntry (E entry) {
        data.put(entry.getId(), entry);
        return entry.getId();
    }

    @Override
    public void removeEntry (int id) {
        notifyObservers(data.remove(id));
    }
    
    protected <U> U getFromEntity(Supplier<U> getter) {
        return getter.get();
    }

    protected <U> void setForEntity(Consumer<U> setter, U newValue) {
        setter.accept(newValue);
        //notifyObservers(activeId);
    }

    /*public <U> Consumer<U> setForActiveEntity(Consumer<U> setter, U newValue) {
        //Apply Type::setName to activeEntity
        Consumer<U> blahtest = e - setter.accept(newValue);; //.setName(c); // Type::setName;
        List<E> tester = new ArrayList<E>();
        tester.forEach(setter);
        Consumer<U> activeFunc = c -> getActiveEntity()::setter;
        Consumer<AbstractTypeManager> eblah = c -> c.setForActiveEntity(getActiveEntity()::setter)
    }*/
    
    private E getEntity (int index) {
        return data.get(index);
    }

    //TODO - Make this private and just pass in a functional static interface
    /* (non-Javadoc)
     * @see engine.Manager#getActiveEntity()
     */
    @Override
    public E getActiveEntity () {
        return getEntity(activeId);
    }

    /* (non-Javadoc)
     * @see engine.Manager#getActiveId()
     */
    @Override
    public int getActiveId () {
        return activeId;
    }

    /* (non-Javadoc)
     * @see engine.Manager#setActiveId(int)
     */
    @Override
    public void setActiveId (int activeId) {
        this.activeId = activeId;
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
    
}
