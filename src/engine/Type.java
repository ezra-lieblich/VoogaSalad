package engine;

/**
 * This interface handles the getters and setters for the Type classes
 * 
 * @author seanhudson
 *
 */
public interface Type {

    /**
     * Gets the name value
     * 
     * @return
     */
    String getName ();

    /**
     * sets the name value
     * 
     * @param name
     */
    void setName (String name);

    /**
     * gets the image path 
     * 
     * @return
     */
    String getImagePath ();

    /**
     * sets the image path
     * 
     * @param imagePath
     */
    void setImagePath (String imagePath);

    /**
     * gets the size
     * 
     * @return
     */
    double getSize ();

    /**
     * sets the size
     * 
     * @param size
     */
    void setSize (double size);
    
    /**
     * gets the id
     * 
     * @return
     */
    int getId ();
    
    /**
     * gets the sound
     * 
     * @return
     */
    String getSound();
    
    /**
     * sets the soundPath
     * 
     * @param soundPath
     */
    void setSound(String soundPath);

}
