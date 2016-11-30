package authoring.main;

import engine.ModelAuthoringController;
import engine.ModelController;

public class AuthoringController {
    private ModelController modelController;
    
    AuthoringController() {
        modelController = new ModelAuthoringController();
    }
}
