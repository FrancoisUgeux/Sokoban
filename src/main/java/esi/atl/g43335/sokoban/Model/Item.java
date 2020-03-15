package esi.atl.g43335.sokoban.model;

/**
 * An item is an element to put in the maze
 *
 * @author franc
 */
public class Item {

    private ItemType type;
    private boolean Moveable;

    /**
     *
     * @param type is the kind of element of this item.
     * @param isMoveable tell if this item can move or be moved.
     */
    public Item(ItemType type, boolean isMoveable) {
        this.type = type;
        this.Moveable = isMoveable;
    }

    /**
     *
     * @return the type of this item.
     */
    public ItemType getType() {
        return type;
    }

    /**
     *
     * @return true if this item can move.
     */
    public boolean isMoveable() {
        return Moveable;
    }
}
