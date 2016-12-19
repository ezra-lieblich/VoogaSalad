package engine;


/**
 * This interface provides an implementation of the visitor pattern for the managers
 * 
 * @author seanhudson
 *
 * @param <E> Value Type
 */
public interface VisitableManager<E>{

    /**
     * Method that accepts visitors.
     * Implement by with the body "visitor.vistManager(this, value)"
     * 
     * @param visitor
     * @param value
     */
    <U extends VisitorManager<E>> void accept (U visitor, E value);
}
