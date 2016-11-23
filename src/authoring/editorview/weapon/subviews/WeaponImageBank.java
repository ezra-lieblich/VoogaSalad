package authoring.editorview.weapon.subviews;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import authoring.editorview.PhotoFileChooser;
import authoring.editorview.weapon.WeaponEditorViewDelegate;
import authoring.utilityfactories.BoxFactory;
import authoring.utilityfactories.ButtonFactory;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


/**
 * 
 * @author Kayla Schulz
 *
 */
// TODO: This needs to implement IImageBank once I figure out how to get parameter correct
public class WeaponImageBank extends PhotoFileChooser {

    // TODO: I want to be able to load in a default weapon with default settings from model
    // What is our current plan with defaults?

    private File chosenFile;
    private ScrollPane weaponBank;
    private WeaponEditorViewDelegate delegate;
    private VBox vbox;

    public WeaponImageBank () {
        weaponBank = new ScrollPane();
        Button createWeaponButton =
                ButtonFactory.makeButton("Create Weapon",
                                         e -> {
                                             try {
                                                 selectFile("Photos: ", "Select new weapon image");
                                             }
                                             catch (IOException e1) {
                                                 // TODO Auto-generated catch block
                                                 e1.printStackTrace();
                                             }
                                         });
        vbox = BoxFactory.createVBox("Weapon Bank: ");
        vbox.getChildren().add(createWeaponButton);
        weaponBank.setContent(vbox);
    }

    public Node getInstanceAsNode () {
        return weaponBank;
    }

    public void setDelegate (WeaponEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    public void updateWeaponBank (List<Integer> activeWeapons) {
        // update each weapon in bank
    }

    @Override
    public void openFileChooser (FileChooser chooseFile) throws IOException {
        chosenFile = chooseFile.showOpenDialog(new Stage());
        if (chosenFile != null) {
            // give this image an id, keep it in bank
            BufferedImage imageRead;
            ImageView imageView = new ImageView();
            try {
                imageRead = ImageIO.read(chosenFile);
                Image image2 = SwingFXUtils.toFXImage(imageRead, null);
                imageView.setImage(image2);
                // weaponBank.setContent(imageView);
                // TODO: These should be correct but are erring out currently
                // delegate.onUserPressedCreateWeapon();
                // delegate.onUserEnteredWeaponImage(chosenFile.toURI().toString());
            }
            catch (Exception e) {
                System.out.println("You failed");
                imageRead =
                        ImageIO.read(getClass().getClassLoader()
                                .getResourceAsStream("butterfly.png"));
                Image image2 = SwingFXUtils.toFXImage(imageRead, null);
                imageView.setImage(image2);
                // TODO: Fix this output to be better for the user
            }
        }
    }

}
