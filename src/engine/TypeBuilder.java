package engine;

/**
 * This interface handles the methods for building a Type
 * 
 * @author seanhudson
 *
 * @param <E> Subclass of Type
 * @param <R> F-bounded interface of TypeBuilder
 */
public interface TypeBuilder<E extends Type, R extends TypeBuilder<E, R>> extends BindableType<R> {

    /**
     * Sets the nextId
     * Can only be set to a value greater than the current id
     * 
     * @param id
     * @return
     */
    boolean setNextId(int id);
    
    /**
     * Builds the name value
     * 
     * @param name
     * @return
     */
    R buildName (String name);

    /**
     * Builds the ImagePath value
     * 
     * @param imagePath
     * @return
     */
    R buildImagePath (String imagePath);

    /**
     * Builds the Size value
     * 
     * @param size
     * @return
     */
    R buildSize (double size);
    
    /**
     * Builds the Id value
     * 
     * @param id
     * @return
     */
    R buildId (int id);
    
    /**
     * Builds the SoundPath value
     * 
     * @param SoundPath
     * @return
     */
    R buildSound (String SoundPath);
    
    /**
     * Loads the values of a property into the builder
     * 
     * @param type
     * @return
     */
    R copy(E type);

    /**
     * Creates a new instance of the type
     * 
     * @return
     */
    E build ();

}
