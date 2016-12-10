package authoring.editorview;

import java.util.List;


public interface IUpdateView {

    void updateNameDisplay (String name);

    void updateImagePathDisplay (String imagePath);

    void updateSizeDisplay (double size);

    void updateBank (List<Integer> ids);

    void updateDeleteEntity (String entityID);

}
