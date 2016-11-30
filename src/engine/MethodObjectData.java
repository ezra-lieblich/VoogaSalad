package engine;

public class MethodObjectData<E> implements MethodData<E>{

    private String method;
    private E value;
    
    MethodObjectData(String method, E value) {
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
