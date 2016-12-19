package engine.observer;

/**
 * 
 * 
 * @author seanhudson
 *
 * @param <E> Object that extends Observable
 * @param <U> value that Observable will pass
 */
public interface Observer<E extends Observable<U>, U> {
    
    <R extends E> void update(R observable, U value);
}
