package engine;

import java.util.ResourceBundle;

public abstract class AbstractType implements Type {
    private String name;
    private String imagePath;
    private double size;
    private final int id;

    private static final String DEFAULTVALUESPATH = "resources/DefaultEntityValues/";
    private static ResourceBundle resources = ResourceBundle.getBundle(DEFAULTVALUESPATH);
    
    protected AbstractType(int id) {
        this.id = id;
    }
    
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

    protected String getResources(String key) {
        return resources.getString(key);
    }

    @Override
    public int getId () {
        return id;
    }

}
