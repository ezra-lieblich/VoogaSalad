package authoring.editorview.weapon;



/**
 * 
 * @author Diane Hadley
 *
 */

public class WeaponAuthoringViewFactory {

    public static WeaponUpdateView build (int width, int height) {
        return new WeaponAuthoringView(width, height);
    }

}
