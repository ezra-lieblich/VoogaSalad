package engine;

public interface AbstractBuilder<E extends Type> {

    void buildName (String name);

    void buildImagePath (String imagePath);

    void buildSize (int size);

    E build ();

}
