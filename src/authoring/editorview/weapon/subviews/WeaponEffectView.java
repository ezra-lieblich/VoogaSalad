package authoring.editorview.weapon.subviews;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;
import javax.imageio.ImageIO;
import authoring.editorview.PhotoFileChooser;
import authoring.editorview.weapon.WeaponEditorViewDelegate;
import authoring.utilityfactories.BoxFactory;
import authoring.utilityfactories.ButtonFactory;
import authoring.utilityfactories.ComboBoxFactory;
import authoring.utilityfactories.TextFieldFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class WeaponEffectView extends PhotoFileChooser {

    private String imagePath;

    private VBox vboxView;
    private ScrollPane completeView;
    private WeaponEditorViewDelegate delegate;
    private TextField fireRateField;
    private TextField speedField;
    private TextField rangeField;
    private TextField nameField;
    private TextField damageField;
    private ComboBox<Object> weaponEffectBox;
    private ComboBox<Object> weaponPathBox;
    private ResourceBundle labelsResource;
    private File chosenFile;

    private final String WEAPON_EFFECT_RESOURCE_PATH = "resources/GameAuthoringWeapon";

    public WeaponEffectView () throws IOException {
        labelsResource = ResourceBundle.getBundle(WEAPON_EFFECT_RESOURCE_PATH);
        vboxView = new VBox(10);
        completeView = new ScrollPane();
        completeView.setContent(vboxView);

        buildViewComponents();
        placeInVBox();
    }

    public void setDelegate (WeaponEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    private void buildViewComponents () throws IOException {
        makeTextFields();

        ImageView myImageView = loadWeaponImage();
        vboxView.getChildren().add(myImageView);
        vboxView.getChildren().add(ButtonFactory.makeButton(labelsResource.getString("Image"),
                                                            e -> {
                                                                try {
                                                                    selectFile("text", "text");
                                                                }
                                                                catch (IOException e1) {
                                                                    // TODO Auto-generated catch
                                                                    // block
                                                                    e1.printStackTrace();
                                                                }
                                                            }));
        vboxView.getChildren()
                .add(BoxFactory.createHBoxWithTextField(labelsResource.getString("Name"),
                                                        nameField));
        vboxView.getChildren()
                .add(BoxFactory.createHBoxWithTextField(labelsResource.getString("Rate"),
                                                        fireRateField));
        vboxView.getChildren()
                .add(BoxFactory.createHBoxWithTextField(labelsResource.getString("Speed"),
                                                        speedField));
        vboxView.getChildren()
                .add(BoxFactory.createHBoxWithTextField(labelsResource.getString("Range"),
                                                        rangeField));
        vboxView.getChildren()
                .add(BoxFactory.createHBoxWithTextField(labelsResource.getString("Damage"),
                                                        damageField));
    }

    private void makeTextFields () {
        rangeField = TextFieldFactory.makeTextField(labelsResource.getString("EnterInt"),
                                                    e -> delegate
                                                            .onUserEnteredWeaponRange(rangeField
                                                                    .getText()));
        speedField = TextFieldFactory.makeTextField(labelsResource.getString("EnterInt"),
                                                    e -> delegate
                                                            .onUserEnteredProjectileSpeed(speedField
                                                                    .getText()));
        fireRateField = TextFieldFactory.makeTextField(labelsResource.getString("EnterInt"),
                                                       e -> delegate
                                                               .onUserEnteredWeaponFireRate(fireRateField
                                                                       .getText()));
        nameField = TextFieldFactory.makeTextField(labelsResource.getString("EnterString"),
                                                   e -> delegate.onUserEnteredWeaponName(nameField
                                                           .getText()));
        damageField = TextFieldFactory.makeTextField(labelsResource.getString("EnterInt"),
                                                     e -> delegate
                                                             .onUserEnteredWeaponDamage(damageField
                                                                     .getText()));
    }

    public ScrollPane getInstanceAsNode () {
        return completeView;
    }

    private void placeInVBox () throws IOException {
        // TODO: check cast for the string
        ObservableList<Object> effectOptions =
                FXCollections.observableArrayList("IDK", "Sorry");
        weaponEffectBox = ComboBoxFactory.makeComboBox(labelsResource.getString("Effect"),
                                                       e -> delegate
                                                               .onUserEnteredWeaponEffect((String) weaponEffectBox
                                                                       .getValue()),
                                                       effectOptions);
        vboxView.getChildren().add(weaponEffectBox);
        ObservableList<Object> pathOptions =
                FXCollections.observableArrayList("I still don't know", "Sorry");
        weaponPathBox =
                ComboBoxFactory.makeComboBox(labelsResource.getString("Path"),
                                             e -> delegate
                                                     .onUserEnteredWeaponPath((String) weaponPathBox
                                                             .getValue()),
                                             pathOptions);
        vboxView.getChildren().add(weaponPathBox);
    }

    private ImageView loadWeaponImage () throws IOException {
        BufferedImage imageRead;
        ImageView myImageView = new ImageView();
        try {
            imageRead = ImageIO.read(getClass().getClassLoader().getResourceAsStream(imagePath));
            Image image2 = SwingFXUtils.toFXImage(imageRead, null);
            myImageView.setImage(image2);
            delegate.onUserEnteredWeaponImage(imagePath);
        }
        catch (Exception e) {
            imageRead =
                    ImageIO.read(getClass().getClassLoader()
                            .getResourceAsStream(labelsResource.getString("DefaultImagePath")));
            Image image2 = SwingFXUtils.toFXImage(imageRead, null);
            myImageView.setImage(image2);
            System.out.println("Unable to find picture in files");
        }
        return myImageView;
    }

    /**
     * Update fields methods
     */

    public void updateFireRateDisplay (int fireRate) {
        // TODO: Watch for integer to string and error check in controller
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

    public void updateWeaponImagePath (String imagePath) {
        this.imagePath = imagePath;
    }

    public void updateWeaponName (String name) {
        nameField.setText(name);
    }

    public void updateWeaponDamage (int damage) {
        damageField.setText(Integer.toString(damage));
    }

    public void createNewWeapon () {
        // Call all of the other update methods to get the default values
    }

    public void updateWeaponPath (String path) {
        weaponPathBox.setValue(path);
    }

    @Override
    public void openFileChooser (FileChooser chooseFile) {
        chosenFile = chooseFile.showOpenDialog(new Stage());
        // if not null -> get imageFilePath and update the instance variable
        // then loadImage through the created method above
    }

}
