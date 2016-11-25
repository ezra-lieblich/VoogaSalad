package engine.observer;

public interface Observer<E extends Observable<U>, U> {
    
    <R extends E> void update(R observable, U value);
}
