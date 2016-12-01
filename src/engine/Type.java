package engine;

public interface Type {

    String getName ();

    boolean setName (String name);

    String getImagePath ();

    void setImagePath (String imagePath);

    double getSize ();

    void setSize (double size);
    
    int getId ();

}
