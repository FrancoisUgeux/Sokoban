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

    private static final int ROWS = 40;
    private static final int COLUMNS = 40;
    private final Cell[][] cells;
    private Game game;
    private Position start;
    private ArrayList<Position> boxes;
    private ArrayList<Position> goals;
    private String level //a supprimer après gestion du xsb
            = "    ######\n"
            + "    ##   #\n"
            + "    ##$  #\n"
            + "  ####  $##\n"
            + "  ##  $ $ #\n"
            + "#### # ## #   ######\n"
            + "##   # ## #####  ..#\n"
            + "## $  $          ..#\n"
            + "###### ### #@##  ..#\n"
            + "    ##     #########\n"
            + "    ########\n";

    public Maze() {
        cells = new Cell[ROWS][COLUMNS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                cells[i][j] = new Cell();
            }
        }
        //game.getCurrentLevel()
        levelBuilder(); //doit appeler le fichier xsb
    }

    private void levelBuilder() {
        int currentLine = 0;
        try ( BufferedReader reader = new BufferedReader(new FileReader(level1))) {
            String line = reader.readLine();
            while (line != null) {
                line = reader.readLine();
                for (int i = 0; i < line.length(); i++) {
                    char item = line.charAt(i);
                    switch (item) {
                        case '#':
                            cells[currentLine][i] = new Cell(new Wall());
                            break;
                        case '$':
                            Position posB = new Position(currentLine,i);
                            Box b = new Box();
                            cells[currentLine][i] = new Cell(b);
                            boxes.add(posB);
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
            }
        } catch (IOException exc) {
            System.out.println("c 2 la mert");
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

    boolean isGoal(Position p) {
        for (Position goal : goals) {
            if (p.equals(goal)) {
                return false;
            }
        }
        return true;
    }

    public Cell[][] getCells() { // a vérifier ???
        Cell[][] copyCells = cells;
        return copyCells;
    }
    
    
}
