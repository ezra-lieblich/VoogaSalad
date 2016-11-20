package engine.path;

public class PathCoordinate {
    private int x;
    private int y;
    
    PathCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    PathCoordinate() {
        this(0, 0);
    }

    public int getX () {
        return x;
    }

    public void setX (int x) {
        this.x = x;
    }

    public int getY () {
        return y;
    }

    public void setY (int y) {
        this.y = y;
    }
    
    
}
