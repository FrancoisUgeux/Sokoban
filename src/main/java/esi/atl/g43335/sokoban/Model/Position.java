package esi.atl.g43335.sokoban.model;

/**
 * Represent a position on the board.
 *
 * @author franc
 */
public class Position {

    private int row;
    private int column;

    /**
     *
     * @param row
     * @param column
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     *
     * @return the row.
     */
    public int getRow() {
        return row;
    }

    /**
     *
     * @return the column.
     */
    public int getColumn() {
        return column;
    }

    /**
     * Give the next position in a direction.
     *
     * @param direction the direction.
     * @return the position in that direction.
     */
    public Position next(Direction direction) {
        return new Position(row + direction.getRow(), column + direction.getColumn());
    }
}
