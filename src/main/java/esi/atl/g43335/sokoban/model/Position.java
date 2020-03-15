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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.row;
        hash = 83 * hash + this.column;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Position other = (Position) obj;
        if (this.row != other.row) {
            return false;
        }
        if (this.column != other.column) {
            return false;
        }
        return true;
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
