package authoring.editorview.level;

public class LevelEditorViewFactory {

    public static ILevelEditorView build (int width, int height) {

        return new LevelEditorView(width, height);

    }

}
