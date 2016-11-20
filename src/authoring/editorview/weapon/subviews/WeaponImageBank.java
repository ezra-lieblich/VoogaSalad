package authoring.editorview.weapon.subviews;

import java.io.File;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class WeaponImageBank {

    private Button createWeaponButton;
    private File chosenFile;
    private ScrollPane weaponBank;

    public WeaponImageBank () {
        createWeaponButton = new Button("Create Weapon");
        createWeaponButton.setOnAction(event -> selectFile("Photos: "));
        weaponBank.setContent(createWeaponButton);
    }

    private void openFileChooser (FileChooser chooseFile) {
        chosenFile = chooseFile.showOpenDialog(new Stage());
        if (chosenFile != null) {
            // give this image an id, keep it in bank
        }
    }

    private void selectFile (String fieldText) {
        FileChooser choose = new FileChooser();
        choose.setTitle("Load New Weapon to Editor");
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter(fieldText, "*.png", "*.jpg");
        choose.getExtensionFilters().add(extFilter);
        openFileChooser(choose);
    }
    
    public Node getInstanceAsNode(){
        return weaponBank;
    }

}
