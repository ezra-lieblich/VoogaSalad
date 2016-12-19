package engine;

/**
 * This interface handles the methods for extracting data
 * 
 * @author seanhudson
 *
 * @param <E> Property Type
 */
public interface MethodData<E> {
    String getMethod();
    E getValue();
}
