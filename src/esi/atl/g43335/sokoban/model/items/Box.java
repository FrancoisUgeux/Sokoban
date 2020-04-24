package esi.atl.g43335.sokoban.model.items;

import esi.atl.g43335.sokoban.model.Item;
import esi.atl.g43335.sokoban.model.ItemType;

/**
 *
 * @author franc
 */
public class Box extends Item {

    /**
     * Create a box, a box can move ==> isMoveable initialized at true.
     */
    public Box() {
        super(ItemType.BOX, true);
    }
}
