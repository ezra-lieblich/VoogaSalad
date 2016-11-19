package authoring.editorview.weapon;



public class WeaponEditorViewFactory {
	
	public static IWeaponEditorView build (int width, int height) {
        return new WeaponEditorView();
    }

}
