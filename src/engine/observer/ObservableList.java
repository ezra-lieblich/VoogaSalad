package engine.observer;

import java.util.List;

/**
 * 
 * 
 * @author seanhudson
 *
 * @param <E>
 */
public interface ObservableList<E> extends ObservableProperty<List<E>> {

    void add (E value);

    void remove (E value);

    void clear();
}
