package authoringview;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class tempmain extends Application {

    public static final String TITLE = "VOOGASquad";
    private Stage stage;
    private static final int SIZE = 700;

    
    public Stage getStage(){
            return stage;
    }

    @Override
    public void start(Stage s){
            this.stage = s;
            //This is just for testing, should be switched to creating the authoring environment first
            AuthoringView game = new AuthoringView(SIZE, SIZE); 
            Scene scene = game.getScene();
            s.setTitle(TITLE);
            s.setScene(scene);
            s.show();

    }

    public static void main(String[] args) {
            launch(args);
    }
    
}
