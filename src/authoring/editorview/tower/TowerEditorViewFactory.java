package authoring.editorview.tower;

/**
 * 
 * @author Diane Hadley
 *
 */

public class TowerEditorViewFactory {

    public static ITowerEditorView build (int width, int height) {

        return new TowerEditorView();
    }

}
