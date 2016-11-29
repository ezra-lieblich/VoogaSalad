package engine.path;

import engine.AbstractType;
import engine.TypeInitializer;
import engine.observer.ObservableList;
import engine.observer.ObservableProperty;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathType extends AbstractType implements Path {

    private ObservableProperty<String> type;
    private ObservableList<Coordinate<Integer>> coordinates; 
    private ObservableProperty<Integer> gridRows;
    private ObservableProperty<Integer> gridColumns;

    protected PathType (PathInitializer pathInitializer) {
        super(pathInitializer);
        this.type = pathInitializer.getType();
        this.coordinates = pathInitializer.getCoordinates();
    }
    
    @Override
    public String getType () {
        return type.getProperty();
    }

    @Override
    public void setType (String type) {
        this.type.setProperty(type);
    }
    
    @Override
    public List<Coordinate<Integer>> getCoordinates () {
        return Collections.unmodifiableList(coordinates.getProperty());
    }

    @Override
    public int getGridRows () {
        return gridRows.getProperty();
    }

    @Override
    public void setGridRows (int gridRows) {
        this.gridRows.setProperty(gridRows);
    }

    @Override
    public int getGridColumns () {
        return gridColumns.getProperty();
    }

    @Override
    public void setGridColumns (int gridColumns) {
        this.gridRows.setProperty(gridColumns);        
    }

  @Override
  public void addCoordinate(Coordinate<Integer> coordinate) {
      coordinates.add(coordinate);
  }
  
  @Override
  public void removeCoordinate(Coordinate<Integer> coordinate) {
      coordinates.remove(coordinate);
  }
  
//@Override
//public void setCoordinates (List<Coordinate<Integer>> coordinates) {
//    this.coordinates.setProperty(coordinates);
//}

    
}
