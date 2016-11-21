package engine.path;

import engine.AbstractType;
import engine.TypeInitializer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathType extends AbstractType implements Path {

    private String type;
    private List<GridCoordinate> coordinates;
    

    protected PathType (TypeInitializer typeBuilder) {
        super(typeBuilder);
        // TODO Auto-generated constructor stub
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
