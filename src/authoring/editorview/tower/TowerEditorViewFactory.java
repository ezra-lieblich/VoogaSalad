package authoring.editorview.tower;

import java.io.IOException;


/**
 * 
 * @author Diane Hadley
 *
 */

public class TowerEditorViewFactory {

    public static ITowerEditorView build (int width, int height) throws IOException {

        return new TowerEditorView();
    }

}
