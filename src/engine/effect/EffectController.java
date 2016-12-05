package engine.effect;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;

public class EffectController {
    Group root;
    Scene scene;
    
    EffectController(int size) {
        this.root = new Group();
        this.scene = new Scene(root, size, size);
        root.getChildren().add(new Rectangle());
        EffectView view = new EffectView();
        root.getChildren().add(view.getNode());
    }
    
    public Scene getScene() {
        return scene;
    }
}
