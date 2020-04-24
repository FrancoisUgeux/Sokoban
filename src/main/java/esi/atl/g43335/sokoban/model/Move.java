package esi.atl.g43335.sokoban.model;

/**
 * Move an item from start to end.
 *
 * @author franc
 */
public class Move {

    private Position start;
    private Position end;

    /**
     *
     * @param start a position with an item.
     * @param end the target to put the item on.
     */
    public Move(Position start, Position end) {
        if (start == null || end == null) {
            throw new NullPointerException("Attributes cannot be null");
        }
        this.start = start;
        this.end = end;
    }

    /**
     *
     * @return the start.
     */
    public Position getStart() {
        return start;
    }

    /**
     *
     * @return the target.
     */
    public Position getEnd() {
        return end;
    }
}
