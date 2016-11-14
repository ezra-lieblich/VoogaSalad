package gameauthoringenvironment.view.createscene;

import javafx.scene.Group;
import javafx.scene.Scene;


/**
 * An interface to define the external API in regards to the creation of
 * the authoring screen.
 *
 */
public interface IDesignScene {

    public Scene getScene ();

    public Group getMyRoot ();

}
