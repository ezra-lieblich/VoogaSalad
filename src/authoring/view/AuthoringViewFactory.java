package authoring.view;

/**
 * Creates the overall authoring view
 * 
 * @author Kayla Schulz
 *
 */
public class AuthoringViewFactory {

    private AuthoringViewFactory () {
        // Does Nothing
    }

    /**
     * 
     * @param aWidth
     * @param aHeight
     * @return Authoring View Interface
     */
    public static IAuthoringView build (int aWidth, int aHeight) {
        return new AuthoringView(aWidth, aHeight);
    }

}
