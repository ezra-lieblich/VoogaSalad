package engine.path;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathType {
    private String type;
    private List<PathCoordinate> coordinates;
    
    PathType() {
        this.coordinates = new ArrayList<PathCoordinate>();
    }

    public String getType () {
        return type;
    }

    public void setType (String type) {
        this.type = type;
    }

    public void addCoordinate(PathCoordinate coordinate) {
        coordinates.add(coordinate);
    }
    
    public void removeCoordinate(PathCoordinate coordinate) {
        coordinates.remove(coordinate);
    }
    
    public List<PathCoordinate> getCoordinates () {
        return Collections.unmodifiableList(coordinates);
    }
    
}
