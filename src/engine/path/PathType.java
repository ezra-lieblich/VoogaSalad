package engine.path;

import engine.AbstractType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathType extends AbstractType implements Path {
    private String type;
    private List<GridCoordinate> coordinates;
    
    PathType() {
        this.coordinates = new ArrayList<GridCoordinate>();
    }

    @Override
    public String getType () {
        return type;
    }

    @Override
    public void setType (String type) {
        this.type = type;
    }

    @Override
    public void addCoordinate(GridCoordinate coordinate) {
        coordinates.add(coordinate);
    }
    
    @Override
    public void removeCoordinate(GridCoordinate coordinate) {
        coordinates.remove(coordinate);
    }
    
    @Override
    public List<GridCoordinate> getCoordinates () {
        return Collections.unmodifiableList(coordinates);
    }
    
}
