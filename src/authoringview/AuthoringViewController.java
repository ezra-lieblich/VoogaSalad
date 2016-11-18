package authoringview;

import java.util.HashMap;

public class AuthoringViewController {
	private IAuthoringView scene;
	private HashMap<String, EditorView> editors;
	
	public AuthoringViewController(int width, int height){
		scene = AuthoringViewFactory.build(width, height);
		
	}
	
}
