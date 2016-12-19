// This entire file is part of my masterpiece.
// Andrew Bihl
/*
 * This class is the list of methods required for the ImageBank to get the data it will display for an item with a given ID.
 */

package authoring.editorview.imagebank;

public interface ListDataSource {
    public String getName (int id);
    public String getImagePath (int id);
}
