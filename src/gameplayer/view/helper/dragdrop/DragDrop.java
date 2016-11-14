package gameplayer.view.helper.dragdrop;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;

public class DragDrop {
	private ImageView source;
	private Node target;

	// get rid of this later

	public DragDrop(ImageView source, Node target) {
		this.source = source;
		this.target = target;
	}

	public void makeDraggable() {

	}

	public void detectDrag() {
		source.setOnDragDetected(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				/* drag was detected, start drag-and-drop gesture */
				// System.out.println("onDragDetected");
				Dragboard db = source.startDragAndDrop(TransferMode.MOVE);
				System.out.println(db.getImage());
				// System.out.println(db.getDragViewOffsetX()+",
				// "+db.getDragViewOffsetY());
				ClipboardContent content = new ClipboardContent();
				content.putString("blahy poo");
				db.setContent(content);
				event.consume();
			}
		});

		target.setOnDragOver(new EventHandler<DragEvent>() {
			@Override
			public void handle(DragEvent event) {
				/* data is dragged over the target */
				// System.out.println("over target!");

				// ((Pane) target).getChildren().add(source);
				/*
				 * accept it only if it is not dragged from the same node and if
				 * it has a string data
				 */
				if (event.getGestureSource() != target) {
					/* allow for moving */
					event.acceptTransferModes(TransferMode.MOVE);

				}

				event.consume();
			}
		});

		target.setOnDragDropped(event -> {
			System.out.println("on drag dropped!");
			// Dragboard db = event.getDragboard();
			// System.out.println("The db likely null: "+db.getImage());
			System.out.println("in db.hasImage()");
			//ImageView imageView = new ImageView(source/* db.getImage() */);
			//imageView.setFitHeight(30);
			//imageView.setFitWidth(30);
			//imageView.setPreserveRatio(true);
			
			((Pane) target).getChildren().add(source);
			event.setDropCompleted(true);
			// }

		});

		target.setOnDragExited(e -> {

		});
	}

}
