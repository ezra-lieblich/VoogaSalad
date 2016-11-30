package authoring.editorview.level;

public class LevelEditorViewFactory {

    public static ILevelSetView build (int width, int height) {

        return new LevelEditorView(width, height);

    }

}
