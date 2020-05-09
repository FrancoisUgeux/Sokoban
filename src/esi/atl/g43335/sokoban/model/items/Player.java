package esi.atl.g43335.sokoban.model.items;

import esi.atl.g43335.sokoban.model.Item;
import esi.atl.g43335.sokoban.model.ItemType;

/**
 * Create a player, this player can move ==> isMoveable initialized at true. and
 * has a cpt of moves.
 *
 * @author franc
 */
public class Player extends Item {

    /**
     * Create a player, the player can move.
     */
    public Player() {
        super(ItemType.PLAYER);
    }
}
