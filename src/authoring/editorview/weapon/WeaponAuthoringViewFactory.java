package authoring.editorview.weapon;

import java.io.IOException;


/**
 * 
 * @author Diane Hadley
 *
 */

public class WeaponAuthoringViewFactory {

    public static IWeaponUpdateView build (int width, int height) throws IOException {
        return new WeaponAuthoringView(width, height);
    }

}
