package engine;

public class Entity {
    private String name;
    private String imagePath;
    private double size;
    
    
    Entity() {
    }
    

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getImagePath () {
        return imagePath;
    }

    public void setImagePath (String imagePath) {
        this.imagePath = imagePath;
    }

    public double getSize () {
        return size;
    }


    public void setSize (double size) {
        this.size = size;
    }

}
