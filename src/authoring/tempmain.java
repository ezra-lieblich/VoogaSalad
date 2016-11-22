package authoring;

import java.io.IOException;
import authoring.view.AuthoringViewController;
import authoring.view.IAuthoringView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class tempmain extends Application {

    public static final String TITLE = "VOOGASquad";
    private Stage stage;
    private static final int SIZE = 700;

    public Stage getStage () {
        return stage;
    }

    @Override
    public void start (Stage s) throws IOException {
        this.stage = s;
        // This is just for testing, should be switched to creating the authoring environment first
        // AuthoringView game = new AuthoringView(SIZE, SIZE);
        AuthoringViewController mainVC = new AuthoringViewController(SIZE, SIZE);
        IAuthoringView mainView = mainVC.getView();
        Scene scene = mainView.getScene();
        s.setTitle(TITLE);
        s.setScene(scene);
        s.setResizable(false);
        s.show();

    }

    public static void main (String[] args) {
        launch(args);
    }

}
