package engine.path;

public class GridCoordinate implements Coordinate<Integer>{
    private int x;
    private int y;
    
    GridCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    GridCoordinate() {
        this(0, 0);
    }

    public Integer getX () {
        return x;
    }

    public void setX (Integer x) {
        this.x = x;
    }

    public Integer getY () {
        return y;
    }

    public void setY (Integer y) {
        this.y = y;
    }
    
    
}
