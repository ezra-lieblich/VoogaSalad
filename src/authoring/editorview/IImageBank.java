package authoring.editorview;

import javafx.scene.Node;


public interface IImageBank {

    public void setDelegate (); // TODO: This needs to have parameter of delegate, but specific to
                                // type of implementation i.e. WeaponEditorViewDelegate

    public Node getInstanceAsNode ();
}
