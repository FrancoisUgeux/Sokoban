package esi.atl.g43335.sokoban.model.items;

import esi.atl.g43335.sokoban.model.Item;
import esi.atl.g43335.sokoban.model.ItemType;

/**
 *
 * @author franc
 */
public class Floor extends Item {

    /**
     * Create a floor. a floor can't move ==> isMoveable initialized at false.
     */
    public Floor() {
        super(ItemType.FLOOR, false);
    }

}
