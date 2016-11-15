package gameauthoringenvironment.view.tower;

import javafx.scene.Node;

/**
 * The Tower View interface will detail the components of the tower creation. The interface
 * determines a portion of our internal API.
 *
 */
public interface ITowerView {
    
    /**
     * To be seen by the IDesignScene class
     * @return Node of the tower view
     */
    public Node getNodeAsInstance();

}
