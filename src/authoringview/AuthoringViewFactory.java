package authoringview;


public class AuthoringViewFactory {

    private AuthoringViewFactory () {
        // Does Nothing
    }

    public static IAuthoringView build (int aWidth, int aHeight) {
        return new AuthoringView(aWidth, aHeight);
    }
    
}
