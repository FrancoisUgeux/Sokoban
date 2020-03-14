package esi.atl.g43335.sokoban.model.items;

import esi.atl.g43335.sokoban.model.Item;
import esi.atl.g43335.sokoban.model.ItemType;

/**
 *
 * @author franc
 */
public class Player extends Item {

    private final int nbMoves;

    public Player(int nbMoves) {
        super(ItemType.PLAYER, true);
        this.nbMoves = nbMoves;
    }

    public int getNbMoves() {
        return nbMoves;
    }
}
