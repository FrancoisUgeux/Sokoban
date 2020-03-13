
package esi.atl.g43335.sokoban.view;

import esi.atl.g43335.sokoban.model.Cell;
import esi.atl.g43335.sokoban.model.items.*;

/**
 *
 * @author franc
 */
public class viewwwww {
    public void displayMaze(Cell[][] cells) {
        for (int i = 0; i < cells.length; i++) {
            for (Cell cell : cells[i]) {
                if (cell.isFree()) {
                    System.out.println(" ");
                } else if (cell.getItem() == new Goal()) {
                    System.out.println(".");
                } else if (cell.getItem()== new Wall()) {
                    System.out.println("#");
                } else if (cell.getItem() == new Player(0)) {
                    System.out.println("@");
                } else if (cell.getItem() == new Box()) {
                    System.out.println("$");
                }
            }
        }
    }

    
}
