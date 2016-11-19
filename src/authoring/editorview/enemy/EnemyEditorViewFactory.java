package authoring.editorview.enemy;

public class EnemyEditorViewFactory {

    public static IEnemyEditorView build (int width, int height) {
        return new EnemyEditorView();
    }

}
