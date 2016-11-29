package authoring.editorview.path.subviews;

public class PathCell {
	
	private int x;
	private int y;
	private boolean inPath;
	
	public PathCell(int x, int y){
		this.x = x;
		this.y = y;	
		this.inPath = false;
	}
	
	public void setInPath(boolean inPath){
		this.inPath = inPath;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public boolean getInPathBoolean(){
		return inPath;
	}

}
