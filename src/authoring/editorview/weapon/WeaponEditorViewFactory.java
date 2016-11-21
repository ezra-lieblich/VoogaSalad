package authoring.editorview.weapon;

/**
 * 
 * @author Diane Hadley
 *
 */

public class WeaponEditorViewFactory {
	
	public static IWeaponEditorView build (int width, int height) {
        return new WeaponEditorView();
    }

}
