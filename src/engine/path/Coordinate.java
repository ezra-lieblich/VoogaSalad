package engine.path;

/**
 * 
 * 
 * @author seanhudson
 *
 * @param <E>
 */
public interface Coordinate<E extends Number> {

    E getX ();

    E getY ();

    void setX (E x);

    void setY (E y);
}
