package engine.path;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import engine.AbstractTypeBuilder;
import engine.ability.Ability;
import engine.enemy.Enemy;
import engine.observer.ObservableObjectProperty;
import engine.observer.ObservableProperty;
import engine.tower.Tower;
import engine.tower.TowerType;
import engine.weapon.Weapon;

public class PathTypeBuilder extends AbstractTypeBuilder<Path, PathBuilder> implements PathBuilder, PathInitializer {
    
     public static final String DEFAULT_NAME = "New Weapon";
     public static final String DEFAULT_IMAGE_PATH = "Images.penguin.jpg";
     public static final double DEFAULT_SIZE = 1;
     public static final String DEFAULT_TYPE = "direct";
     public static final List<Coordinate<Integer>> DEFAULT_COORDINATES = Arrays.asList(new GridCoordinate[]{});
     
     
     private ObservableProperty<String> type;
     private ObservableProperty<List<Coordinate<Integer>>> coordinates;
     
     public PathTypeBuilder() {
         super(DEFAULT_NAME, DEFAULT_IMAGE_PATH, DEFAULT_SIZE);
     }
    
    @Override
    public PathBuilder buildType(String type) {
        this.type.setProperty(type);
        return this;
    }
    
    @Override
    public PathBuilder buildCoordinates(List<Coordinate<Integer>> coordinates) {
        this.coordinates.setProperty(coordinates);
        return this;
    }
    
    @Override
    protected Path create () {
        return new PathType(this);
    }

    @Override
    public ObservableProperty<String> getType () {
        return type;
    }

    @Override
    public ObservableProperty<List<Coordinate<Integer>>> getCoordinates () {
        return coordinates;
    }

    @Override
    protected void restoreTypeDefaults () {
        this.type = new ObservableObjectProperty<String>(DEFAULT_TYPE);
        this.coordinates = new ObservableObjectProperty<List<Coordinate<Integer>>>(DEFAULT_COORDINATES);
    }

    @Override
    protected PathBuilder getThis () {
        return this;
    }
    
    @Override
    public PathBuilder addTypeListener(BiConsumer<String, String> listener) {
        type.addListener(listener);
        return this;
    }
    
    @Override
    public PathBuilder addCoordinatesListener(BiConsumer<List<Coordinate<Integer>>, List<Coordinate<Integer>>> listener) {
        coordinates.addListener(listener);
        return this;
    }
    
}
