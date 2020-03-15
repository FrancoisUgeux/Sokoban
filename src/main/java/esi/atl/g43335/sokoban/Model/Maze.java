package esi.atl.g43335.sokoban.model;

import esi.atl.g43335.sokoban.model.items.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

/**
 *
 * @author franc
 */
public class Maze {

    private static final int ROWS = 10;
    private static final int COLUMNS = 10;
    private final Cell[][] cells;
    private Game game;
    private Position start;
    private ArrayList<Position> boxes = new ArrayList();
    private ArrayList<Position> goals = new ArrayList();

    public Maze() {
        cells = new Cell[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                cells[i][j] = new Cell();
            }
        }
        //game.getCurrentLevel()
        levelBuilder("levelTest");
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

    public Cell getCell(Position position) {
        if (!isInside(position)) {
            throw new NullPointerException("out of board");
        }
        return cells[position.getRow()][position.getColumn()];
    }

    public ArrayList<Position> getBoxes() {
        return boxes;
    }

    public boolean isInside(Position position) {
        return (position.getRow() < cells.length
                && position.getRow() >= 0
                && position.getColumn() < cells[0].length
                && position.getColumn() >= 0);
    }

    public boolean isFree(Position p) {
        return cells[p.getRow()][p.getColumn()].isFree();
    }

    public Cell[][] getCells() { // a vérifier ???
        Cell[][] copyCells = cells;
        return copyCells;
    }

    public Position getStart() {
        return start;
    }
    
    

    public void put(Item item, Position pos) {
        if (!isInside(pos)) {
            throw new IllegalArgumentException("out of the maze");
        }
        cells[pos.getRow()][pos.getColumn()].put(item);
    }

    public void remove(Position pos) {
        cells[pos.getRow()][pos.getColumn()].remove();
    }

    public boolean isBox(Position pos) {
        return (cells[pos.getRow()][pos.getColumn()].
                getItem().getType() == ItemType.BOX);
    }

    public boolean isGoal(Position pos) {
        return (cells[pos.getRow()][pos.getColumn()].
                getItem().getType() == ItemType.GOAL);
    }

    public boolean isBoxGoal(Position pos) {
        return (cells[pos.getRow()][pos.getColumn()].
                getItem().getType() == ItemType.BOXGOAL);
    }

    public boolean isSokoGoal(Position pos) {
        return (cells[pos.getRow()][pos.getColumn()].
                getItem().getType() == ItemType.SOKOGOAL);
    }
}
