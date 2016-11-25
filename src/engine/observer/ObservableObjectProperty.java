package engine.observer;

public class ObservableObjectProperty<U> extends AbstractObservable<U> implements ObservableProperty<U>{
    private U property;

    ObservableObjectProperty(U value) {
        this.property = value;
    }
    
    ObservableObjectProperty() {
        this(null);
    }
    
    public U getProperty () {
        return property;
    }

    public void setProperty (U property) {
        this.property = property;
    }
    
    
}
