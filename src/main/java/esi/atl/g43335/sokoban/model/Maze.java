package esi.atl.g43335.sokoban.model;

import esi.atl.g43335.sokoban.model.items.Floor;
import esi.atl.g43335.sokoban.model.items.Wall;
import esi.atl.g43335.sokoban.model.items.Goal;
import esi.atl.g43335.sokoban.model.items.Box;
import esi.atl.g43335.sokoban.model.items.Player;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * Represent the board game. it's a board with a maze changing depending on the
 * level played
 *
 * @author franc
 */
public class Maze {

    private static final int ROWS = 40;
    private static final int COLUMNS = 40;
    private final Cell[][] cells;
    private Position start;
    private int nbGoals = 0;

    /**
     * Build an empty board made of floor before calling a level builder to add
     * the maze on it
     */
    public Maze() {
        cells = new Cell[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    public void chooseLevel(int level) {
        XsbReader reader = new XsbReader(this);
        switch (level) {
            case 0:
                reader.levelBuilder("levelTest");
                break;
            case 1:
                reader.levelBuilder("level1");
                break;
            default:
                reader.levelBuilder("levelTest");
        }
    }

    void addWall(Position pos) {
        cells[pos.getRow()][pos.getColumn()] = new Cell(new Wall());
    }

    void addBox(Position pos) {
        cells[pos.getRow()][pos.getColumn()] = new Cell(new Box());
    }

    void addGoal(Position pos) {
        cells[pos.getRow()][pos.getColumn()] = new Cell(new Goal());
        nbGoals++;
    }

    void addSoko(Position pos) {
        cells[pos.getRow()][pos.getColumn()] = new Cell(new Player(0));
        start = pos;
    }

    void addFloor(Position pos) {
        cells[pos.getRow()][pos.getColumn()] = new Cell(new Floor());
    }

    /**
     *
     * @param position is the position to check on the board.
     * @return a cell of this board.
     */
    public Cell getCell(Position position) {
        if (!isInside(position)) {
            throw new NullPointerException("out of board");
        }
        return cells[position.getRow()][position.getColumn()];
    }

    public int getNbGoals() {
        return nbGoals;
    }

    /**
     * change the starting position for a move. equals to the position of Soko.
     *
     * @param start
     */
    public void setStart(Position start) {
        this.start = start;
    }
    
    public void setNbGoals(int nb){
        nbGoals = nb;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Arrays.deepHashCode(this.cells);
        hash = 71 * hash + Objects.hashCode(this.start);
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
        final Maze other = (Maze) obj;
        if (!Arrays.deepEquals(this.cells, other.cells)) {
            return false;
        }
        if (!Objects.equals(this.start, other.start)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @param position is a position to check on the board.
     * @return true if this position is inside the board.
     */
    boolean isInside(Position position) {
        return (position.getRow() < cells.length
                && position.getRow() >= 0
                && position.getColumn() < cells[0].length
                && position.getColumn() >= 0);
    }

    /**
     *
     * @param p is a position to check on the board.
     * @return true if this position is made of floor.
     */
    public boolean isFree(Position p) {
        return cells[p.getRow()][p.getColumn()].isFree();
    }

    /**
     *
     * @return the 2d array representing the board.
     */
    public Cell[][] getCells() { // a vérifier ???
        Cell[][] copyCells = cells;
        return copyCells;
    }

    /**
     *
     * @return the position where Soko start.
     */
    public Position getStart() {
        return start;
    }

    /**
     * Place an item on a position of the board.
     *
     * @param item is the item to place on the board.
     * @param pos the position where the item will go.
     */
    public void put(Item item, Position pos) {
        if (!isInside(pos)) {
            throw new IllegalArgumentException("out of the maze");
        }
        cells[pos.getRow()][pos.getColumn()].put(item);
    }

    /**
     * Remove what's on a position of the board.
     *
     * @param pos the position.
     */
    public void remove(Position pos) {
        cells[pos.getRow()][pos.getColumn()].remove();
    }

    /**
     * check if a position contain a box.
     *
     * @param pos the position to check.
     * @return true if there is a box on that position.
     */
    boolean isBox(Position pos) {
        return (cells[pos.getRow()][pos.getColumn()].
                getItem().getType() == ItemType.BOX);
    }

    /**
     * check if a position contain a goal.
     *
     * @param pos the position to check.
     * @return true if there is a goal on that position.
     */
    public boolean isGoal(Position pos) {
        return (cells[pos.getRow()][pos.getColumn()].
                getItem().getType() == ItemType.GOAL || isBoxGoal(pos));
    }

    /**
     * check if a position contain a box on a goal.
     *
     * @param pos the position to check.
     * @return true if there is a box on a goal on that position.
     */
    public boolean isBoxGoal(Position pos) {
        return (cells[pos.getRow()][pos.getColumn()].
                getItem().getType() == ItemType.BOXGOAL);
    }

    /**
     * check if a position contain Soko on a goal.
     *
     * @param pos the position to check
     * @return true if there is Soko on a goal on that position.
     */
    public boolean isSokoGoal(Position pos) {
        return (cells[pos.getRow()][pos.getColumn()].
                getItem().getType() == ItemType.SOKOGOAL);
    }
}
