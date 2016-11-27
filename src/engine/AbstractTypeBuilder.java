package engine;

import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import engine.observer.ObservableObjectProperty;
import engine.observer.ObservableProperty;
import engine.tower.TowerBuilder;
import engine.weapon.Weapon;

public abstract class AbstractTypeBuilder<E extends Type, R extends TypeBuilder<E, R>> implements TypeBuilder<E, R>, TypeInitializer {
    
    private ObservableProperty<String> name;
    private ObservableProperty<String> imagePath;
    private ObservableProperty<Double> size;
    private int nextId;
    
    
    protected AbstractTypeBuilder(String name, String imagePath, double size) {
        this.name = new ObservableObjectProperty<String>(name);
        this.imagePath = new ObservableObjectProperty<String>(imagePath);
        this.size = new ObservableObjectProperty<Double>(size);
        this.nextId = 0;
    }
    
    @Override
    public R buildName (String name) {
        this.name.setProperty(name);
        return getThis();
    }
    
    @Override
    public R buildImagePath(String imagePath) {
        this.imagePath.setProperty(imagePath);
        return getThis();
    }
    
    @Override
    public R buildSize(double size) {
        this.size.setProperty(size);
        return getThis();
    }
    
    @Override
    public E build () {
        E newEntity = create();
        nextId++;
        restoreDefaults();
        return newEntity;
    }
    
    @Override
    public ObservableProperty<String> getName () {
        return name;
    }

    @Override
    public ObservableProperty<String> getImagePath () {
        return imagePath;
    }

    @Override
    public ObservableProperty<Double> getSize () {
        return size;
    }
    
    @Override
    public int getNextId() {
        return nextId;
    }
    
    @Override
    public R addNameListener(BiConsumer<String, String> listener) {
        name.addListener(listener);
        return getThis();
    }
    
    @Override
    public R addImagePathListener(BiConsumer<String, String> listener) {
        imagePath.addListener(listener);
        return getThis();
    }
    
    @Override
    public R addSizeListener(BiConsumer<Double, Double> listener) {
        size.addListener(listener);
        return getThis();
    }
    
    protected void setName(ObservableProperty<String> name) {
        this.name = name;
    }
    
    protected void setImagePath(ObservableProperty<String> imagePath) {
        this.imagePath = imagePath;
    }
    
    protected void setSize(ObservableProperty<Double> size) {
        this.size = size;
    }
    
    protected abstract E create ();
    
    protected abstract void restoreDefaults();
    
    protected abstract R getThis();

    
}
