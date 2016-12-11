package authoring.main;

import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class tempmain extends Application {

    public static final String TITLE = "VOOGASquad";
    private static final int SIZE = 700;

    @Override
    public void start (Stage s) throws IOException {

        AuthoringController generalController = new AuthoringController(SIZE);

        Scene scene = generalController.getScene();
        s.setTitle(TITLE);
        s.setScene(scene);
        s.setResizable(true);
        s.setHeight(SIZE);
        s.setWidth(SIZE + 395);
        s.show();
        
        // ExitDialogueBox box = new ExitDialogueBox();
        // box.displayDialogueBoxOnExit(s, e -> generalController.saveAsXMLFile());

    }

    public static void main (String[] args) {
        launch(args);
    }

}
