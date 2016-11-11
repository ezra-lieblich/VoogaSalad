package view.helper;

import javafx.scene.image.ImageView;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;

public class DragDrop {
	private ImageView source;
	private Pane target;

	public DragDrop(ImageView source, Pane target) {
		this.source = source;
		this.target = target;
	}

	public void makeDraggable() {
		source.setOnDragDetected(e->{
			
		});
	}
	
	public void detectDrag(){
		target.setOnDragOver(e -> {
			if (e.getGestureSource() != target) {
	              /* allow for moving */
	              e.acceptTransferModes(TransferMode.MOVE);
	          }
	          
	          e.consume();
        });
		target.setOnDragDropped(e -> {
            
        });
		
		target.setOnDragExited(e ->{
			
		});
	}

}
