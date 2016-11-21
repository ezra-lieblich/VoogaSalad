package authoring.editorview.tower;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
/**
 * 
 * @author Diane Hadley
 *
 */
public class TowerEditorView implements ITowerEditorView {
        
        private BorderPane root;
        
        
        public TowerEditorView(){
                root = new BorderPane();
                
        }
        
    @Override
    public Node getInstanceAsNode () {      
        return root;
    }
    
    public void getTowerSetter(){
        Group designTower = new Group();
        root.setCenter(designTower);
    }
}