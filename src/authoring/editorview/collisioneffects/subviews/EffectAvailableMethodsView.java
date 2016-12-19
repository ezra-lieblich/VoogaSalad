package authoring.editorview.collisioneffects.subviews;

import java.util.ArrayList;
import java.util.List;

import authoring.editorview.collisioneffects.EffectAuthoringViewDelegate;
import authoring.editorview.collisioneffects.EffectSetView;
import authoring.editorview.imagebank.ImageBank;
import javafx.scene.Node;
import javafx.scene.control.Label;


/**
 * 
 * @author Kayla Schulz
 *
 */
public class EffectAvailableMethodsView extends ImageBank implements EffectSetView {

    private EffectAuthoringViewDelegate delegate;

    public EffectAvailableMethodsView () {
        super();
        listView.setPrefWidth(450);
    }

    @Override
    public void setDelegate (EffectAuthoringViewDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    protected void userSelectedRow (int index) {
        // Do nothing
    }

    public void updateAvailMethods (List<String> list) {
        if (dataSource == null) {
            //System.out.println("Table data source not set");
            return;
        }
        this.clearItems();

        for (int i = 0; i < list.size(); i++) {
            Label temp = new Label(list.get(i));
            Node cell = temp;
//            items.add(cell);
        }
    }

}
