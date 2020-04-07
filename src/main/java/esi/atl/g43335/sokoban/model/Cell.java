package esi.atl.g43335.sokoban.model;

import esi.atl.g43335.sokoban.model.items.Floor;
import java.util.Objects;

/**
 * This class represent a cell of the game board.
 *
 * @author franc
 */
public class Cell {

    private Item item;

    /**
     *
     * @param item is an item to put on this cell.
     */
    public Cell(Item item) {
        this.item = item;
    }

    /**
     * if there is nothing to put on the cell it's considered to be made of
     * floor.
     */
    public Cell() {
        this.item = new Floor();
    }

    /**
     *
     * @return the item on this cell.
     */
    public Item getItem() {
        return item;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.item);
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
        final Cell other = (Cell) obj;
        if (!Objects.equals(this.item, other.item)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return true if this cell is made of floor.
     */
    public boolean isFree() {
        return item.getType() == ItemType.FLOOR;
    }

    /**
     * Put an item on this cell.
     *
     * @param item is the item to put on this cell.
     */
    public void put(Item item) {
        this.item = item;
    }

    /**
     * Remove what's on this cell.
     */
    public void remove() {
        item = new Floor();
    }
}
