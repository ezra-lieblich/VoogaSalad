package engine.effect;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;

public class EffectViewController {
    EffectView view;
    EffectManagerController effectDataSource;
    
    EffectViewController(int size, EffectManagerController effectDataSouce) {
        this.view = new EffectView(size);
        this.effectDataSource = effectDataSouce;
        view.updateTriggers(effectDataSource.getTriggers());
        linkTrigger();
    }
    
    public void linkTrigger() {
        view.getTriggers().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int index = effectDataSource.setTrigger(view, view.getTriggers().getSelectionModel().getSelectedItem());
                view.getTriggerConditions().getItems().setAll(effectDataSource.)
            }
        });
    }
    
    public Scene getScene() {
        return view.getScene();
    }
}
