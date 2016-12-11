package authoring.toolbar;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import authoring.utilityfactories.DialogueBoxFactory;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class Toolbar implements IToolbar {

    private ToolBar toolbar;

    private Button saveButton;
    
    private Button loadButton;
    
    public Toolbar (int aWidth, int aHeight) {
    	
    	saveButton = new Button("Save");
    	
    	loadButton = new Button("Load");
    	
        this.toolbar = new ToolBar(
        						saveButton,
        						loadButton
                                );
        
    }
    
    @Override
    public void setOnPressedLoad(EventHandler<MouseEvent> e) {
    	loadButton.setOnMouseClicked(e);
    }

    @Override
    public Node getInstanceAsNode () {
        return toolbar;
    }

    @Override
    public void setOnPressedSave (EventHandler<MouseEvent> e) {
        saveButton.setOnMouseClicked(e);
    }

    public void saveFile (String content) {
        FileChooser choose = new FileChooser();
        choose.setTitle("Save game");
        FileChooser.ExtensionFilter extFilter =
                new FileChooser.ExtensionFilter("XML Files (*.xml)", "*.xml");
        choose.getExtensionFilters().add(extFilter);
        File newFile = choose.showSaveDialog(new Stage());
        if (newFile != null) {
            FileWriter fileWriter;
            try {
                fileWriter = new FileWriter(newFile);
                fileWriter.write(content);
                fileWriter.close();
            }
            catch (IOException e) {
                Alert fileError =
                        DialogueBoxFactory.createErrorDialogueBox("Error with file. Can't be saved",
                                                                  "File Error");
                fileError.show();
            }

        }
    }

}
