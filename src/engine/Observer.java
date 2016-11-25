package engine;

public interface Observer<E extends Observable<U>, U> {
    void update(E observable, U value);
}
