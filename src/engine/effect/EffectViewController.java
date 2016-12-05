package engine.effect;

import javafx.scene.Group;
import javafx.scene.Scene;

public class EffectViewController {
    EffectView view;
    EffectManagerController effectDataSource;
    
    EffectViewController(int size, EffectManagerController effectDataSouce) {
        this.view = new EffectView(size);
        this.effectDataSource = effectDataSouce;
        view.updateTriggers(effectDataSource.getTriggers());
    }
    
    public Scene getScene() {
        return view.getScene();
    }
}
