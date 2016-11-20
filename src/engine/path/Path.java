package engine.path;

import java.util.List;
import engine.Type;


public interface Path extends Type {

    String getType ();

    void setType (String type);

    void addCoordinate (GridCoordinate coordinate);

    void removeCoordinate (GridCoordinate coordinate);

    List<GridCoordinate> getCoordinates ();

}
