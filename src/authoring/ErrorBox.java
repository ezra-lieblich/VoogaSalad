package authoring;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class ErrorBox {

    public ErrorBox () {

    }

    public static Alert createErrorBox (String message) {
        Alert errorBox = new Alert(AlertType.ERROR);
        errorBox.setTitle(message);
        errorBox.setContentText(message);
        errorBox.showAndWait();
        return errorBox;
    }

}
