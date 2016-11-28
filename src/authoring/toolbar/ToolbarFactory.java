package authoring.toolbar;

/**
 * Builds toolbar and returns Toolbar Interface
 * 
 * @author Kayla Schulz
 *
 */
public class ToolbarFactory {

    private ToolbarFactory () {
        // Does Nothing
    }

    /**
     * 
     * @param aWidth
     * @param aHeight
     * @return Toolbar Interface
     */
    public static IToolbar build (int aWidth, int aHeight) {
        return new Toolbar(aWidth, aHeight);
    }

}
