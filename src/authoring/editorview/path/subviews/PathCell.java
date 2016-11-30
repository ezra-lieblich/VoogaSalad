package authoring.editorview.path.subviews;

public class PathCell {
	
	private boolean inPath;
	
	public PathCell(){
		this.inPath = false;
	}
	
	public void setInPath(boolean inPath){
		this.inPath = inPath;
	}
	
	
	public boolean getInPathBoolean(){
		return inPath;
	}

}
