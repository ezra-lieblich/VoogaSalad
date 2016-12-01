package engine.observer;

import java.util.List;

public class ObservableListProperty<E> extends ObservableObjectProperty<List<E>> implements ObservableList<E> {

    public ObservableListProperty(List<E> value) {
        super(value);
    }
    
    @Override
    public void add(E value) {
        getProperty().add(value);
        notifyObservers(getProperty());
    }

    @Override
    public void remove(E value) {
        getProperty().removeIf(a -> a.equals(value));
        notifyObservers(getProperty());
    }
    
}
