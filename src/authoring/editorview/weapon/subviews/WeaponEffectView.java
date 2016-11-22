package authoring.editorview.weapon.subviews;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ResourceBundle;
import javax.imageio.ImageIO;
import authoring.editorview.weapon.WeaponEditorViewDelegate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class WeaponEffectView {

    private String imagePath;
    private String effect;

    private VBox vboxView;
    private ScrollPane completeView;
    private WeaponEditorViewDelegate delegate;
    private TextField fireRateField;
    private TextField speedField;
    private TextField rangeField;
    private TextField nameField;
    private ComboBox<String> weaponEffectBox;
    private ResourceBundle labelsResource;

    private final String WEAPON_EFFECT_RESOURCE_PATH = "resources/GameAuthoringWeapon";

    public WeaponEffectView (WeaponEditorViewDelegate delegate) throws IOException {
        this.delegate = delegate;
        labelsResource = ResourceBundle.getBundle(WEAPON_EFFECT_RESOURCE_PATH);
        vboxView = new VBox(10);
        completeView = new ScrollPane();
        completeView.setContent(vboxView);

        buildViewComponents();
        placeInVBox();
    }

    private void buildViewComponents () throws IOException {
        makeTextFields();

        vboxView.getChildren().add(createHBox(labelsResource.getString("Rate"), fireRateField));
        vboxView.getChildren().add(createHBox(labelsResource.getString("Speed"), speedField));
        vboxView.getChildren().add(createHBox(labelsResource.getString("Range"), rangeField));
        vboxView.getChildren().add(createHBox(labelsResource.getString("Name"), nameField));
        ImageView myImageView = loadWeaponImage();
        vboxView.getChildren().add(myImageView);
    }

    private void makeTextFields () {
        rangeField = makeTextField("Enter integer value",
                                   e -> delegate.onUserEnteredWeaponRange(rangeField.getText()));
        System.out.println(delegate);
        speedField = makeTextField("Enter integer value",
                                   e -> delegate
                                           .onUserEnteredProjectileSpeed(speedField.getText()));
        fireRateField = makeTextField("Enter integer value",
                                      e -> delegate.onUserEnteredWeaponFireRate(fireRateField
                                              .getText()));
        nameField = makeTextField("Enter name",
                                  e -> delegate.onUserEntereredWeaponName(nameField.getText()));
    }

    private HBox createHBox (String labelString, TextField textField) {
        HBox box = new HBox(5);
        Label label = new Label(labelString);
        box.getChildren().addAll(label, textField);
        return box;
    }

    public ScrollPane getCompleteView () {
        return completeView;
    }

    private void placeInVBox () throws IOException {
        Button loadNewImageButton = new Button("Load new weapon image");
        // loadNewImageButton.setOnMouseClicked(e -> openFileChooser!!!!)
        vboxView.getChildren().add(loadNewImageButton);
        javafx.collections.ObservableList<String> effectOptions =
                FXCollections.observableArrayList("IDK", "Sorry");
        weaponEffectBox = makeComboBox("Set weapon effect: ",
                                       e -> delegate.onUserEnteredWeaponEffect(effect),
                                       effectOptions);
        vboxView.getChildren().add(weaponEffectBox);
    }

    private ImageView loadWeaponImage () throws IOException {
        BufferedImage imageRead;
        ImageView myImageView = new ImageView();
        try {
            imageRead = ImageIO.read(getClass().getClassLoader().getResourceAsStream(imagePath));
            Image image2 = SwingFXUtils.toFXImage(imageRead, null);
            myImageView.setImage(image2);
        }
        catch (Exception e) {
            imageRead =
                    ImageIO.read(getClass().getClassLoader()
                            .getResourceAsStream("questionmark.png"));
            Image image2 = SwingFXUtils.toFXImage(imageRead, null);
            myImageView.setImage(image2);
            System.out.println("Unable to find picture in files");
        }
        return myImageView;
    }

    private TextField makeTextField (String name, EventHandler<ActionEvent> event) {
        TextField textField = new TextField();
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

    /**
     * Update fields methods
     */

    public void updateFireRateDisplay (int fireRate) {
        fireRateField.setText(Integer.toString(fireRate));
    }

    public void updateSpeedDisplay (int speed) {
        speedField.setText(Integer.toString(speed));
    }

    public void updateRangeDisplay (int range) {
        rangeField.setText(Integer.toString(range));
    }

    public void updateWeaponEffectDisplay (String effect) {
        weaponEffectBox.setValue(effect);
    }

}
