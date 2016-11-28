package authoring;

import java.io.IOException;
import authoring.view.AuthoringViewController;
import authoring.view.IAuthoringView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class tempmain extends Application {

    public static final String TITLE = "VOOGASquad";
    private static final int SIZE = 700;

    @Override
    public void start (Stage s) throws IOException {
        AuthoringViewController mainVC = new AuthoringViewController(SIZE, SIZE);
        IAuthoringView mainView = mainVC.getView();
        Scene scene = mainView.getScene();
        s.setTitle(TITLE);
        s.setScene(scene);
        s.setResizable(true);
        s.setHeight(SIZE);
        s.setWidth(SIZE + 145);
        s.show();

    }

    public static void main (String[] args) {
        launch(args);
    }

}
