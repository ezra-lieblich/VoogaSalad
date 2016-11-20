package authoring.editorview.weapon.subviews;

import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class WeaponEffectView {

    private double fireRate;
    private String path;
    private String effect;
    private double speed;
    private double range;

    private VBox vboxView;
    private ScrollPane completeView;

    public WeaponEffectView () {
        vboxView = new VBox();
        completeView = new ScrollPane();
        placeInVBox();
        completeView.setContent(vboxView);
    }

    // TODO: Effect view will allow developer to define range, speed, collision effects, and rate of
    // fire what about path?

    public ScrollPane getCompleteView () {
        // TODO: This will go into the full weapon window
        return completeView;
    }

    private void placeInVBox () {
        // TODO: Get the photo and id of the current weapon from the model and place first in this
        // box
        vboxView.getChildren().add(makeTextField("Set weapon speed: "));
        vboxView.getChildren().add(makeTextField("Set fire rate: "));
    }

    private TextField makeTextField (String name) {
        TextField textField = new TextField();
        textField.setPromptText(name);
        textField.setOnAction(event -> sendToModel());
        return textField;
    }

    private Object sendToModel () {
        // TODO This is where we would send the input value to the model
        // TODO Check for number (integer, double, etc.)
        return null;
    }

}
