package engine;

import java.util.Arrays;
import java.util.function.Consumer;

public abstract class AbstractTypeBuilder<E extends Type> implements TypeBuilder<E>, TypeInitializer {
    
    private String name;
    private String imagePath;
    private int size;
    private int nextId;
    
    
    protected AbstractTypeBuilder(String name, String imagePath, int size) {
        this.name = name;
        this.imagePath = imagePath;
        this.size = size;
        this.nextId = 0;
    }
    
    @Override
    public void buildName(String name) {
        this.name = name;
    }
    
    @Override
    public void buildImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    
    @Override
    public void buildSize(int size) {
        this.size = size;
    }
    
    @Override
    public E build () {
        E newEntity = create();
        nextId++;
        return newEntity;
    }
    
    @Override
    public String getName () {
        return name;
    }

    @Override
    public String getImagePath () {
        return imagePath;
    }

    @Override
    public int getSize () {
        return size;
    }
    
    @Override
    public int getNextId() {
        return nextId;
    }
    
    public abstract E create ();

    
}