package esi.atl.g43335.sokoban.model;

import java.util.Objects;

/**
 * An item is an element to put in the maze
 *
 * @author franc
 */
public class Item {

    private final ItemType type;

    /**
     *
     * @param type is the kind of element of this item.
     */
    public Item(ItemType type) {
        this.type = type;
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
        return this.type == other.type;
    }
}
