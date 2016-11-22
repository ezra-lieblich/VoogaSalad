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

    private String fireRate;
    private String imagePath;
    private String effect;
    private String speed;
    private String range;

    private VBox vboxView;
    private ScrollPane completeView;
    private WeaponEditorViewDelegate delegate;
    private TextField fireRateField;

    public WeaponEffectView () throws IOException {
        vboxView = new VBox(10);
        completeView = new ScrollPane();
        completeView.setContent(vboxView);
        fireRateField = makeTextField("Set weapon fire rate: ",
                                      e -> delegate.onUserEnteredWeaponFireRate(fireRate));
        placeInVBox();
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
                .add(makeTextField("Set weapon speed: ",
                                   e -> delegate.onUserEnteredProjectileSpeed(speed)));
        vboxView.getChildren()
                .add(fireRateField);
        vboxView.getChildren()
                .add(makeTextField("Set weapon range: ",
                                   e -> delegate.onUserEnteredWeaponRange(range)));
        javafx.collections.ObservableList<String> effectOptions =
                FXCollections.observableArrayList("IDK", "Sorry");
        vboxView.getChildren()
                .add(makeComboBox("Set weapon effect: ",
                                  e -> delegate.onUserEnteredWeaponEffect(effect),
                                  effectOptions));
    }

    public void updateFireRateDisplay (int fireRate) {
        fireRateField.setText(Integer.toString(fireRate));
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
