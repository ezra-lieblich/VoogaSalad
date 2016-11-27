package authoring.editorview.tower.subviews;

import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;
import authoring.editorview.PhotoFileChooser;
import authoring.editorview.tower.TowerEditorViewDelegate;
import authoring.utilityfactories.BoxFactory;
import authoring.utilityfactories.ButtonFactory;
import authoring.utilityfactories.DialogueBoxFactory;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class TowerImageBank extends PhotoFileChooser {

    private TowerEditorViewDelegate delegate;
    private ScrollPane towerBank;
    private VBox vbox;
    private File chosenFile;

    public TowerImageBank (ResourceBundle labelsResource, ResourceBundle dialogueBoxResource) {
        towerBank = new ScrollPane();
        Button createTowerButton =
                ButtonFactory.makeButton("Create Tower",
                                         e -> {
                                             try {
                                                 selectFile(labelsResource.getString("Photos"),
                                                            labelsResource.getString("Image"));
                                             }
                                             catch (IOException e1) {
                                                 DialogueBoxFactory
                                                         .createErrorDialogueBox(dialogueBoxResource
                                                                 .getString("UnableToOpen"),
                                                                                 dialogueBoxResource
                                                                                         .getString("TryAgain"));
                                             }
                                         });
        vbox = BoxFactory.createVBox(labelsResource.getString("TowerBank"));
        vbox.getChildren().add(createTowerButton);
        towerBank.setContent(vbox);
    }

    public void setDelegate (TowerEditorViewDelegate delegate) {
        this.delegate = delegate;
    }

    public Node getInstanceAsNode () {
        return towerBank;
    }

    @Override
    public void openFileChooser (FileChooser chooseFile) throws IOException {
        chosenFile = chooseFile.showOpenDialog(new Stage());
        if (chosenFile != null) {

        }
    }

}
