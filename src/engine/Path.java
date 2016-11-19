package engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Path {
    private String type;
    private List<Coordinate> coordinates;
    
    Path() {
        this.coordinates = new ArrayList<Coordinate>();
    }

    public String getType () {
        return type;
    }

    public void setType (String type) {
        this.type = type;
    }

    public void addCoordinate(Coordinate coordinate) {
        coordinates.add(coordinate);
    }
    
    public void removeCoordinate(Coordinate coordinate) {
        coordinates.remove(coordinate);
    }
    
    public List<Coordinate> getCoordinates () {
        return Collections.unmodifiableList(coordinates);
    }
    
}
