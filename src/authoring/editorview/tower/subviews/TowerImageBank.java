package authoring.editorview.tower.subviews;

import java.io.File;
import java.io.IOException;
import authoring.editorview.PhotoFileChooser;
import authoring.editorview.tower.TowerEditorViewDelegate;
import authoring.utilityfactories.BoxFactory;
import authoring.utilityfactories.ButtonFactory;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class TowerImageBank extends PhotoFileChooser {

    private TowerEditorViewDelegate delegate;
    private ScrollPane towerBank;
    private VBox vbox;
    private File chosenFile;

    public TowerImageBank () {
        towerBank = new ScrollPane();
        Button createTowerButton =
                ButtonFactory.makeButton("Create Tower",
                                         e -> {
                                             try {
                                                 selectFile("Photos: ", "Select new tower image");
                                             }
                                             catch (IOException e1) {
                                                 // TODO Make this exception more user friendly
                                                 e1.printStackTrace();
                                             }
                                         });
        vbox = BoxFactory.createVBox("Tower Bank: ");
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
        
    }

}
