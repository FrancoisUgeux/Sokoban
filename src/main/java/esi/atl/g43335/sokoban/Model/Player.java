package esi.atl.g43335.sokoban.Model;

/**
 *
 * @author franc
 */
public class Player extends Moveable {

    private final int nbMoves;

    public Player(Position position, int nbMoves) {
        super(position);
        this.nbMoves = nbMoves;
    }

    public int getNbMoves() {
        return nbMoves;
    }

    public void move(Direction direction) {
        getPosition().next(direction);
    }
}
