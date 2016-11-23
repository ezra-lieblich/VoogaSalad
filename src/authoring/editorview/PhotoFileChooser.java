package authoring.editorview;

import java.io.File;
import javafx.stage.FileChooser;


public abstract class PhotoFileChooser {

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

    public abstract void openFileChooser (FileChooser chooseFile);
}
