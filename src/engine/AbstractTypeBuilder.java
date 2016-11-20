package engine;

import java.util.Arrays;
import java.util.function.Consumer;

public abstract class AbstractTypeBuilder<E extends Type> implements AbstractBuilder<E> {
    private E entity;
    
    protected AbstractTypeBuilder() {
        this.entity = setNextEntityToBuild();
    }
    
    @Override
    public void buildName(String name) {
        entity.setName(name);
    }
    
    @Override
    public void buildImagePath(String imagePath) {
        entity.setImagePath(imagePath);
    }
    
    @Override
    public void buildSize(int size) {
        entity.setSize(size);
    }
    
    @Override
    public E build () {
        E createdEntity = entity;
        entity = setNextEntityToBuild();
        return createdEntity;
    }
    
    protected E getEntity() {
        return entity;
    }
    
    protected abstract E setNextEntityToBuild();
    
    @SuppressWarnings("unchecked") //TODO - Is this bad?
    protected <U> void addList(Consumer<U> setter, U... newItems) {
        Arrays.asList(newItems).stream().forEach(setter);
    }
    
}
