package esi.atl.g43335.sokoban.model;

import esi.atl.g43335.sokoban.model.items.Floor;

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
//        if (!this.item.isCrosseable()) {
//            throw new IllegalStateException("Must be a crosseable item(goal,floor)");
//        }
        this.item = item;
    }

    /**
     * Remove what's on this cell.
     */
    public void remove() {
        item = new Floor();
    }
}
