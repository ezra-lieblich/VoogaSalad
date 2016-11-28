package engine;

import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import engine.observer.ObservableProperty;

public abstract class AbstractType implements Type {
    private ObservableProperty<String> name;
    private ObservableProperty<String> imagePath;
    private ObservableProperty<Double> size;
    private int id;
    
    protected AbstractType(TypeInitializer typeBuilder) {
        this.name = typeBuilder.getName();
        this.imagePath = typeBuilder.getImagePath();
        this.size = typeBuilder.getSize();    
        this.id = typeBuilder.getId();
    }
    
    @Override
    public String getName () {
        return name.getProperty();
    }

    @Override
    public void setName (String name) {
        this.name.setProperty(name);
    }

    @Override
    public String getImagePath () {
        return imagePath.getProperty();
    }


    @Override
    public void setImagePath (String imagePath) {
        this.imagePath.setProperty(imagePath);
    }

    @Override
    public double getSize () {
        return size.getProperty();
    }


    @Override
    public void setSize (double size) {
        this.size.setProperty(size);
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
