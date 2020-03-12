package esi.atl.g43335.sokoban.Model.items;

import esi.atl.g43335.sokoban.Model.Item;
import esi.atl.g43335.sokoban.Model.ItemType;

/**
 *
 * @author franc
 */
public class Player extends Item {

    private final int nbMoves;

    public Player(int nbMoves) {
        super(ItemType.PLAYER, true, false);
        this.nbMoves = nbMoves;
    }

    public int getNbMoves() {
        return nbMoves;
    }
}
