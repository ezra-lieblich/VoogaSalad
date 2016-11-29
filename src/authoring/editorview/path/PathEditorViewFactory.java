package authoring.editorview.path;

public class PathEditorViewFactory {

    private PathEditorViewFactory () {
       
    }

    public static IPathUpdateView build (int width, int height) {
        return new PathEditorView(width, height);
    }

}
