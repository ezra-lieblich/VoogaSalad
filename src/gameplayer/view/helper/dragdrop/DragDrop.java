package gameplayer.view.helper.dragdrop;

import gameplayer.view.helper.GraphicsLibrary;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;

/**
 * DragDrop is responsible for allowing an ImageView to be dragged and dropped
 * into another pane
 * 
 * @author lucyzhang
 *
 */
public class DragDrop {

	private ImageView source;
	private double width;
	private double height;
	private GraphicsLibrary graphicLib;

	public DragDrop() {
		this.graphicLib = new GraphicsLibrary();
	}

	/**
	 * Initializes the drag functionality for an element and its target location
	 * @param source This is the source that is to be dragged and dropped
	 * @param target This is the target that the image is to be dropped into
	 */
	public void init(ImageView source, Node target) {
		detectDrag(source, target);
	}

	private void initDragDetectionIcon(ImageView source) {
		Dragboard db = source.startDragAndDrop(TransferMode.MOVE);
		ClipboardContent content = new ClipboardContent();
		content.putString("blahy poo");
		db.setContent(content);
	}

	private void addImagetoDroppedLoc(double xpos, double ypos, Node target) {
		ImageView copy = new ImageView(this.source.getImage());
		graphicLib.setImageViewParams(copy, this.width, this.height);
		((Pane) target).getChildren().add(copy);
		copy.setX(xpos);
		copy.setY(ypos);
	}

	private void setSourceInfo(ImageView source) {
		this.source = source;
		this.width = source.getFitWidth();
		this.height = source.getFitHeight();
	}

	private void detectDrag(ImageView source, Node target) {
		source.setOnDragDetected(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				setSourceInfo(source);
				initDragDetectionIcon(source);
				event.consume();
			}
		});

		target.setOnDragOver(new EventHandler<DragEvent>() {
			@Override
			public void handle(DragEvent event) {
				if (event.getGestureSource() != target) {
					event.acceptTransferModes(TransferMode.MOVE);
				}
				event.consume();
			}
		});

		target.setOnDragDropped(event -> {
			addImagetoDroppedLoc(event.getSceneX(), event.getSceneY(), target);
			event.setDropCompleted(true);
		});

	}

}
