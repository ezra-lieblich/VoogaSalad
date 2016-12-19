package engine;

/**
 * This class is used for storing a method's name and associated value for use in the observer/mediator pattern
 * 
 * @author seanhudson
 *
 * @param <E> Property Type
 */
public class MethodObjectData<E> implements MethodData<E>{

    private String method;
    private E value;
    
    public MethodObjectData(String method, E value) {
        this.method = method;
        this.value = value;
    }

    public String getMethod () {
        return method;
    }

    public E getValue () {
        return value;
    }
    
}
