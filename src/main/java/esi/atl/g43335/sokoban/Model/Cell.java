package esi.atl.g43335.sokoban.Model;

/**
 *
 * @author franc
 */
public class Cell {

    private CellType type;
    private final boolean moveable;

    public Cell(CellType type) {
        this.type = type;
        moveable = false;
    }

    //??
    public Cell(Box box) {
        moveable = true;
    }

    //??
    public Cell(Player player) {
        moveable = true;
    }

    public CellType getType() {
        return type;
    }

    public boolean getMoveable() {
        return moveable;
    }
}
