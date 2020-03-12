package esi.atl.g43335.sokoban.model;

/**
 *
 * @author franc
 */
public class Move {

    private Position start;
    private Position end;

    public Move(Position start, Position end) {
        if (start == null || end == null) {
            throw new NullPointerException("Attributes cannot be null");
        }
        this.start = start;
        this.end = end;
    }

    public Position getStart() {
        return start;
    }

    public Position getEnd() {
        return end;
    }
}
