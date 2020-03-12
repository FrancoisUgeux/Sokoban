package esi.atl.g43335.sokoban.Model.items;

import esi.atl.g43335.sokoban.Model.Item;
import esi.atl.g43335.sokoban.Model.ItemType;

/**
 *
 * @author franc
 */
public class Wall extends Item{

    public Wall() {
        super(ItemType.WALL, false, false);
    }
}
