package gameauthoringenvironment.view.level;

import javafx.scene.Node;

/**
 * 
 * Communicates with the model to indicate when a new level was chosen
 *
 */
public interface ILevelEditorView {

    /**
     * 
     * @return node of level view
     */
    public Node getInstanceAsNode ();

}
