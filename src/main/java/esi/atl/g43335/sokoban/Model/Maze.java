package esi.atl.g43335.sokoban.model;

import esi.atl.g43335.sokoban.model.items.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

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
    private Game game;
    private Position start;
    private ArrayList<Position> boxes = new ArrayList();
    private ArrayList<Position> goals = new ArrayList();

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
        switch (level) {
            case 0:
                levelBuilder("levelTest");
                break;
            case 1:
                levelBuilder("level1");
                break;
            default:
                levelBuilder("levelTest");
        }
    }

    private void levelBuilder(String level) {
        int currentLine = 0;
        try ( BufferedReader reader = new BufferedReader(new FileReader(level))) {
            String line = reader.readLine();
            while (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    char item = line.charAt(i);
                    switch (item) {
                        case '#':
                            cells[currentLine][i] = new Cell(new Wall());
                            break;
                        case '$':
                            cells[currentLine][i] = new Cell(new Box());
                            boxes.add(new Position(currentLine, i));
                            break;
                        case '.':
                            Position posG = new Position(currentLine, i);
                            cells[currentLine][i] = new Cell(new Goal());
                            goals.add(posG);
                            break;
                        case '@':
                            start = new Position(currentLine, i);
                            cells[currentLine][i] = new Cell(new Player(0));
                            break;
                        case ' ':
                            cells[currentLine][i] = new Cell(new Floor());
                            break;
                        default:
                            break;
                    }
                }
                for (int i = Math.min(COLUMNS, line.length()); i < COLUMNS; i++) {
                    cells[currentLine][i] = new Cell(new Floor());
                }
                currentLine++;
                line = reader.readLine();
            }
        } catch (IOException exc) {
            System.out.println("error while creating the maze");
        }
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

    /**
     *
     * @return the list of boxes placed on the board.
     */
    public ArrayList<Position> getBoxes() {
        return boxes;
    }

    public void setStart(Position start) {
        this.start = start;
    }

    /**
     *
     * @param position is a position to check on the board.
     * @return true if this position is inside the board.
     */
    public boolean isInside(Position position) {
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
    public boolean isBox(Position pos) {
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
                getItem().getType() == ItemType.GOAL);
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
