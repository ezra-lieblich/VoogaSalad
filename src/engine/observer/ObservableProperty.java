package engine.observer;

public interface ObservableProperty<U> extends Observable<U> {

    U getProperty ();

    void setProperty (U property);
}
