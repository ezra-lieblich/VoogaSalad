package authoring.editorview;

import java.io.File;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class PhotoFileChooser {

    private File chosenFile;

    public PhotoFileChooser () {

    }

    public File getChosenFile () {
        return chosenFile;
    }

    public void selectFile (String fieldText, String chooserTitle) {
        FileChooser choose = new FileChooser();
        choose.setTitle(chooserTitle);
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter(fieldText, "*.png", "*.jpg", "*.gif");
        choose.getExtensionFilters().add(extFilter);
        openFileChooser(choose);
    }

    private void openFileChooser (FileChooser chooseFile) {
        chosenFile = chooseFile.showOpenDialog(new Stage());
    }
}
