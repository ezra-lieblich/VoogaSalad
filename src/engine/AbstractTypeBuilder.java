package engine;

import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import engine.observer.ObservableObjectProperty;
import engine.observer.ObservableProperty;
import engine.tower.TowerBuilder;
import engine.weapon.Weapon;

public abstract class AbstractTypeBuilder<E extends Type, R extends TypeBuilder<E, R>> implements TypeBuilder<E, R>, TypeInitializer {
    
    private final String DEFAULT_NAME;
    private final String DEFAULT_IMAGE_PATH;
    private final Double DEFAULT_SIZE;
    
    
    private ObservableProperty<String> name;
    private ObservableProperty<String> imagePath;
    private ObservableProperty<Double> size;
    private int id;
    private int nextId;
    
    
    protected AbstractTypeBuilder(String name, String imagePath, double size) {
        this.DEFAULT_NAME = name;
        this.DEFAULT_IMAGE_PATH = imagePath;
        this.DEFAULT_SIZE = size;
        this.nextId = 0;
        restoreDefaults();
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
    public R buildId(int id) {
        this.id = id;
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
    public int getId() {
        return id;
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
    
    protected void resetName(ObservableProperty<String> name) {
        this.name = name;
    }
    
    protected void resetImagePath(ObservableProperty<String> imagePath) {
        this.imagePath = imagePath;
    }
    
    protected void resetSize(ObservableProperty<Double> size) {
        this.size = size;
    }
    
    private void restoreDefaults() {
        this.id = nextId;
        this.name = new ObservableObjectProperty<String>(DEFAULT_NAME + " (" + id + ")");
        this.imagePath = new ObservableObjectProperty<String>(DEFAULT_IMAGE_PATH);
        this.size = new ObservableObjectProperty<Double>(DEFAULT_SIZE);
        restoreTypeDefaults();
    }
    
    protected abstract E create ();
    
    protected abstract void restoreTypeDefaults();
    
    protected abstract R getThis();

    
}
