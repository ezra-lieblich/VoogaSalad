package engine.effect;

import javafx.beans.property.SimpleListProperty;
import javafx.scene.Group;
import javafx.scene.control.ComboBox;

public class EffectView {

    Group node;
    ComboBox<String> triggers = new ComboBox<String>();
    
    EffectView() {
        this.node = new Group();
        this.triggers = new ComboBox<String>(new SimpleListProperty<String>());
        node.getChildren().add(triggers);
//        triggers.setLayoutX(300);
//        triggers.setLayoutY(300);
    }
    
    Group getNode() {
        return node;
    }
}
