package esi.atl.g43335.sokoban.view;

import esi.atl.g43335.sokoban.Model.Cell;
import esi.atl.g43335.sokoban.Model.CellType;

/**
 *
 * @author franc
 */
public class view {

    public void displayMaze(Cell[][] cells) {
        for (int i = 0; i < cells.length; i++) {
            for (Cell cell : cells[i]) {
                if (cell.getType() == CellType.EMPTY) {
                    System.out.println(" ");
                } else if (cell.getType() == CellType.GOAL) {
                    System.out.println(".");
                } else if (cell.getType() == CellType.WALL) {
                    System.out.println("#");
                } else if (false) {//player
                    System.out.println("@");
                } else if (true) {//caisse
                    System.out.println("$");
                }
            }
        }
    }
}
