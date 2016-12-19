package authoring.editortabpane;

import java.util.List;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class EditorTabPaneFactory {

    private EditorTabPaneFactory () {
        // Does Nothing
    }

    public static IEditorTabPane build (int width, int height, List<String> tabs) {
        return new EditorTabPane(width, height, tabs);
    }

}
