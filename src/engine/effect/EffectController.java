package engine.effect;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Rectangle;

public class EffectController {
    EffectManagerController modelController;
    EffectViewController viewController;
    
    EffectController(int size) {
        this.modelController = new EffectManagerController();
        this.viewController = new EffectViewController(size, modelController);
    }
    
    public Scene getScene() {
        return viewController.getScene();
    }
    
}
