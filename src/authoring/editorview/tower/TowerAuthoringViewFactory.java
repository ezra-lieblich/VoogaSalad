package authoring.editorview.tower;

/**
 * 
 * @author Diane Hadley
 *
 */

public class TowerAuthoringViewFactory {

    public static ITowerUpdateView build (int width, int height) {

        return new TowerAuthoringView();
    }

}
