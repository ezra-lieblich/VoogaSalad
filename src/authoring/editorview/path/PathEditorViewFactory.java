package authoring.editorview.path;

public class PathEditorViewFactory {

    private PathEditorViewFactory () {
        // Does Nothing
    }

    public static IPathEditorView build (int width, int height) {
        return new PathEditorView(width, height);
    }

}
