package authoring.editorview.path.subviews;

import java.util.ResourceBundle;

import authoring.editorview.ImageBank;
import authoring.editorview.path.PathAuthoringViewDelegate;
import authoring.utilityfactories.ButtonFactory;
import javafx.scene.control.Button;

public class PathBank extends ImageBank {
	
	private PathAuthoringViewDelegate delegate;
	
	public PathBank(ResourceBundle pathResource){
		super();
		Button createPathButton =
				ButtonFactory.makeButton(pathResource.getString("NewPathButton"),
                 e -> {
					createNewPath();		
				});
		
	}

	@Override
	protected void userSelectedRow(int index) {
		// TODO Auto-generated method stub
		
	}
	
	public void setDelegate(PathAuthoringViewDelegate delegate){
		this.delegate = delegate;
	}
	
	private void createNewPath(){
		int activeID = delegate.onUserEnteredCreatePath();				
		delegate.onUserEnteredEditPath(activeID);
		
	}
	

}
