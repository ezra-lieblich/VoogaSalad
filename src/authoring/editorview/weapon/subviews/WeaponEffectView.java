package authoring.editorview.weapon.subviews;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class WeaponEffectView {

    private double fireRate;
    private String path;
    private String effect;
    private double speed;
    private double range;
    
    
    private VBox completeView;
    
    //TODO: Effect view will allow developer to define range, speed, collision effects, and rate of fire what about path?
    
    public VBox getCompleteView () {
        //TODO: This will go into the full weapon window
        return completeView;
    }

    public WeaponEffectView () {
        completeView = new VBox();
    }
    
    private void placeInVBox() {
        //TODO: Get the photo and id of the current weapon from the model and place first in this box
        completeView.getChildren().add(makeTextField("Set weapon speed: "));
        completeView.getChildren().add(makeTextField("Set fire rate: "));
    }
    
    private TextField makeTextField(String name) {
        TextField textField = new TextField();
        textField.setPromptText(name);
        return textField;
    }
    
    
    
}
