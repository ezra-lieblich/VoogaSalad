package authoring.editorview.weapon.subviews;

import authoring.editorview.weapon.WeaponEditorViewDelegate;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
    private WeaponEditorViewDelegate delegate;

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
        vboxView.getChildren()
                .add(makeTextField("Set weapon speed: ", e -> delegate.setWeaponSpeed(speed)));
        vboxView.getChildren()
                .add(makeTextField("Set fire rate: ", e -> delegate.setWeaponFireRate(fireRate)));
    }

    private TextField makeTextField (String name, EventHandler<ActionEvent> event) {
        TextField textField = new TextField();
        textField.setPromptText(name);
        textField.setOnAction(event);
        return textField;
    }

}
