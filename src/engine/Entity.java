package engine;

public class Entity implements IEntity {
    private String name;
    private String imagePath;
    private double size;
    


    @Override
    public String getName () {
        return name;
    }


    @Override
    public void setName (String name) {
        this.name = name;
    }


    @Override
    public String getImagePath () {
        return imagePath;
    }


    @Override
    public void setImagePath (String imagePath) {
        this.imagePath = imagePath;
    }


    @Override
    public double getSize () {
        return size;
    }


    @Override
    public void setSize (double size) {
        this.size = size;
    }

}
