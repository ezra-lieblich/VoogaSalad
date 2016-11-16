package engine;

public class Entity {
    private int id;
    private String name;
    private String imagePath;
    
    
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


    public int getId () {
        return id;
    }


    public void setId (int id) {
        this.id = id;
    }

}
