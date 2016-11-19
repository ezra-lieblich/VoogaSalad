package authoring.editorview.weapon.subviews;

import java.io.File;
import java.util.ArrayList;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class WeaponImageView {
    
    private Button createWeaponButton;
    private File chosenFile;
    
    WeaponImageView() {
        createWeaponButton = new Button("Create Weapon");
    }
    
    void loadFile(){
        selectFile("Text Files: ");
        ArrayList<String> instructionList = new ArrayList<>();

}

private void openFileChooser(FileChooser chooseFile){
        chosenFile = chooseFile.showOpenDialog(new Stage());
        if(chosenFile != null){
                //initScanner(chosenFile);
        }
}

private void selectFile( String aFieldText ) {
        FileChooser choose = new FileChooser();
        choose.setTitle("Load .TXT File to Editor");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter( aFieldText, "*.txt");
        choose.getExtensionFilters().add(extFilter);
        openFileChooser( choose );
}
    

}
