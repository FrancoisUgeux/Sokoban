package esi.atl.g43335.sokoban.Model.items;

import esi.atl.g43335.sokoban.Model.Item;
import esi.atl.g43335.sokoban.Model.ItemType;

/**
 *
 * @author franc
 */
public class Box extends Item {

    public Box() {
        super(ItemType.GOAL, true, false);
    }
}
