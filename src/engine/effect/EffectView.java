package engine.effect;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.shape.Rectangle;

public class EffectView {
    Group node;
    Scene scene;
    ComboBox<String> triggers = new ComboBox<String>();
    
    EffectView(int size) {
        this.node = new Group();
        this.scene = new Scene(node, size, size);
        this.triggers = new ComboBox<String>(FXCollections.observableArrayList(new ArrayList<String>()));
        node.getChildren().add(triggers);
    }
    
    public void updateTriggers(List<String> methods) {
        triggers.getItems().setAll(methods);
    }
    
    public Group getNode() {
        return node;
    }
    
    public Scene getScene() {
        return scene;
    }
}
