package engine;

public interface TypeBuilder<E extends Type> {

    void buildName (String name);

    void buildImagePath (String imagePath);

    void buildSize (int size);

    E build ();

}
