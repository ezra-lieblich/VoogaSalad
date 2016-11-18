package authoringview;

import javafx.scene.Group;
import javafx.scene.Scene;


/**
 * An interface to define the external API in regards to the creation of
 * the authoring screen.
 *
 */
public interface IAuthoringView {

    /**
     * Returns the current scene of the game authoring environment
     * @return Scene of game authoring environment
     */
    public Scene getScene ();

    /**
     * 
     * @return root of the game authoring scene
     */
    public Group getMyRoot ();

}