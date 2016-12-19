// This entire file is part of my masterpiece.
// Sean Hudson
package engine;

import java.util.function.BiConsumer;
import engine.observer.ObservableObjectProperty;
import engine.observer.ObservableProperty;

/**
 * I included this class in my masterpiece because it provides a strong synergy of many of the design patterns and principles that we learned
 * this year. This is a very powerful, extendible and closed abstract class that allows for a wide range of customization through sub-classing.
 * 
 * Builder Pattern - This class provides a good usage of the Builder creational design pattern. The Types that these builders create are fairly complex objects
 * that take in many different components. Using the builder pattern allows for elegant one line instantiations and gives the client, who is using the 
 * builder, more control over the creation process. Clients (which in are case are the controllers) can easily chain together builder calls to quickly
 * create an object. The copyType() method provides a good example of this chaining.
 * 
 * Template Method Pattern - The use of the template method pattern is what makes this feature so powerful. By abstracting all of the common builder behavior
 * into this class, the subclasses only deal with subclass specific functionality that is well templated to ensure that it works with the Abstract class
 * as well as the rest of the program. Whenever a new TypeBuilder is needed, the programmer just needs to extend this class and implement the trivial
 * abstract methods. The Abstract class then handles all of the more complex interactions with the client. For instance The build() method ensures that
 * the object is always created in the right way. Once the object is built it restores the default methods which calls a template method for the subclass
 * to override that restores subclass specific default values.
 * 
 * Observer Pattern/functional programming - I made all the property Observable since I wanted Observers to have control at the property granularity over their observables
 * as opposed to making the whole class observable and having one generic update method for all of the properties. Furthermore these observable properties allow me to
 * do all of the Type binding during object creation and do a "one-time-set" where I then pass them in through the Type's constructor. This way I can encapsulate/hide the
 * fact that I used my own observable properties from other people who might want to use the Type classes (e.g. People working on the Engine).
 * 
 * Interfaces - This class provides a great use of interfaces. In order to return the builder's subclass on an abstract builder call (e.g. buildName()) I made
 * use of F-bounded interfaces. The subclasses pass up their own interface into the Abstract class, which allows the Abstract class to take on more functionality
 * that the subclasses would otherwise have to implement themselves. These interfaces also provide a great example of data encapsulation, that allow the same class
 * to act as both a builder and an initializer in different situations. The clients interact with the builder through the TypeBuilder interface that contains all of the builder methods; They can only
 * build and not retrieve any of the data. When they finally call build() the builder creates the new Type and passes itself into the constructor as a TypeInitializer instead of
 * a TypeBuilder. This interface only has getter methods that allow the Type classes to retrieve the Observable properties and do a one time set.
 * 
 * 
 * This class provides a flexible and extensible way of handling Type creation
 * that allows the client to instruct the creation process.
 * 
 * @author seanhudson
 *
 * @param <E> Type subclass
 * @param <R> F-Bounded TypeBuilder Interface
 */
public abstract class AbstractTypeBuilder<E extends Type, R extends TypeBuilder<E, R>>
        implements TypeBuilder<E, R>, TypeInitializer {

    private static final String DEFAULT_NAME_FORMAT = "%s (%s)";

    private final String DEFAULT_NAME;
    private final String DEFAULT_IMAGE_PATH;
    private final Double DEFAULT_SIZE;
    private final String DEFAULT_SOUND;

    private ObservableProperty<String> name;
    private ObservableProperty<String> imagePath;
    private ObservableProperty<Double> size;
    private ObservableProperty<String> sound;
    private int id;
    private int nextId;

    protected AbstractTypeBuilder (String name, String imagePath, double size, String sound) {
        this.DEFAULT_NAME = name;
        this.DEFAULT_IMAGE_PATH = imagePath;
        this.DEFAULT_SIZE = size;
        this.DEFAULT_SOUND = sound;
        this.nextId = 0;
        restoreDefaults();
    }

    @Override
    public R buildName (String name) {
        this.name.setProperty(name);
        return getThis();
    }

    @Override
    public R buildImagePath (String imagePath) {
        this.imagePath.setProperty(imagePath);
        return getThis();
    }

    @Override
    public R buildSize (double size) {
        this.size.setProperty(size);
        return getThis();
    }

    @Override
    public R buildSound (String soundPath) {
        this.sound.setProperty(soundPath);
        return getThis();
    }

    @Override
    public R buildId (int id) {
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
    public ObservableProperty<String> getSound () {
        return sound;
    }

    @Override
    public int getId () {
        return id;
    }

    @Override
    public boolean setNextId (int id) {
        boolean isValidIdAssignment = id > nextId;
        if (isValidIdAssignment) {
            nextId = id;
        }
        return isValidIdAssignment;
    }

    @Override
    public R addNameListener (BiConsumer<String, String> listener) {
        name.addListener(listener);
        return getThis();
    }

    @Override
    public R addImagePathListener (BiConsumer<String, String> listener) {
        imagePath.addListener(listener);
        return getThis();
    }

    @Override
    public R addSizeListener (BiConsumer<Double, Double> listener) {
        size.addListener(listener);
        return getThis();
    }

    @Override
    public R addSoundListener (BiConsumer<String, String> listener) {
        sound.addListener(listener);
        return getThis();
    }

    @Override
    public R copy (E type) {
        return copyType(type)
                .buildId(type.getId())
                .buildName(type.getName())
                .buildImagePath(type.getImagePath())
                .buildSize(type.getSize())
                .buildSound(type.getSound());
    }

    protected void resetName (ObservableProperty<String> name) {
        this.name = name;
    }

    protected void resetImagePath (ObservableProperty<String> imagePath) {
        this.imagePath = imagePath;
    }

    protected void resetSize (ObservableProperty<Double> size) {
        this.size = size;
    }

    private void restoreDefaults () {
        this.id = nextId;
        this.name = new ObservableObjectProperty<String>(String.format(DEFAULT_NAME_FORMAT, DEFAULT_NAME, id));
        this.imagePath = new ObservableObjectProperty<String>(DEFAULT_IMAGE_PATH);
        this.size = new ObservableObjectProperty<Double>(DEFAULT_SIZE);
        this.sound = new ObservableObjectProperty<String>(DEFAULT_SOUND);
        restoreTypeDefaults();
    }

    protected abstract E create ();

    protected abstract void restoreTypeDefaults ();

    protected abstract R copyType (E type);

    protected abstract R getThis ();

}
