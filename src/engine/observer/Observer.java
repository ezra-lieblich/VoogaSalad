package engine.observer;

public interface Observer<E extends Observable<U>, U> {
    void update(E observable, U value);
}
