package esi.atl.g43335.sokoban.Model;

/**
 *
 * @author franc
 */
public class Position {

    private final int row;
    private final int column;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Position next(Direction direction) {
        return new Position(row + direction.getRow(), column + direction.getColumn());
    }
}
