package authoring.editorview;

import java.io.File;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class PhotoFileChooser {

    public PhotoFileChooser () {

    }
    
    private File chosenFile;

    public File getChosenFile () {
        return chosenFile;
    }

    private void openFileChooser (FileChooser chooseFile) {
        chosenFile = chooseFile.showOpenDialog(new Stage());
    }

    public void selectFile (String fieldText, String chooserTitle) {
        FileChooser choose = new FileChooser();
        choose.setTitle(chooserTitle);
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter(fieldText, "*.png", "*.jpg", "*.gif");
        choose.getExtensionFilters().add(extFilter);
        openFileChooser(choose);
    }

}
