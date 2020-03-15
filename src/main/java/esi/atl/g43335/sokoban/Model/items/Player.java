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

    private final int nbMoves;

    /**
     *
     * @param nbMoves is the number of moves made by Soko.
     */
    public Player(int nbMoves) {
        super(ItemType.PLAYER, true);
        this.nbMoves = nbMoves;
    }

    /**
     *
     * @return the number of moves made by Soko.
     */
    public int getNbMoves() {
        return nbMoves;
    }
}
