package authoring.main;

import engine.ModelAuthoringController;
import engine.ModelController;

public class AuthoringController {
    private ModelController modelController;
    
    public AuthoringController() {
        modelController = new ModelAuthoringController();
    }
}
