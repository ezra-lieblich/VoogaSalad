package authoring.editorview.enemy;

/**
 * 
 * @author Diane Hadley
 *
 */


public class EnemyEditorViewFactory {

    public static IEnemyEditorView build (int width, int height) {
        return new EnemyEditorView();
    }

}
