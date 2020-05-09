package esi.atl.g43335.sokoban.model.items;

import esi.atl.g43335.sokoban.model.Item;
import esi.atl.g43335.sokoban.model.ItemType;

/**
 *
 * @author franc
 */
public class Wall extends Item {

    /**
     * Create a wall, a wall can't move.
     */
    public Wall() {
        super(ItemType.WALL);
    }
}
