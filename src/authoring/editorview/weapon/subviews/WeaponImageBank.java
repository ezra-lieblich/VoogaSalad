package authoring.editorview.weapon.subviews;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import authoring.editorview.PhotoFileChooser;
import authoring.editorview.weapon.WeaponEditorViewDelegate;
import authoring.utilityfactories.ButtonFactory;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
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

    public WeaponImageBank () {
        weaponBank = new ScrollPane();
        Button createWeaponButton =
                ButtonFactory.makeButton("Create Weapon",
                             e -> selectFile("Photos: ", "Select new weapon image"));
        weaponBank.setContent(createWeaponButton);
    }

    private Button createButton (String label, EventHandler<ActionEvent> event) {
        Button button = new Button(label);
        button.setOnAction(event);
        return button;
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
    public void openFileChooser (FileChooser chooseFile) {
        chosenFile = chooseFile.showOpenDialog(new Stage());
        if (chosenFile != null) {
            // give this image an id, keep it in bank
            BufferedImage image;
            try {
                image = ImageIO.read(chosenFile);
                ImageIcon imageView = new ImageIcon(image);
                delegate.onUserPressedCreateWeapon();
                // int newWeaponID = dataSource.createWeapon
                // activeWeapons.put(newWeaponID, imageView);
            }
            catch (Exception e) {
                System.out.println("Unable to load photo");
                // TODO: Fix this output to be better for the user
            }
        }

    }
}
