package view.dragdrop;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
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
		source.setOnDragDetected(new EventHandler <MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                /* drag was detected, start drag-and-drop gesture*/
                System.out.println("onDragDetected");
                
                /* allow MOVE transfer mode */
                Dragboard db = source.startDragAndDrop(TransferMode.MOVE);
                
                /* put a string on dragboard */
                ClipboardContent content = new ClipboardContent();
                content.putString("blahy poo");
                db.setContent(content);
                
                event.consume();
            }
        });
		
	}

	public void detectDrag() {
		target.setOnDragOver(new EventHandler <DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                /* data is dragged over the target */
                System.out.println("onDragOver");
                
                /* accept it only if it is  not dragged from the same node 
                 * and if it has a string data */
                if (event.getGestureSource() != target) {
                    /* allow for moving */
                    event.acceptTransferModes(TransferMode.MOVE);
                }
                
                event.consume();
            }
        });
		
		target.setOnDragOver(e -> {
			if (e.getGestureSource() != target) {
				/* allow for moving */
				e.acceptTransferModes(TransferMode.MOVE);
			}else{
				System.out.println("Over target!");
			}

			e.consume();
		});
		target.setOnDragDropped(e -> {

		});

		target.setOnDragExited(e -> {

		});
	}

}
