package authoring.editorview.weapon.subviews;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import authoring.editorview.weapon.WeaponEditorViewDelegate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;


public class WeaponEffectView {

    private double fireRate;
    private String imagePath;
    private String effect;
    private double speed;
    private int range;

    private VBox vboxView;
    private ScrollPane completeView;
    private WeaponEditorViewDelegate delegate;

    public WeaponEffectView () throws IOException {
        vboxView = new VBox(10);
        completeView = new ScrollPane();
        placeInVBox();
        completeView.setContent(vboxView);
    }

    public void update () {

    }

    public ScrollPane getCompleteView () {
        return completeView;
    }

    private void placeInVBox () throws IOException {
        // TODO: Get the photo and id of the current weapon from the model and place first in this
        // box
        BufferedImage image;
        ImageView myImageView = new ImageView();
        try {
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream(imagePath));
            Image image2 = SwingFXUtils.toFXImage(image, null);
            myImageView.setImage(image2);
        }
        catch (Exception e) {
            image =
                    ImageIO.read(getClass().getClassLoader()
                            .getResourceAsStream("questionmark.png"));
            Image image2 = SwingFXUtils.toFXImage(image, null);
            myImageView.setImage(image2);
            System.out.println("Unable to find picture in files");
        }
        vboxView.getChildren().add(myImageView);
        vboxView.getChildren()
                .add(makeTextField("Set weapon speed: ", e -> delegate.setWeaponSpeed(speed)));
        vboxView.getChildren()
                .add(makeTextField("Set weapon fire rate: ",
                                   e -> delegate.setWeaponFireRate(fireRate)));
        vboxView.getChildren()
                .add(makeTextField("Set weapon range: ", e -> delegate.setWeaponRange(range)));
        javafx.collections.ObservableList<String> effectOptions =
                FXCollections.observableArrayList("IDK", "Sorry");
        vboxView.getChildren()
                .add(makeComboBox("Set weapon effect: ", e -> delegate.setWeaponEffect(effect),
                                  effectOptions));
    }

    private TextField makeTextField (String name, EventHandler<ActionEvent> event) {
        TextField textField = new TextField();
        // textField.text This is the location of the label :)
        textField.setPromptText(name);
        textField.setOnAction(event);
        return textField;
    }

    private ComboBox<String> makeComboBox (String name,
                                           EventHandler<ActionEvent> event,
                                           ObservableList<String> options) {
        ComboBox<String> combobox = new ComboBox<String>(options);
        combobox.setOnAction(event);
        combobox.setPromptText(name);
        return combobox;
    }

}
