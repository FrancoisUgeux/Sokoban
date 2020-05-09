package esi.atl.g43335.sokoban.model.items;

import esi.atl.g43335.sokoban.model.Item;
import esi.atl.g43335.sokoban.model.ItemType;

/**
 *
 * @author franc
 */
public class BoxGoal extends Item {

    /**
     * Create a box placed on a goal. This box can move.
     */
    public BoxGoal() {
        super(ItemType.BOXGOAL); 
    }

}
