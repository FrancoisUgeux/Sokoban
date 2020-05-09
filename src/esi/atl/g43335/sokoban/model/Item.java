package esi.atl.g43335.sokoban.model;

import java.util.Objects;

/**
 * An item is an element to put in the maze
 *
 * @author franc
 */
public class Item {

    private final ItemType type;
//    private final boolean Moveable;

    /**
     *
     * @param type is the kind of element of this item.
     * @param isMoveable tell if this item can move or be moved.
     */
    public Item(ItemType type) { //, boolean isMoveable
        this.type = type;
//        this.Moveable = isMoveable;
    }

    /**
     *
     * @return the type of this item.
     */
    public ItemType getType() {
        return type;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.type);
//        hash = 53 * hash + (this.Moveable ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
//        if (this.Moveable != other.Moveable) {
//            return false;
//        }
        return this.type == other.type;
    }

    /**
     *
     * @return true if this item can move.
     */
//    public boolean isMoveable() {
//        return Moveable;
//    }
}
