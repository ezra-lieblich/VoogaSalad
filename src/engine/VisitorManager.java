package engine;

/**
 * This interface provides an implementation of the visitor pattern for the managers
 * 
 * @author seanhudson
 *
 * @param <E> Value Type
 */
public interface VisitorManager<E> {
    
    /**
     * Visits the visitableManager while passing in a value
     * 
     * @param visitableManager
     * @param value
     */
    <U extends VisitableManager<E>> void visitManager(U visitableManager, E value);
}
