package esi.atl.g43335.sokoban.model.items;

import esi.atl.g43335.sokoban.model.Item;
import esi.atl.g43335.sokoban.model.ItemType;

/**
 *
 * @author franc
 */
public class Goal extends Item {

    /**
     * Create a goal, a goal can't move ==> isMoveable initialized at false.
     */
    public Goal() {
        super(ItemType.GOAL, false);
    }

}
