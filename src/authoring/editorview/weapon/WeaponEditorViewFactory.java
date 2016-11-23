package authoring.editorview.weapon;

import java.io.IOException;


/**
 * 
 * @author Diane Hadley
 *
 */

public class WeaponEditorViewFactory {

    public static IWeaponEditorView build (int width, int height) throws IOException {
        return new WeaponEditorView();
    }

}
