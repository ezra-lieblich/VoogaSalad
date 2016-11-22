package engine;

import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class AbstractType implements Type {
    private String name;
    private String imagePath;
    private double size;
    private final int id;
    
    protected AbstractType(TypeInitializer typeBuilder) {
        this.name = typeBuilder.getName();
        this.imagePath = typeBuilder.getImagePath();
        this.size = typeBuilder.getSize();    
        this.id = typeBuilder.getNextId();
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

    @Override
    public int getId () {
        return id;
    }

    //TODO - consider using removef
    /*protected <E> List<E> filterList(List<E> list, Predicate<E> condition) {
        return list.stream().filter(condition).collect(Collectors.toList());
    }*/
}
